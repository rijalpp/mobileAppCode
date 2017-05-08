package com.example.test1task2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class Screen2 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_screen2, menu);
        return true;
    }
    
    public void onClick(View view) {
    	EditText inputText = (EditText)findViewById(R.id.inputText);
    	String messageEntered = inputText.getText().toString();
    	Intent intent = new Intent(this, MainActivity.class);
    	intent.putExtra("My Messaage", "Task completed with data: "+messageEntered);
    	startActivityForResult(intent, 0);
    	
    	finish();
    	}
    public void onCancelClick(View view){
    	Intent intent = new Intent(this, MainActivity.class) ;
    	intent.putExtra("My Messaage", "Task Cancelled");
    	startActivityForResult(intent, 0);
    }
}
