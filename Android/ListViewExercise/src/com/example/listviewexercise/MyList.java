package com.example.listviewexercise;

import java.util.ArrayList;
import java.util.List;

public class MyList {
	
	private static List<Item> list;
	public static void add(Item item) {
	if (list == null) {
	list = new ArrayList<Item>();
	}
	list.add(item);
	}
	public static ArrayList<String> getStringList() {
	if (list == null) {
	list = new ArrayList<Item>();
	}
	ArrayList<String> strings = new ArrayList<String>();
	for (Item i : list) {
	strings.add(i.toString());
	}
	return strings;
	}
	public static Item getItem(int index) {
	return list.get(index);
	}
	public static void removeItem(int index) {
	list.remove(index);
	}

}
