package com.javatesting.simple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayRemoveIndexValue {

	public static void main(String[] args) {

		// define original array
		int[] tensArray = { 10, 20, 30, 40, 50, 60, 0, 4, 3, 1};

		// Print the original array
		System.out.println("Original Array: " + Arrays.toString(tensArray));

		// the index at which the element in the array is to be removed
		int rm_index = 2;

		// display index
		System.out.println("Element to be removed at index: " + rm_index);

		// if array is empty or index is out of bounds, removal is not possible
		if (tensArray == null || rm_index < 0 || rm_index >= tensArray.length) {

			System.out.println("No removal operation can be performed!!");
		}
		// Create a proxy array of size one less than original array
		int[] proxyArray = new int[tensArray.length - 1];

		// copy all the elements in the original to proxy array except the one at index
		for (int i = 0, k = 0; i < tensArray.length; i++) {

			// check if index is crossed, continue without copying
			if (i == rm_index) {
				continue;
			}

			// else copy the element
			proxyArray[k++] = tensArray[i];
		}

		// Print the copied proxy array
		System.out.println("Array after removal operation: " + Arrays.toString(proxyArray));

		System.out.println("JAVA8 :Array after removal operation: "
				+ Arrays.toString(remove_Element_using_java_8(tensArray, rm_index)));

		System.out.println("SORT Array : ");
		sortedArray(tensArray);

		
	}

	public static int[] remove_Element_using_java_8(int[] myArray, int index) {
		if (myArray == null || index < 0 || index >= myArray.length) {
			System.out.println("non-existing index");
			return myArray;
		}
		// array to arrayList
		List<Integer> arrayList = IntStream.of(myArray).boxed().collect(Collectors.toList());
		// Remove the specified element
		arrayList.remove(index);

		// return the resultant array
		return arrayList.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void sortedArray(int[] intArray) {
		// print original array
		System.out.println("Original array: ");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
		// Sort the array in ascending order using two for loops
		for (int i = 0; i < intArray.length; i++) {
			for (int j = i + 1; j < intArray.length; j++) {
				if (intArray[i] > intArray[j]) { // swap elements if not in order
					int temp = intArray[i];
					intArray[i] = intArray[j];
					intArray[j] = temp;
				}
			}
		}
		// print sorted array
		System.out.println("\nArray sorted in ascending order: ");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}

	}

}
