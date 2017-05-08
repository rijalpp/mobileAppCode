package com.example.expensediary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityForgotPassword extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//XML LAYOUT TO DISPLAY
		setContentView(R.layout.activity_forgotpassword);
		
		final Button btnSubmit = (Button)findViewById(R.id.btnSubmit);
		final Button btnCancel = (Button)findViewById(R.id.btnCancel);
		
		//SETTING ONCLICK LISTENER TO btnSubmit
		btnSubmit.setOnClickListener(new View.OnClickListener(){

			public void onClick(View v) {
				// TODO SEND EMAIL TO THE PROVIDED EMAIL ADDRESS 
				String email = ((EditText)findViewById(R.id.edtEmail)).toString();
				//PREPARE TO SEND THE EMAIL.
				String EmailAddresses[] = {email};
				String message = "Hello \n your passowrd is as follows: \n";
				
				//STARTS AN INTENT TO SEND EMAIL
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, EmailAddresses);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Password Retrieval");
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
				startActivity(emailIntent);
				
			}
		});
		
		//SETTING ONCLICK LISTENER TO btnCancel
		btnCancel.setOnClickListener( new View.OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent gotToLoginSection = new Intent("com.example.expensediary.LOGIN");
				startActivity(gotToLoginSection);
				
			}
		});
		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
