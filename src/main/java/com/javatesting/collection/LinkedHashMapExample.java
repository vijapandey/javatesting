/**
 * 
 */
package com.javatesting.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author vijpande
 *
 */
public class LinkedHashMapExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 HashMap<String, String> hmap = new HashMap<String, String>(2, (float) 0.50);

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

}
