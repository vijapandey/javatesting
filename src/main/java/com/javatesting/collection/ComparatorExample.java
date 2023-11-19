package com.javatesting.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.javatesting.simple.ModelClass;

public class ComparatorExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		ArrayList<ModelClass> list = new ArrayList<ModelClass>();
		list.add(new ModelClass(2, "Force Awakens", 365));
		list.add(new ModelClass(1, "Star Wars", 12));
		list.add(new ModelClass(5, "Empire Strikes Back", 7));
		list.add(new ModelClass(3, "Return of the Jedi", 30));
		list.add(new ModelClass(4, "Aind", 31));

		Collections.sort(list);
		System.out.println("\nSorted by id");

		for (ModelClass model : list) {
			System.out.println(model.getId() + " " + model.getName() + "      " + model.getAge());
		}

		ComparatorExample coex = new ComparatorExample();
		NameCompare comp = coex.new NameCompare();
		Collections.sort(list, comp);
		System.out.println("\nSorted by name");

		for (ModelClass model : list) {
			System.out.println(model.getId() + " " + model.getName() + "      " + model.getAge());
		}

		// Call overloaded sort method with RatingCompare
		// (Same three steps as above)
		System.out.println("\nSorted by name");

	}

	// Class to compare by name
	public class NameCompare implements Comparator<ModelClass> {
		public int compare(ModelClass m1, ModelClass m2) {
			return m1.getName().compareTo(m2.getName());
		}
	}

}
