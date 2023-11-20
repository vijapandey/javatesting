/**
 * 
 */
package com.javatesting.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.javatesting.simple.ModelClass;

/**
 * @author vijpande
 *
 */
public class FunctionalInterfaceExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<ModelClass> modelList = getList();

		System.out.println("Predicate Example ");
		// Predicate represents an operation which takes an argument T and returns a
		// boolean
		testPredicate(modelList);

		System.out.println("Consumer Example");
		// Consumer represents an operation which takes an argument and returns nothing.
		// Use this functional interface If you want to compose a lambda expression
		// which performs some operations on an object.
		testConsumer(modelList);
		
		System.out.println("Function Example");
		//Function represents an operation which takes an argument of type T and returns a result of type R. Use this functional interface if you want to extract some data from an existing data.
		testFunction(modelList);
		
		System.out.println("Supplier Example");
		//Supplier represents an operation which takes no argument and returns the results of type R. Use this functional interface when you want to create new objects.
		testSupplier(modelList);
		
	}

	private static void testSupplier(List<ModelClass> modelList) {
		Supplier<ModelClass> studentSupplier = () -> new ModelClass(111111, "New Student", 92);
        
		modelList.add(studentSupplier.get());
		
	}

	private static void testFunction(List<ModelClass> modelList) {
		Function<ModelClass, String> nameFunction = (ModelClass Student) -> Student.getName();
        
		List<String> studentNames = new ArrayList<String>();
		         
		for (ModelClass student : modelList) 
		{
		    studentNames.add(nameFunction.apply(student));
		}
		System.out.println("testFunction :" + studentNames);
		
	}

	private static void testConsumer(List<ModelClass> modelList) 
	{
		Consumer<ModelClass> percentageConsumer = (ModelClass student) -> { 
			System.out.print(student.getName() + " : " + student.getAge() +"   <----> ");
		};

		for (ModelClass student : modelList) 
		{ 
			percentageConsumer.accept(student);
		}

	}

	private static void testPredicate(List<ModelClass> modelList) {
		Predicate<ModelClass> mathematicsPredicate = (ModelClass student) -> student.getName().equals("Harsha");

		List<ModelClass> mathematicsStudents = new ArrayList<ModelClass>();

		for (ModelClass student : modelList) {
			if (mathematicsPredicate.test(student)) {
				mathematicsStudents.add(student);
			}
		}

		System.out.println(mathematicsStudents.size());

	}

	private static List<ModelClass> getList() {
		List<ModelClass> listOfModelClasss = new ArrayList<ModelClass>();
		listOfModelClasss.add(new ModelClass(999, "Jordan", 58));
		listOfModelClasss.add(new ModelClass(111, "John", 81));
		listOfModelClasss.add(new ModelClass(222, "Harsha", 79));
		listOfModelClasss.add(new ModelClass(333, "Ruth", 87));
		listOfModelClasss.add(new ModelClass(444, "Aroma", 63));
		listOfModelClasss.add(new ModelClass(555, "Zade", 83));
		listOfModelClasss.add(new ModelClass(666, "Xing", 58));
		listOfModelClasss.add(new ModelClass(777, "Richards", 72));
		listOfModelClasss.add(new ModelClass(888, "Sunil", 86));
		listOfModelClasss.add(new ModelClass(101010, "Chris", 89));
		return listOfModelClasss;
	}

}
