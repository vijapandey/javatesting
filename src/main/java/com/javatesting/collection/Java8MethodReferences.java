/**
 * 
 */
package com.javatesting.collection;

import java.util.function.Function;
import java.util.function.Supplier;

import com.javatesting.simple.ModelClass;

/**
 * @author vijpande
 *
 */
public class Java8MethodReferences {

	public static void main(String[] args) {

		// Calling parseInt() method using lambda
		Function<String, Integer> lambdaFunction1 = (String s) -> Integer.parseInt(s);
		System.out.println(lambdaFunction1.apply("12"));
		// Calling parseInt() method using method reference Method reference to static
		// method
		Function<String, Integer> referenceFunction1 = Integer::parseInt;
		System.out.println(referenceFunction1.apply("12"));

		// Calling toLowerCase() method using lambda
		Function<String, String> lambdaFunction2 = (String s) -> s.toLowerCase();
		System.out.println(lambdaFunction2.apply("JAVA"));
		// Calling toLowerCase() method using method reference
		Function<String, String> referenceFunction3 = String::toLowerCase;
		System.out.println(referenceFunction3.apply("JAVA"));

		// Calling getName() of c using lambda
		ModelClass c = new ModelClass(111, "John", 81);
		Supplier<String> lambdaSupplier = () -> c.getName();
		System.out.println(lambdaSupplier.get());
		// Calling getName() of c using method reference
		Supplier<String> referenceSupplier = c::getName;
		System.out.println(referenceSupplier.get());

		// Creating objects using lambda
		Supplier<ModelClass> lambdaSupplierModel = () -> new ModelClass();
		lambdaSupplierModel.get();
		// Creating objects using constructor references
		Supplier<ModelClass> referenceSupplierModel = ModelClass::new;
		referenceSupplierModel.get();

	}

}
