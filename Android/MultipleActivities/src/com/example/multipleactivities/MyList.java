package com.example.multipleactivities;

import java.util.ArrayList;
import java.util.List;

public class MyList {
	
	private static List<Item> list;
	
	public static void add(Item item)
	{
		if(list == null)
		{
			list = new ArrayList<Item>();
		}
		list.add(item);
	}
	
	public static String[] getStringArray()
	{
		if (list == null)
		{
			list = new ArrayList<Item>();
		}
		
		String[] array = new String[list.size()];
		for (int i=0; i<list.size(); i++)
		{
			array[i] = list.get(i).toString();
		}
		return array;
	}
	
}
