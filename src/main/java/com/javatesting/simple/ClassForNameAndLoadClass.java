/**
 * 
 */
package com.javatesting.simple;

/**
 * @author vijpande
 *
 */
public class ClassForNameAndLoadClass {
	public static void main(String[] args) {

		try {
			// For name
			Class cls = Class.forName("com.javatesting.simple.ModelClass");
			// returns the ClassLoader object
			ClassLoader cLoader = cls.getClassLoader();

			/*
			 * returns the Class object associated with the class or interface with the
			 * given string name, using the given classloader.
			 */
			Class cls2 = Class.forName("java.lang.Thread", true, cLoader);

			// returns the name of the class
			System.out.println("Class = " + cls.getName());
			System.out.println("Class = " + cls2.getName());

			// Load class
			ClassLoader classLoader = ClassForNameAndLoadClass.class.getClassLoader();
			Class aClass = classLoader.loadClass("com.javatesting.simple.ModelClass");
			System.out.println("aClass.getName() = " + aClass.getName());

		} catch (ClassNotFoundException ex) {
			System.out.println(ex.toString());
		}

	}

}
