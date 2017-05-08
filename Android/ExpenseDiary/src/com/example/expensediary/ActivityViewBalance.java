package com.example.expensediary;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityViewBalance extends Activity implements OnClickListener {
    
	HelperSessionManagement session;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewbalance);
		session = new HelperSessionManagement(this);
		if(session.isLoggedIn()){
		
		TextView tvWelcomeName = (TextView)findViewById(R.id.tvWelcomeName);
		tvWelcomeName.setText("Welcome "+ session.getUserDetails().getFullName());
		ImageView btnDashBoard = (ImageView) findViewById(R.id.btnDashBoard);
		Button btnLogOut = (Button) findViewById(R.id.btnLogOut);
		//Button btnViewBalance = (Button)findViewById(R.id.btnViewBalance);
		Button btnCancel = (Button)findViewById(R.id.btnCancel);
		
		//btnViewBalance.setOnClickListener(this);
		btnDashBoard.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		btnLogOut.setOnClickListener(this);
		
		ViewBalance();
		}
		
		else{
			session.logoutUser();
		}
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId())
		{
		//case R.id.btnViewBalance:
		//	break;
		case R.id.btnCancel:
			Intent goToDashBoard = new Intent("com.example.expensediary.ACTIVITYDASHBOARD");
			startActivity(goToDashBoard);
			break;
		case R.id.btnLogOut:
			session.logoutUser();
		}
		
	}
	
	public void ViewBalance(){
		Double totalExpense =0.00;
		try {
			DataAccessManager manager = new DataAccessManager(this);
			manager.OpenForRetrieval();
			List<Expense> expenseList = manager.SearchExpensesByUser(session.getUserDetails().getUserID().toString());
			manager.Close();
			
			for(Expense exp:expenseList){
				totalExpense += exp.getAmount();
			}
			
			manager.OpenForRetrieval();
			Goal goal = manager.SelectGoalsByUser(session.getUserDetails().getUserID().toString()).get(0);
			manager.Close();
			
			TextView tvViewBalance = (TextView)findViewById(R.id.tvViewBalance);
			tvViewBalance.setText("You have spent $"+totalExpense+" or "+(totalExpense/goal.getTargetExpense()) * 100+" % out of your goal $"+goal.getTargetExpense());
		} catch (SQLiteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IndexOutOfBoundsException e) {
			TextView tvViewBalance = (TextView)findViewById(R.id.tvViewBalance);
			tvViewBalance.setText("You don't have any Budget to view balance. Please add the budget first.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}