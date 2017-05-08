package com.example.multipleactivities;



import android.os.Bundle;
import android.app.Activity;
import android.app.LauncherActivity.ListItem;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MultipleActivities extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }
   

	private void updateList()
    {
    	ListView listView = (ListView) findViewById (R.id.listView);
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, MyList.getStringArray());
    	listView.setAdapter(adapter);
    }
    
   
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_multiple_activities, menu);
        return true;
    }
    
    public void onClickOkay(View view) {
    		String dataToSend = "hello";
    		Intent toSecondScreen = new Intent(this, AddItem.class);
    		toSecondScreen.putExtra("message", dataToSend);
    		startActivityForResult(toSecondScreen, 0);   		
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    		super.onActivityResult(requestCode, resultCode, data);
    		if(resultCode == Activity.RESULT_OK) {
    			
    			String item = data.getStringExtra("itemEntered");
    			String qty = data.getStringExtra("qtyEntered");
    			
    			Item newItem = new Item(item, Integer.parseInt(qty));
    			MyList.add(newItem);
    			updateList();
    		
    	}
}
}
