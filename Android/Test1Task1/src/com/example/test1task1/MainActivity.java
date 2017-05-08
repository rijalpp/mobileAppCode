package com.example.test1task1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void onButtonClick(View view){
    	
    	TextView textview = (TextView)findViewById(R.id.courseView);
    	RadioGroup courseReason = (RadioGroup)findViewById(R.id.careerReason);
    	
    	RadioButton reasonSelected = (RadioButton)findViewById(courseReason.getCheckedRadioButtonId());
    	String careerReasonString = reasonSelected.getText().toString();
    	
    	String studentName = ((EditText)findViewById(R.id.inputName)).getText().toString();
    	
    	if(studentName.equals("")){
    		
    		textview.setText("Please Enter your Name");
    	}
    	else{
    		textview.setText("Name: "+studentName+"\n\nReason: "+careerReasonString);
    	}
    	
    }
}
