package com.example.expensediary;

import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ActivityViewCategory extends Activity {
	
	HelperSessionManagement session;
	DataAccessManager manager;
	private ArrayAdapter<Category> adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_viewcategory);
	
	session = new HelperSessionManagement(this);
	if(session.isLoggedIn()){
		
	TextView tvWelcomeName = (TextView)findViewById(R.id.tvWelcomeName);
	tvWelcomeName.setText("Welcome "+ session.getUserDetails().getFullName());
	Button btnLogOut = (Button) findViewById(R.id.btnLogOut);
	
		
	manager = new DataAccessManager(this);
	manager.OpenForRetrieval();
	
	List<Category> values = manager.SelectCategoriesByUser(session.getUserID().toString());
	adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
	
	ListView lvCategoryList = (ListView) findViewById(R.id.lvCategoryList);
	lvCategoryList.setAdapter(adapter);
	}
	
	else{
		Intent intent = new Intent("com.example.expensediary.ACTIVITYLOGIN");
		startActivity(intent);
	}
	
	}
	
	public void onClick(View v){
		String newIntent ="";
		switch(v.getId()){
		
		case R.id.btnAddCategory:
			newIntent = "com.example.expensediary.ACTIVITYCATEGORY";
			break;
		case R.id.btnCancel:
			newIntent ="com.example.expensediary.ACTIVITYDASHBOARD";
			break;
		case R.id.btnLogOut:
			session.clearUserSession();
			newIntent ="com.example.expensediary.LOGIN";
			break;
		}
		
		Intent intent = new Intent(newIntent);
		startActivity(intent);
	}
	

}
