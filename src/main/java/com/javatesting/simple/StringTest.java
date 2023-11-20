package com.javatesting.simple;

public class StringTest { 
	public static void main(String args[]) {

		String s1 = "Mango";
		String s2 = new String("Mango");
		String s3 = "Mango";

		if (s1 == s2) {
			System.out.println("s1 and s2 have the same reference");
		} else {
			System.out.println("s1 and s2 have different references"); // this is executed
		}

		if (s1 == s3) {
			System.out.println("s1 and s3 have the same reference"); // this is executed
		} else {
			System.out.println("s1 and s3 have different references");
		}
	}
}
