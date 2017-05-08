package com.example.databaseexercise;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	private CommentsDataSource datasource;
	private ArrayAdapter<Comment> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     // Create a CommentsDataSource object and open it
        datasource = new CommentsDataSource(this);
        datasource.open();
        // Get all the comments currently in the database
        List<Comment> values = datasource.getAllComments();
        // Initialise the ArrayAdapter with the comments from the database
        adapter = new ArrayAdapter<Comment>(this, android.R.layout.simple_list_item_1, values);
     // Connect the adapter to the list
        ListView list = (ListView) findViewById(R.id.list);
        list.setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
