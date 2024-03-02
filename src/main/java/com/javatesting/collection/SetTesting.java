package com.javatesting.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTesting {

	public static void main(String[] args) {
		Set<String> hashset = new HashSet<>(); 
		hashset.add("vijay2");
		hashset.add("vijay1");	
		hashset.add(null);
		hashset.add("vijay1");	
		hashset.add(null);
		System.out.println("hashset: " + hashset);

		
		Set<String> treeset = new TreeSet<>(); 
		treeset.add("vijay2");
		treeset.add("vijay1");	
		//treeset.add(null);	
		treeset.add("vijay1");	
		
		System.out.println("TreeSet: " + treeset);
	}

}
