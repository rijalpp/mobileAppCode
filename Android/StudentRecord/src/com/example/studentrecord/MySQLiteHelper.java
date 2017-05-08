package com.example.studentrecord;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

	
	// The name of the table
	public static final String TABLE_COURSES = "Courses";
	public static final String TABLE_STUDENTS ="Students";
	// The names of the columns in the table
	public static final String Course_ID = "CourseID";
	public static final String Course_Name = "Name";
	
	public static final String Student_Grade = "Grade";
	public static final String Student_Name = "Name";
	public static final String Student_CourseName ="CourseName";
	// The name and version of the database
	private static final String DATABASE_NAME = "StudentRecords.db";
	private static final int DATABASE_VERSION = 1;
	// Database creation sql statement
	// Creates a table with 2 columns:
	// an auto-generated primary key (the id)
	// some text (the comment)
	private static final String COURSE_CREATE = "create table "
	+ TABLE_COURSES + "(" + Course_ID
	+ " integer primary key autoincrement, " + Course_Name
	+ " text not null);";
	
	private static final String STUDENT_CREATE = "create table "
			+ TABLE_STUDENTS + "(" + Student_Name
			+ " text not null,"+Student_CourseName+" text not null, "+Student_Grade+" integer not null);";
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(COURSE_CREATE);
		db.execSQL(STUDENT_CREATE);
	}
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		Log.w(MySQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
				+ newVersion + ", which will destroy all old data");
				db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSES);
				db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
				onCreate(db);
		
	}
	
	MySQLiteHelper (Context context){
		
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}

}
