package com.javatesting.simple;

public class Enum {

	public static void main(String[] args) {
		System.out.println("Enum are bad.");
	}

}

enum Day {

	SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

	private Integer action;

	Day(int i) {
		action = i;
	}
}