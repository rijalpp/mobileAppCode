package com.example.databaseexercise;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CommentsDataSource {
	
	public CommentsDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
		}
	
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
	MySQLiteHelper.COLUMN_COMMENT };
	
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
		}
	
		public void close() {
		dbHelper.close();
		}
		
		
		private Comment cursorToComment(Cursor cursor) {
			// Get the id out of the 0th column of the data row,
			// and the comment out of the 1st column of the data row.
			long id = cursor.getLong(0);
			String commentText = cursor.getString(1);
			// Create a new comment object
			Comment comment = new Comment();
			// Set the id and the comment of the new comment object
			// to be the data from the row the cursor is pointing to.
			comment.setId(id);
			comment.setComment(commentText);
			return comment;
			}
		
		public Comment createComment(String comment)
		{
			// Create the ContentValues object and add our comment to it
			ContentValues values = new ContentValues();
			values.put(MySQLiteHelper.COLUMN_COMMENT, comment);
			// Insert the comment into the database
			// This returns the key associated with the comment we inserted
			long insertId = database.insert(MySQLiteHelper.TABLE_COMMENTS, null,
			values);
			// Now that we have inserted the comment into the database,
			// we will return the corresponding Comment object to the user.
			// Query the database for the id that we just inserted
			Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
			allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
			null, null, null);
			// Move the cursor to the first row of the rows returned by the query
			cursor.moveToFirst();
			// Create a new comment out of
			// Create a new comment out of this cursor
			Comment newComment = cursorToComment(cursor);
			// Close the cursor
			cursor.close();
			return newComment;
		}
		
		public void deleteComment(Comment comment) {
			// Get the id of the comment we want to delete
			long id = comment.getId();
			// Execute the delete statement on the database
			database.delete(MySQLiteHelper.TABLE_COMMENTS, MySQLiteHelper.COLUMN_ID
			+ " = " + id, null);
			}
		public List<Comment> getAllComments(){
			List<Comment> comments = new ArrayList<Comment>();
			// Execute a query on the database getting all the rows and all the columns
			Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
			allColumns, null, null, null, null, null);
			// Move the cursor to the first row that the query returned
			cursor.moveToFirst();
			
			// While the cursor is still pointing to a row of data
			while (!cursor.isAfterLast()) {
			// Turn the row the cursor is pointing to into a comment
			Comment comment = cursorToComment(cursor);
			// Add the new comment to our List of comments
			comments.add(comment);
			// Move the cursor to point to the next row of data
			cursor.moveToNext();
			}
			
			// Close the cursor
			cursor.close();
			return comments;
			
		}
		
		

}
