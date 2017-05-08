package com.example.studentrecord;

import java.util.ArrayList;
import java.util.List;

import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class StudentRecordDataSource {
	
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	
	private String[] allStudentColumns = { MySQLiteHelper.Student_Name,
	MySQLiteHelper.Student_CourseName, MySQLiteHelper.Student_Grade };
	
	private String[] allCourseColumns = {MySQLiteHelper.Course_ID, MySQLiteHelper.Course_Name };
	
	public StudentRecordDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
		}
	
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
		}
	
		public void close() {
		dbHelper.close();
		}
		
		//***********************REGION COURSE ********************************************//
		private Course cursorToCourse(Cursor cursor) {
			// Get the id out of the 0th column of the data row,
			// and the comment out of the 1st column of the data row.
			long id = cursor.getLong(0);
			String courseName = cursor.getString(1);
			// Create a new comment object
			Course course = new Course();
			// Set the id and the comment of the new comment object
			// to be the data from the row the cursor is pointing to.
			course.setCourseID(id);
			course.setName(courseName);
			
			return course;
			
			}
		
		public Course CreateCourse(String courseName){
			
			// Create the ContentValues object and add our comment to it
			ContentValues values = new ContentValues();
			values.put(MySQLiteHelper.Course_Name, courseName);
			
			// Insert the comment into the database
			// This returns the key associated with the comment we inserted
			long insertId = database.insert(MySQLiteHelper.TABLE_COURSES, null, values);
			
			// Query the database for the id that we just inserted
			Cursor cursor = database.query(MySQLiteHelper.TABLE_COURSES,
			allCourseColumns, MySQLiteHelper.Course_ID + " = " + insertId, null,
			null, null, null);
			
			// Move the cursor to the first row of the rows returned by the query
			cursor.moveToFirst();
			// Create a new comment out of this cursor
			Course newCourse = cursorToCourse(cursor);
			// Close the cursor
			cursor.close();
			return newCourse;
		}
		
		public void deleteCourse(Course course) {
			// Get the id of the comment we want to delete
			long id = course.getCourseID();
			// Execute the delete statement on the database
			database.delete(MySQLiteHelper.TABLE_COURSES, MySQLiteHelper.Course_ID
			+ " = " + id, null);
			}
		
		public List<Course> getAllCourses(){
			
			List<Course> courses = new ArrayList<Course>();
			// Execute a query on the database getting all the rows and all the columns
			Cursor cursor = database.query(MySQLiteHelper.TABLE_COURSES,
			allCourseColumns, null, null, null, null, null);
			// Move the cursor to the first row that the query returned
			cursor.moveToFirst();
			// While the cursor is still pointing to a row of data
			while (!cursor.isAfterLast()) {
			// Turn the row the cursor is pointing to into a comment
			Course course = cursorToCourse(cursor);
			// Add the new comment to our List of comments
			courses.add(course);
			// Move the cursor to poin
			}
			// Close the cursor
			cursor.close();
			return courses;
			
		}
		
		//**********************************REGION COURSE ENDS****************************************//
		
		//***********************REGION STUDENTS ********************************************//
				private Student cursorToStudent(Cursor cursor) {
					// Get the id out of the 0th column of the data row,
					// and the comment out of the 1st column of the data row.
					Integer grade = cursor.getInt(2);
					String courseName = cursor.getString(1);
					String studentName = cursor.getString(0);
					// Create a new comment object
					Student student = new Student();
					// Set the id and the comment of the new comment object
					// to be the data from the row the cursor is pointing to.
					student.setCourseName(courseName);
					student.setGrade(grade);
					student.setStudentName(studentName);
					
					return student;
					
					}
				
				public Student CreateStudent(String studentName, String courseName, Integer grade){
					
					// Create the ContentValues object and add our comment to it
					ContentValues values = new ContentValues();
					values.put(MySQLiteHelper.Student_Name, studentName);
					values.put(MySQLiteHelper.Student_CourseName, courseName);
					values.put(MySQLiteHelper.Student_Grade, grade);
					
					// Insert the comment into the database
					// This returns the key associated with the comment we inserted
					long insertId = database.insert(MySQLiteHelper.TABLE_STUDENTS, null, values);
					
					// Query the database for the id that we just inserted
					Cursor cursor = database.query(MySQLiteHelper.TABLE_STUDENTS,
					allStudentColumns, MySQLiteHelper.Student_Name + " = " + studentName, null,
					null, null, null);
					
					// Move the cursor to the first row of the rows returned by the query
					cursor.moveToFirst();
					// Create a new comment out of this cursor
					Student newStudent = cursorToStudent(cursor);
					// Close the cursor
					cursor.close();
					return newStudent;
				}
				
				public void deleteStudent(Student student) {
					// Get the id of the comment we want to delete
					String studentName = student.getStudentName();
					// Execute the delete statement on the database
					database.delete(MySQLiteHelper.TABLE_COURSES, MySQLiteHelper.Student_Name
					+ " = " + studentName, null);
					}
				
				public List<Student> getAllStudents(){
					
					List<Student> students = new ArrayList<Student>();
					// Execute a query on the database getting all the rows and all the columns
					Cursor cursor = database.query(MySQLiteHelper.TABLE_STUDENTS,
					allStudentColumns, null, null, null, null, null);
					// Move the cursor to the first row that the query returned
					cursor.moveToFirst();
					// While the cursor is still pointing to a row of data
					while (!cursor.isAfterLast()) {
					// Turn the row the cursor is pointing to into a comment
					Student student = cursorToStudent(cursor);
					// Add the new comment to our List of comments
					students.add(student);
					// Move the cursor to poin
					}
					// Close the cursor
					cursor.close();
					return students;
					
				}
				
                 public List<Student> getAllStudentsFromTheCourse(String courseName){
					
					List<Student> students = new ArrayList<Student>();
					// Execute a query on the database getting all the rows and all the columns
					Cursor cursor = database.query(MySQLiteHelper.TABLE_STUDENTS,
					allStudentColumns, MySQLiteHelper.Student_CourseName+"=?",new String[]{courseName}, null, null, null, null);
					// Move the cursor to the first row that the query returned
					cursor.moveToFirst();
					// While the cursor is still pointing to a row of data
					while (!cursor.isAfterLast()) {
					// Turn the row the cursor is pointing to into a comment
					Student student = cursorToStudent(cursor);
					// Add the new comment to our List of comments
					students.add(student);
					// Move the cursor to poin
					}
					// Close the cursor
					cursor.close();
					return students;
					
				}
				
				//**********************************REGION COURSE ENDS****************************************//
		
	
}
