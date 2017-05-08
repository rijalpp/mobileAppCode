package com.example.expensediary;

import java.util.ArrayList;
import java.util.List;

public class Category {
	@Override
	public String toString() {
		return "categoryID= " + categoryID + ", name= " + name+ ", description=" + description + ", recordMode=" + recordMode;
	}

	private Integer categoryID;
	private String name;
	private String description;
	private User userDetails;
	private List<Expense> expenseList;
	private String recordMode;
	
	//GETTER AND SETTER
	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	
	public List<Expense> getExpenseList() {
		return expenseList;
	}

	public void setExpenseList(List<Expense> expenseList) {
		this.expenseList = expenseList;
	}
	
	public String getRecordMode() {
		return recordMode;
	}
	
	public void setRecordMode(String recordMode) {
		this.recordMode = recordMode;
	}
	
	//METHODS
	public int AddCategory(Category category)
	{
		return 0;
	}
	
	public int UpdateCategory(Category category)
	{
		return 0;
	}
	
	public Category SelectCategory(int categoryID)
	{
		return this;
	}
	
	public Category SelectCategory(String name)
	{
		return this;
	}
	
	public List<Category> SearchCategory(String name)
	{
		List<Category> categoryList = new ArrayList<Category>();
		return categoryList;
	}
	
	public List<Category> SearchCategory(User user)
	{
		List<Category> categoryList = new ArrayList<Category>();
		return categoryList;
	}
	
}
