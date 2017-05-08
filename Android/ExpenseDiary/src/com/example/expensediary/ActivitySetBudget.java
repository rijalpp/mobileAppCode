package com.example.expensediary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivitySetBudget extends Activity implements OnClickListener {

	HelperSessionManagement session;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setbudget);
		//
		session = new HelperSessionManagement(this);
		if(session.isLoggedIn()){
		TextView tvWelcomeName = (TextView)findViewById(R.id.tvWelcomeName);
		tvWelcomeName.setText("Welcome "+ session.getUserDetails().getFullName());
		ImageView btnDashBoard = (ImageView) findViewById(R.id.btnDashBoard);
		Button btnLogOut = (Button) findViewById(R.id.btnLogOut);
		Button btnSetBudget = (Button)findViewById(R.id.btnSetBudget);
		Button btnViewBudget = (Button)findViewById(R.id.btnViewBudget);
		Button btnCancel = (Button)findViewById(R.id.btnCancel);
		
		btnDashBoard.setOnClickListener(this);
		btnSetBudget.setOnClickListener(this);
		btnViewBudget.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		btnLogOut.setOnClickListener(this);
		}
		else{
			session.logoutUser(); 
		}
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		String newIntent ="";
		switch(v.getId())
		{
		case R.id.btnSetBudget:
			//set budget to the database
			AddGoal();
			newIntent = "com.example.expensediary.ACTIVITYVIEWBUDGET";
			break;
		case R.id.btnViewBudget:
			newIntent ="com.example.expensediary.ACTIVITYVIEWBUDGET";
			break;
		case R.id.btnCancel:
		case R.id.btnDashBoard:
			newIntent = "com.example.expensediary.ACTIVITYDASHBOARD";
			break;
		case R.id.btnLogOut:
			newIntent ="com.example.expensediary.LOGIN";
			break;
		}
		
		Intent intent = new Intent(newIntent);
		startActivity(intent);
		
	}
	
	private Goal AddGoal(){
		
		EditText edtMonth = (EditText)findViewById(R.id.edtMonth);
		EditText edtYear =(EditText)findViewById(R.id.edtYear);
		EditText edtNote = (EditText)findViewById(R.id.edtNote);
		EditText edtAmount = (EditText)findViewById(R.id.edtAmount);
		
		Goal goal = new Goal();
		goal.setMonth(edtMonth.getText().toString());
		goal.setYear(edtYear.getText().toString());
		goal.setUserDetails(session.getUserDetails());
		goal.setTargetExpense(Double.parseDouble(edtAmount.getText().toString()));
		goal.setNote(edtNote.getText().toString());
		goal.setRecordMode(session.getUserRecordMode());
		
		DataAccessManager manager = new DataAccessManager(this);
		manager.OpenForInsertion();
		goal = manager.AddGoal(goal);
		manager.Close();
		
		return goal;
		
	}

}
