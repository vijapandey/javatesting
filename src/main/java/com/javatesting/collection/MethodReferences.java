/**
 * 
 */
package com.javatesting.collection;

import java.util.function.BiFunction;

/**
 * @author vijpande Types of Method References There are following types of
 *         method references in java
 *         https://www.javatpoint.com/java-8-method-reference
 *         Reference to a static method. 
 *         Reference to an instance method.
 *         Reference to a constructor.
 *
 */
public class MethodReferences {

	public static void main(String[] args) {
		// Referring static method
		Sayable sayable = MethodReferences::saySomething;
		// Calling interface method
		sayable.say();

		//Example 2
		BiFunction<Integer, Integer, Integer>adder = Arithmetic::add;  
		int result = adder.apply(10, 20);  
		System.out.println(result);  
		
	}

	public static void saySomething() {
		System.out.println("Hello, this is static method.");
	}


}

class Arithmetic {
	public static int add(int a, int b) {
		return a + b;
	}
}
interface Sayable {
	void say();
}
