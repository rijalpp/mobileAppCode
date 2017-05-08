package com.example.expensediary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Expense {
	private Integer expenseID;
	private String expenseDate;
	private Category expenseCategory;
	private Double amount;
	private String description;
	private String recordMode;
	private Integer userID;
	
	//GETTER AND SETTER
	
	public Integer getUserID() {
		return userID;
	}
	
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	public Integer getExpenseID() {
		return expenseID;
	}
	
	public void setExpenseID(Integer expenseID) {
		this.expenseID = expenseID;
	}
	
	public String getExpenseDate() {
		return expenseDate;
	}
	
	public void setExpenseDate(String expenseDate) {
		this.expenseDate = expenseDate;
	}
	
	@Override
	public String toString() {
		
		String expenseDesc = "$"+amount+" on "+expenseDate+" for "+description;
		return expenseDesc;
	}

	public Category getExpenseCategory() {
		return expenseCategory;
	}
	
	public void setExpenseCategory(Category expenseCategory) {
		this.expenseCategory = expenseCategory;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRecordMode() {
		return recordMode;
	}
	
	public void setRecordMode(String recordMode) {
		this.recordMode = recordMode;
	}
	
	//METHODS
	public int AddExpense(Expense expense)
	{
		return expenseID;
		
	}
	
	public int UpdateExpense(Expense expense)
	{
		return expenseID;
	}
	
	public int DeleteExpense(Expense expense)
	{
		return 0;
	}
	
	public Expense SelectExpense(int expenseID)
	{
		return this;
	}
	
	public List<Expense> SearchExpense(Date expenseDate)
	{
		List<Expense> expenseList = new ArrayList<Expense>();
		return expenseList;
	}
	
	public List<Expense> SearchExpense(Date fromDate, Date toDate)
	{
		List<Expense> expenseList = new ArrayList<Expense>();
		return expenseList;
	}
	
	public List<Expense> SearchExpense(Category category)
	{
		List<Expense> expenseList = new ArrayList<Expense>();
		return expenseList;
	}
	
	public List<Expense> SearchExpense(Goal goal)
	{
		List<Expense> expenseList = new ArrayList<Expense>();
		return expenseList;
	}
	
	public double CompareExpenseToTargerGoal(Goal goal)
	{
		return 0.00;
	}
	
}
