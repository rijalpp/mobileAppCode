package com.example.studentrecord;

public class Course {
	
	public static final Integer MinGrade = 50;
	public static final Integer MaxGeade =100;
	private long courseID;
	private String Name;
	
	public long getCourseID() {
		return courseID;
	}
	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public String toString() {
		return "course ID=" + courseID + ",  Name=" + Name;
	}
}
