package com.example.expensediary;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ClipData.Item;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityViewExpenseWithCategory extends Activity {
	
	HelperSessionManagement session;
	DataAccessManager manager;
	private ArrayAdapter<Expense> adapter;
	
	private ArrayAdapter<String> adapterCategory;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_viewexpensewithcategory);
	
	session = new HelperSessionManagement(this);
	if(session.isLoggedIn()){
	
    TextView tvWelcomeName = (TextView)findViewById(R.id.tvWelcomeName);
	tvWelcomeName.setText("Welcome "+ session.getUserDetails().getFullName());
    Button btnLogOut = (Button) findViewById(R.id.btnLogOut);
	
	manager = new DataAccessManager(this);
	manager.OpenForRetrieval();
	List<Expense> values = manager.SearchExpensesByUser(session.getUserID().toString());
	manager.Close();
	adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
	
	ListView lvExpenseList = (ListView) findViewById(R.id.lvExpenseList);
	lvExpenseList.setAdapter(adapter);
	//
	//region of spinner starts
	Spinner spnCategories = (Spinner) findViewById(R.id.spnCategories);
	adapterCategory = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, android.R.id.text1,
			new ArrayList<String>());
	adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	//GET THE LIST OF CATEGORIES FROM DATABASE
	manager.OpenForRetrieval();
	List<Category> categoryList = manager.SelectCategoriesByUser(session.getUserDetails().getUserID().toString());
	
	for(Category category:categoryList){
		adapterCategory.add(category.getName());
	}
	
	manager.Close();
	
	spnCategories.setAdapter(adapterCategory);
	//region of spinner ends
	}
	
	else{
		Intent intent = new Intent("com.example.expensediary.ACTIVITYLOGIN");
		startActivity(intent);
	}
	
	}
	
	public void onClick(View v){
		String newIntent ="";
		Intent intent;
		switch(v.getId()){
		
		case R.id.btnAdd:
			newIntent = "com.example.expensediary.ADDEXPENSE";
			intent = new Intent(newIntent);
			startActivity(intent);
			break;
		case R.id.btnCancel:
			newIntent ="com.example.expensediary.ACTIVITYDASHBOARD";
			intent = new Intent(newIntent);
			startActivity(intent);
			break;
		case R.id.btnViewByCategory:
			GetExpenseByCategory();
			break;
		case R.id.btnLogOut:
			session.logoutUser();
			break;
		}
		
	}
	
	private void GetExpenseByCategory(){
		
		Spinner spnCategories = (Spinner) findViewById(R.id.spnCategories);
		String categoryName = spnCategories.getSelectedItem().toString();
		Log.v("Cagegory Name:  ", categoryName);
		
		manager = new DataAccessManager(this);
		
		manager.OpenForRetrieval();
		Category category = manager.SelectCategoriesByName(session.getUserDetails().getUserID().toString(), categoryName).get(0);
		List<Expense> values = manager.SearchExpensesByCategory(category.getCategoryID().toString());
		manager.Close();
		adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
		
		ListView lvExpenseList = (ListView) findViewById(R.id.lvExpenseList);
		lvExpenseList.setAdapter(adapter);
	}

}
