package com.example.studentrecord;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
         final Button btnStudents  = (Button)findViewById(R.id.btnStudents);
         final Button btnCourses  = (Button)findViewById(R.id.btnCourses);
         
         btnStudents.setOnClickListener(this);
         btnCourses.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		String intentName ="";
		switch(v.getId())
		{
		case R.id.btnStudents:
			intentName ="android.intent.action.ACTIVITYSTUDENT";
			break;
		case R.id.btnCourses:
			intentName = "android.intent.action.ACTIVITYCOURSE";
			break;
		}
		
		Intent intent = new Intent(intentName);
		startActivity(intent);
	}
}
