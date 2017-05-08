package com.example.expensediary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityDashBoard extends Activity implements OnClickListener  {

	HelperSessionManagement session;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		session = new HelperSessionManagement(this);
		
		if(session.isLoggedIn())
		{
		TextView tvWelcomeName = (TextView)findViewById(R.id.tvWelcomeName);
		
		TextView tvRecordMode =(TextView)findViewById(R.id.tvRecordMode);
		User loggedInUser = session.getUserDetails();
		String welcomeScreen = "Welcome "+loggedInUser.getFullName();
		String userRecordMode = session.getUserRecordMode();
		tvWelcomeName.setText(welcomeScreen);
		tvRecordMode.setText(userRecordMode);
		
		final Button btnLogOut = (Button)findViewById(R.id.btnLogOut);
		final Button btnAddExpense = (Button)findViewById(R.id.btnAddExpense);
		final Button btnCategory = (Button)findViewById(R.id.btnCategory);
		final Button btnSetBudget = (Button)findViewById(R.id.btnSetBudget);
		final Button btnViewExpense = (Button)findViewById(R.id.btnViewExpense);
		final Button btnViewBalance = (Button)findViewById(R.id.btnViewBalance);
		
		btnLogOut.setOnClickListener(this);
		btnAddExpense.setOnClickListener(this);
		btnCategory.setOnClickListener(this);
		btnSetBudget.setOnClickListener(this);
		btnViewExpense.setOnClickListener(this);
		btnViewBalance.setOnClickListener(this);
	}
		else
			session.logoutUser(); //TAKES THE USER TO LOGIN PAGE AGAIN.
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String intentValue  = "com.example.expensediary.ADDEXPENSE";
		switch(v.getId())
		{
		case R.id.btnLogOut:
			session.clearUserSession();
			intentValue ="com.example.expensediary.LOGIN";
			break;
		case R.id.btnCategory:
			intentValue = "com.example.expensediary.ACTIVITYCATEGORY";
			break;
		case R.id.btnSetBudget:
			intentValue = "com.example.expensediary.ACTIVITYSETBUDGET";
			break;
		case R.id.btnViewExpense:
			intentValue = "com.example.expensediary.ACTIVITYVIEWEXPENSEWITHCATEGORY";
			break;
		case R.id.btnViewBalance:
			intentValue = "com.example.expensediary.ACTIVITYVIEWBALANCE";
			break;
		}
		
		Intent intent = new Intent(intentValue);
		startActivity(intent);
	}

}
