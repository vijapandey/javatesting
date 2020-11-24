package com.javatesting.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListMapExamples {

	public static void main(String[] args) {
		//arrayListExample();
		//linkedListExample();
		HashSetExample();
		HashMapExample();
		

	}

	private static void HashMapExample() {
		System.out.println("HASH MAP () ......................");
		 // Create a HashMap
	     //HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	     HashMap<String, String> hmap = new HashMap<String, String>();

	     //Hashtable<String, String> hmap = new Hashtable<String, String>();
	     
	     //add elements to HashMap
	     hmap.put("1", "AA");
	     hmap.put("4", "DD");
	     hmap.put("2", "BB");
	     hmap.put("3", "CC");
	     hmap.put("9", "CC");
	     hmap.put("8", "CC");
	     hmap.put("7", "CC");
	     hmap.put("5", "KK");
	     
	     // Displaying HashMap elements
	     System.out.println("HashMap contains: "+hmap);
	     
	     // Getting a Set of Key-value pairs
	     Set entrySet = hmap.entrySet();

	  // Obtaining an iterator for the entry set
	     Iterator it = entrySet.iterator();
	     
	     while(it.hasNext()){
	         Map.Entry me = (Map.Entry)it.next();
	         System.out.println("Key is: "+me.getKey() + 
	         " & " + 
	         " value is: "+me.getValue());
	     }
		
	}

	private static void HashSetExample() {
		System.out.println("HASH SET () ......................");

		 // Create a HashSet
	     HashSet<String> hset = new HashSet<String>();
	 
	     //add elements to HashSet
	     hset.add("AA");
	     hset.add("BB");
	     hset.add("DD");
	     hset.add("ZZ");
	     hset.add("CC");
	 
	     // Displaying HashSet elements
	     System.out.println("HashSet contains: " + hset);
	    // for(String temp : hset){   System.out.println(temp);	     }
		
	}

	private  static List<String> arrayListExample() {
		System.out.println("ARRAY LIST () ......................");
		/*  List Declaration */
		List<String> list = new ArrayList<String>();

		list.add("Item1");
		list.add("Item5");
		list.add("Item3");
		list.add("Item6");
		list.add("Item2");

		/* Display  List Content */
		System.out.println(" List Content: " + list);
		
		return list;
	}

	private  static List<String> linkedListExample() {		
		System.out.println("LINKED LIST () ......................");

		/* Linked List Declaration */
		LinkedList<String> linkedlist = new LinkedList<String>();

		/*
		 * add(String Element) is used for adding the elements to the linked list
		 */
		linkedlist.add("Item1");
		linkedlist.add("Item5");
		linkedlist.add("Item3");
		linkedlist.add("Item6");
		linkedlist.add("Item2");

		/* Display Linked List Content */
		System.out.println("Linked List Content: " + linkedlist);

		/* Add First and Last Element */
		linkedlist.addFirst("First Item");
		linkedlist.addLast("Last Item");
		System.out.println("LinkedList Content after addition: " + linkedlist);

		/* This is how to get and set Values */
		Object firstvar = linkedlist.get(0);
		System.out.println("First element: " + firstvar);
		linkedlist.set(0, "Changed first item");
		Object firstvar2 = linkedlist.get(0);
		System.out.println("First element after update by set method: " + firstvar2);

		/* Remove first and last element */
		linkedlist.removeFirst();
		linkedlist.removeLast();
		System.out.println("LinkedList after deletion of first and last element: " + linkedlist);

		/* Add to a Position and remove from a position */
		linkedlist.add(0, "Newly added item");
		linkedlist.remove(2);
		System.out.println("Final Content: " + linkedlist);
		return linkedlist;
	}
}
