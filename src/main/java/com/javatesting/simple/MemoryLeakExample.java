package com.javatesting.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 
 * use VisualVM
 * 
 * @author vijpande A Memory Leak is a situation when there are objects present
 *         in the heap that are no longer used, but the garbage collector is
 *         unable to remove them from memory and, thus they are unnecessarily
 *         maintained. A memory leak is bad because it blocks memory resources
 *         and degrades system performance over time. And if not dealt with, the
 *         application will eventually exhaust its resources, finally
 *         terminating with a fatal java.lang.OutOfMemoryError.
 *
 *         Reason : 1) Due to static field 2) Whenever we make a new connection
 *         or open a stream, the JVM allocates memory for these resources.
 *         
 *         Reference : https://www.baeldung.com/java-memory-leaks
 *
 */

public class MemoryLeakExample {
	static List<Double> list = new ArrayList<>();

	public static void main(String[] args) {

		//staticFieldTest();
		givenMap_whenEqualsAndHashCodeNotOverridden_thenMemoryLeak();
		
		// Requesting JVM to call Garbage Collector method 
        System.gc(); 
		
	}

	private static void givenMap_whenEqualsAndHashCodeNotOverridden_thenMemoryLeak() {
		System.out.println("Test : Improper equals() and hashCode() Implementations");
		Map<ModelClass, Integer> map = new HashMap<>();
		
		for (int i = 0; i < 100; i++) {
			map.put(new ModelClass(1, "jon", 18), 1);
		}

		System.out.println(map.size());
	}

	private static void staticFieldTest() {

		System.out.println("Debug Point 1");
		populateList();
		System.out.println("Debug Point 3");
	}

	public static void populateList() {
		// List<Double> list = new ArrayList<>();
		for (int i = 0; i < 10000000; i++) {
			list.add(Math.random());
		}
		System.out.println("Debug Point 2");
	}
	
	@Override
	protected void finalize() {
		System.out.println("############finalize method called");
	}


}
