package com.javatesting.simple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {
	public static void main(String[] args) throws IOException {
		try {
			SerializedObject();
			deserializedObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deserializedObject() throws IOException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
		Student s;
		try {
			s = (Student) in.readObject();
			System.out.println(s.id + " " + s.name + " " + s.age);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		in.close();
	}

	private static void SerializedObject() throws FileNotFoundException, IOException {
		Student s1 = new Student(211, "ravi", 22);// creating object
		// writing object into file
		FileOutputStream f = new FileOutputStream("f.txt");
		ObjectOutputStream out = new ObjectOutputStream(f);
		out.writeObject(s1);
		out.flush();
		out.close();
		f.close();
		System.out.println("success");
	}
}
