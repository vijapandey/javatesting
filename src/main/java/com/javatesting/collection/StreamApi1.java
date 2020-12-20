/**
 * 
 */
package com.javatesting.collection;

import java.util.List;
import java.util.stream.Collectors;

import com.javatesting.simple.ModelClass;

/**
 * @author vijpande
 *
 */
public class StreamApi1 {

	public static void main(String[] args) {
	
		List<ModelClass> users =  ModelClass.getList();
		ModelClass.displayModelClass(users);
		List<ModelClass> result = users.stream().filter((user)->user.getAge()>20).
				collect(Collectors.toList());
		ModelClass.displayModelClass(result);
		
	}

}


