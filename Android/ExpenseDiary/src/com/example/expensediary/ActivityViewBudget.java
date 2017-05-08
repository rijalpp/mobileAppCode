package com.example.expensediary;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ActivityViewBudget extends Activity implements OnClickListener {

	private DataAccessManager manager;
	private ArrayAdapter<Goal> adapter;
	HelperSessionManagement session;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewbudget);
		//
		session = new HelperSessionManagement(this);
		if(session.isLoggedIn()){
		TextView tvWelcomeName = (TextView)findViewById(R.id.tvWelcomeName);
		tvWelcomeName.setText("Welcome "+ session.getUserDetails().getFullName());
		ImageView btnDashBoard = (ImageView) findViewById(R.id.btnDashBoard);
		Button btnLogOut = (Button) findViewById(R.id.btnLogOut);
		Button btnAddBudget = (Button)findViewById(R.id.btnAddBudget);
		Button btnCancel = (Button)findViewById(R.id.btnCancel);
		
		btnDashBoard.setOnClickListener(this);
		btnLogOut.setOnClickListener(this);
		btnAddBudget.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		//GET LISTVIEW
		manager = new DataAccessManager(this);
		manager.OpenForRetrieval();
		List<Goal> values = manager.SelectGoalsByUser(session.getUserDetails().getUserID().toString());
		manager.Close();
	
		adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
		ListView lsBudget = (ListView)findViewById(R.id.lsBudget);
		lsBudget.setAdapter(adapter);
		
		}
		else{
			session.logoutUser(); 
		}
	}
	
	public void onClick(View arg0) {
		String newIntent ="";
		switch(arg0.getId()){
		case R.id.btnAddBudget:
			newIntent = "com.example.expensediary.ACTIVITYSETBUDGET";
			break;
		case R.id.btnCancel:
		case R.id.btnDashBoard:
			newIntent = "com.example.expensediary.ACTIVITYDASHBOARD";
			break;
		case R.id.btnLogOut:
			session.logoutUser();
			break;
		}
		
		Intent intent = new Intent(newIntent);
		startActivity(intent);
		
	}

}
