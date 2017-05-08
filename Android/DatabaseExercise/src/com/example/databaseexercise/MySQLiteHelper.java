package com.example.databaseexercise;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
	
	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
	
	// The name of the table
	public static final String TABLE_COMMENTS = "comments";
	// The names of the columns in the table
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_COMMENT = "comment";
	
	// The name and version of the database
	private static final String DATABASE_NAME = "commments.db";
	private static final int DATABASE_VERSION = 1;
	// Database creation sql statement
	// Creates a table with 2 columns:
	// an auto-generated primary key (the id)
	// some text (the comment)
	private static final String DATABASE_CREATE = "create table "
	+ TABLE_COMMENTS + "(" + COLUMN_ID
	+ " integer primary key autoincrement, " + COLUMN_COMMENT
	+ " text not null);";
	@Override
	public void onCreate(SQLiteDatabase database) {
		// TODO Auto-generated method stub
		database.execSQL(DATABASE_CREATE);
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(MySQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
		onCreate(db);
	}

}
