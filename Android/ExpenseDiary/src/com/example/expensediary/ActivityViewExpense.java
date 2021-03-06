package com.example.expensediary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityViewExpense extends Activity implements OnClickListener {
    HelperSessionManagement session;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewexpense);
		session = new HelperSessionManagement(this);
		if(session.isLoggedIn())
		{
		
		TextView tvWelcomeName = (TextView)findViewById(R.id.tvWelcomeName);
		tvWelcomeName.setText("Welcome "+ session.getUserDetails().getFullName());
		Button btnLogOut = (Button) findViewById(R.id.btnLogOut);
		
		ImageView btnDashBoard = (ImageView) findViewById(R.id.btnDashBoard);
		Button btnView = (Button)findViewById(R.id.btnView);
		Button btnCancel = (Button)findViewById(R.id.btnCancel);
		
		btnDashBoard.setOnClickListener(this);
		btnView.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		btnLogOut.setOnClickListener(this);
		}
		
		else
			session.logoutUser();
	}

	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.btnView:
			//CODE TO VIEW THE EXPENSES
			break;
		
		case R.id.btnCancel:
		case R.id.btnDashBoard:
			Intent goToDashBoard = new Intent("com.example.expensediary.ACTIVITYDASHBOARD");
			startActivity(goToDashBoard);
			break;
			
		case R.id.btnLogOut:
			session.logoutUser();
			break;
		}
		
	}

}
