/**
 * 
 */
package com.javatesting.collection;

/**
 * @author vijpande 
 * 			Java 8 Lambda Expressions can be defined as methods without
 *         names i.e anonymous functions. Like methods, they can have
 *         parameters, a body, a return type and possible list of exceptions
 *         that can be thrown
 * 
 *         Where To Use: Lambda expressions are used where an instance of
 *         functional interface is expected. Functional interface is an
 *         interface which has only one abstract method. Functional interfaces
 *         can have any number of default methods. But, they must have only one
 *         abstract method. Comparator, Runnable AndActionListener are some
 *         examples of functional interfaces
 *         
 *         benfits : Lambda expressions let you to write more clear, concise and flexible code.
 *
 */
public class LambdaExample {
	
	@FunctionalInterface
	public interface ComparatorExamples<T> {
		abstract int compare(T o1, T o2); // Only one abstract method
	}

	public static void main(String[] args) {
		
		ComparatorExamples<Object> coex = (Object i, Object j) -> { return (Integer)i - (Integer)j; };
		
		System.out.println(coex.compare(2, 3));
	}

}
