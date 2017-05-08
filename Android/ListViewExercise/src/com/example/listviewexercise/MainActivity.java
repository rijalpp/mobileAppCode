package com.example.listviewexercise;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ArrayAdapter<String> adapter;
	
	public void onClickAdd(View view)
	{
		EditText itemTextBox = (EditText)findViewById(R.id.inputItem);
		EditText qtyTextBox = (EditText)findViewById(R.id.inputQty);
		
		String item = itemTextBox.getText().toString();
		String qty = qtyTextBox.getText().toString(); 
		if(qty.equals(""))
		{
			qty = "0";
		}
		
		if(!item.equals("")){
			Item newItem = new Item(item, Integer.parseInt(qty));
			MyList.add(newItem);
			adapter.add(newItem.toString());
		}
		
		itemTextBox.setText("");
		qtyTextBox.setText("");
		
		((Button)view).setText("Add");
	}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, MyList.getStringList());
        ListView list = (ListView)findViewById(R.id.list); 
        list.setAdapter(adapter);
        TextWatcher watcher = new TextWatcher(){
        	
        	public void onTextChanged(CharSequence s, int start, int before, int count){
        		adapter.getFilter().filter(s.toString());
        		
        	}
        	
        	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        	}
        	public void afterTextChanged(Editable s) {
        		
        	}
        };
        
        EditText filterEditText = (EditText)findViewById(R.id.inputSearch);
        filterEditText.addTextChangedListener(watcher);
        
        OnItemClickListener clickListener = new OnItemClickListener(){
        	
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        		
        		Item toEdit = MyList.getItem(position);
        		// Put the item's name into the top EditText box
        		EditText inputItem = (EditText) findViewById(R.id.inputItem);
        		inputItem.setText(toEdit.getName());
        		// Put the item's quantity into the second EditText box
        		EditText inputQty = (EditText) findViewById(R.id.inputQty);
        		inputQty.setText(toEdit.getQty().toString());
        		// Change the button's text to say 'Update'
        		((Button)findViewById(R.id.button)).setText("Update");
        		// Remove the item from the list
        		adapter.remove(toEdit.toString());
        		MyList.removeItem(position);
        		
        	}
        	
        };
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setOnItemClickListener(clickListener);
        		 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
