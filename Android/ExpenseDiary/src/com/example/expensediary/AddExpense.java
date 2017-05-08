package com.example.expensediary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddExpense extends Activity {

	HelperSessionManagement session;
	private ArrayAdapter<String> adapter;
	private DataAccessManager manager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_expense);
		session = new HelperSessionManagement(this);
		if (session.isLoggedIn()) {
			
			manager = new DataAccessManager(this);
			Spinner spnCategories = (Spinner) findViewById(R.id.spnCategories);
			adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, android.R.id.text1,
					new ArrayList<String>());
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			//GET THE LIST OF CATEGORIES FROM DATABASE
			manager.OpenForRetrieval();
			List<Category> categoryList = manager.SelectCategoriesByUser(session.getUserDetails().getUserID().toString());
			
			for(Category category:categoryList){
				adapter.add(category.getName());
			}
			
			manager.Close();
			
			spnCategories.setAdapter(adapter);
			
			TextView tvWelcomeName = (TextView)findViewById(R.id.tvWelcomeName);
			tvWelcomeName.setText("Welcome "+ session.getUserDetails().getFullName());
			Button btnLogOut = (Button) findViewById(R.id.btnLogOut);
			Button btnAddExpense = (Button) findViewById(R.id.btnAddExpense);
			Button btnCancel = (Button) findViewById(R.id.btnCancel);
			// SET ONCLICK LISTENER FOR btnCancel
			btnAddExpense.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					AddExpense();

				}

			});
			
			btnLogOut.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					session.logoutUser();
				}

			});

			// SET ONCLICK LISTENER FOR btnCancel.
			btnCancel.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {

					Intent goToDashBoard = new Intent(
							"com.example.expensediary.ACTIVITYDASHBOARD");
					startActivity(goToDashBoard);
				}

			});
		}

		else
			session.logoutUser();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_add_expense, menu);
		return true;
	}
	
	private Expense AddExpense(){
		
		EditText edtExpenseDate  = (EditText)findViewById(R.id.edtExpenseDate);
		EditText edtExpenseAmount = (EditText)findViewById(R.id.edtExpenseAmount);
		Spinner spnCategories = (Spinner) findViewById(R.id.spnCategories);
		EditText edtDescription = (EditText)findViewById(R.id.edtDescription);
		//
		Expense expense = new Expense();
		expense.setAmount(Double.parseDouble(edtExpenseAmount.getText().toString()));

		expense.setExpenseDate(edtExpenseDate.getText().toString());
		expense.setDescription(edtDescription.getText().toString());
		expense.setExpenseCategory(GetCategory(spnCategories.getSelectedItem().toString()));
		expense.setRecordMode(session.getUserRecordMode());
		expense.setUserID(session.getUserDetails().getUserID());
		
		manager.OpenForInsertion();
		expense = manager.AddExpense(expense);
		manager.Close();
		
		return null;
		
	}
	
	private Category GetCategory(String categoryName){
		manager.OpenForRetrieval();
		Category c = manager.SelectCategoriesByName(session.getUserDetails().getUserID().toString(), categoryName).get(0);
		manager.Close();
		return c;
		
		
	}
	
}
