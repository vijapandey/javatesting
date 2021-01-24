package com.javatesting.simple;

import java.util.Arrays;
import java.util.List;

/***
 * Unchecked Exception List
		ArrayIndexOutOfBoundsException
		StringIndexOutOfBoundsException
		ClassCastException
		IllegalArgumentException
		IllegalStateException
		NullPointerException
		NumberFormatException
		NegativeArraySizeException
		AssertionError
		ExceptionInInitializerError
		StackOverflowError
		NoClassDefFoundError
		ConcurrentModificationException
		MissingResourceException
		UnsupportedOperationException
		

Checked Exception List
		Exception
		CloneNotSupportedException
		IOException
		FileNotFoundException
		ParseException
		ClassNotFoundException
		CloneNotSupportedException
		InstantiationException
		IllegalAccessException
		InterruptedException
		InterruptedException
		NoSuchMethodException
		NoSuchFieldException
		InvalidClassException
		NotSerializableException
		SocketException
		BindException
		UnknownServiceException
		
 * 
 * @author vijpande
 *
 */
public class CheckedAndUncheckedException {

	public static void main(String[] args) {
		//UnsupportedOperationException
		String[] flowers = { "Ageratum", "Allium", "Poppy", "Catmint" }; 
		List<String> flowerList = Arrays.asList(flowers); 
		flowerList.add("Celosia");

	}

}
