package com.example.expensediary;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegistration extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		final Button btnRegister = (Button)findViewById(R.id.btnRegister);
		final Button btnCancel =(Button)findViewById(R.id.btnCancel);
		
		btnRegister.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
	}

	public void onClick(View args) {
		// TODO Auto-generated method stub
		switch(args.getId())
		{
		case R.id.btnRegister:
			EditText edtFullName = (EditText)findViewById(R.id.edtFullName);
			String fullName = edtFullName.getText().toString();
			EditText edtEmail = (EditText) findViewById(R.id.edtEmail);
			String email = edtEmail.getText().toString();
			EditText edtPassword = (EditText)findViewById(R.id.edtPassword);
			String password = edtPassword.getText().toString();
			//CREATING USER OBJECT AND ASSIGNING THE VALUES.
			User user = new User();
			user.setFullName(fullName);
			user.setEmail(email);
			user.setPassword(password);
			user.setRecordMode("LocalOnly");
			//CALLS THE METHOD BELOW.
			registerUser(user);
			   break;
		case R.id.btnCancel:
			Intent goBackToLogin = new Intent("com.example.expensediary.LOGIN");
			startActivity(goBackToLogin);
			break;
		}
	}
	
	private void registerUser(User user){
			try {
				DataAccessManager  manager = new DataAccessManager(this);
				manager.OpenForInsertion();
				User newObject = manager.CreateUser(user);
				manager.Close();
				if(newObject != null){
					HelperDialogManager dialogManager = new HelperDialogManager();
					dialogManager.showAlertDialog(this, "Congratulations!", "You are now registered and your user id is: "+newObject.getUserID()+" Please login to access the system.", false);
					Intent goBackToLogin = new Intent("com.example.expensediary.LOGIN");
					startActivity(goBackToLogin);
				}
				else
					Toast.makeText(this,"Opps! Error occured, please try again.", Toast.LENGTH_SHORT).show();
			} catch (SQLiteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}

