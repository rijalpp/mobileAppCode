package com.example.multipleactivities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Additem extends Activity {

	private String msg;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }
    
    @Override
    public void onStart() {
    		super.onStart();
    		Intent myIntent = getIntent();
    		msg = myIntent.getStringExtra("message");
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_item, menu);
        return true;
    }
    
    public void onClick(View view) {
    		Intent returnTrip = new Intent();
    		switch(view.getId()) {
    		case R.id.inputDoneButton:
    			//do stuff here
    			EditText textBox = (EditText) findViewById(R.id.inputText);
    			EditText qtyBox = (EditText) findViewById(R.id.inputQty);
    			
    			String text = textBox.getText().toString();
    			String qty = qtyBox.getText().toString();
    			
    			returnTrip.putExtra("itemEntered", text);
    			returnTrip.putExtra("qtyEntered", qty);
    			
    			setResult(Activity.RESULT_OK, returnTrip);
    			finish();
    			break;
    		case R.id.inputCancelButton:
    			//do stuff here
    			setResult(Activity.RESULT_CANCELED, returnTrip);     
    			finish();
    			break;
    		default:
    			break;
    		}
    }
}
