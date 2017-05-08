package com.example.test1task2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
    
    public void onClick(View view) {
    	Intent intent = new Intent(this, Screen2.class);
    	startActivity(intent);
    	}
    
    @Override
    public void onStart() {
    super.onStart();
    Intent myIntent = getIntent();
    String messageReceived = myIntent.getStringExtra("My Messaage");
    //Toast.makeText(this, messageReceived, Toast.LENGTH_SHORT).show();
    TextView  txtViewData = ((TextView)findViewById(R.id.txtViewData));
    txtViewData.setText(messageReceived);
    }
}
