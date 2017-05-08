package com.example.andriodapp3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AndroidApp_3 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_app_3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_android_app_3, menu);
        return true;
    }
}
