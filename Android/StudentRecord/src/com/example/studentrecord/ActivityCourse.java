package com.example.studentrecord;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ActivityCourse extends Activity implements OnClickListener  {

	private ArrayAdapter<Course> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_courses);
		final Button btnAdd = (Button)findViewById(R.id.btnAdd);
		btnAdd.setOnClickListener(this);
	}
	
	public void AddCourse()
	{
		EditText edtCourseName = (EditText)findViewById(R.id.edtCourseName);
		 String thisCourseName =  edtCourseName.getText().toString();
		StudentRecordDataSource dataSource = new StudentRecordDataSource(this);
		dataSource.open();
		 dataSource.CreateCourse(thisCourseName);
		 dataSource.close();
	}
	
	public void GetAllCourses()
	{
		StudentRecordDataSource dataSource = new StudentRecordDataSource(this);
		dataSource.open();
		  List<Course> courses = dataSource.getAllCourses();
		 dataSource.close();
		 
		 adapter = new ArrayAdapter<Course>(this,
		 android.R.layout.simple_list_item_1, courses);
		 ListView listView = (ListView) findViewById(R.id.list);
		 listView.setAdapter(adapter);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		AddCourse();
		GetAllCourses();
	}

}
