package com.example.expensediary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Goal {
	@Override
	public String toString() {

		String goalDetails = "Budget in "+month+" "+year+" is: $"+targetExpense;
		
		return goalDetails;
	}

	private Integer goalID;
	private String month;
	private String year;
	private Double targetExpense;
	private User userDetails;
	private String note;
	private String recordMode;
	
	//Properties
	public Integer getGoalID() {
		return goalID;
	}
	
	public void setGoalID(Integer goalID) {
		this.goalID = goalID;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public Double getTargetExpense() {
		return targetExpense;
	}
	
	public void setTargetExpense(Double targetExpense) {
		this.targetExpense = targetExpense;
	}
	
	public User getUserDetails() {
		return userDetails;
	}
	
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getRecordMode() {
		return recordMode;
	}
	
	public void setRecordMode(String recordMode) {
		this.recordMode = recordMode;
	}
	
	//methods
	public Integer AddGoal(Goal goal)
	{
		return 0;
	}
	
	public Integer UpdateGoal(Goal goal)
	{
		return 0;
	}
	
	public Integer DeleteGoal(Goal goal)
	{
		return 0;
	}
	
	public Goal SelectGoal(Integer goalID)
	{
		
		return  this;
	}
	
	public Goal SelectGoal(String month, String year)
	{
		return this;
	}
	
	public List<Goal> SearchGoalsByDateRange(Date fromDate, Date toDate)
	{
		 List<Goal> goalList = new ArrayList<Goal>();
		 return goalList;
	}
	
}
