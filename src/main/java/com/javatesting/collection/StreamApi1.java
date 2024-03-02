/**
 * 
 */
package com.javatesting.collection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.javatesting.simple.ModelClass;

/**
 * @author vijpande
 *
 */
public class StreamApi1 {

	public static void main(String[] args) {
	
		List<ModelClass> users =  ModelClass.getList();
		ModelClass.displayModelClass(users);
		List<ModelClass> result = users.stream()
				.filter((user)->user.getAge()>20)
				.collect(Collectors.toList());
		
		List<ModelClass> res = users.stream()
				.filter((user)->user.getAge()>20)
				//.flatMapToInt(user -> Stream.mapToInt(user.getAge()))
				
				.filter((user)->user.getAge()>20)
				.collect(Collectors.toList());
		
		System.out.println("Results 1");
		
		ModelClass.displayModelClass(result);

		System.out.println("Results 2");

		System.out.println(" res : " + res);
		
	}

}


