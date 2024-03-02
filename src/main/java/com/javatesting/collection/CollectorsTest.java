package com.javatesting.collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.javatesting.simple.ModelClass;

public class CollectorsTest {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		System.out.println(sdf.format(new Date()));
		List<ModelClass> emp = getList();

		List<String> names = emp.stream().map(ModelClass::getName).collect(Collectors.toList());
		System.out.println(names);

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
