package com.example.weightconverter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WeightConverter extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClick(View view) {
    	EditText input = (EditText) findViewById(R.id.input);
    	String inputText = input.getText().toString();
    	new ConvertWeightTask(this, inputText).execute("");
    	}
    	public void displayResult(String s) {
    	TextView tv = (TextView) findViewById(R.id.output);
    	tv.setText("Got: "+s);
    	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
