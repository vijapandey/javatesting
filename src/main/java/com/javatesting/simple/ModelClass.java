/**
 * 
 */
package com.javatesting.simple;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vijpande
 *
 */
public class ModelClass implements Serializable, Comparable {

	private static final long serialVersionUID = 1L;
	private Integer id = 0;
	private String name = null;
	private Integer age = 0;

	public ModelClass() {
	}

	static {
		System.out.println("BLOCK execting ......");
	}

	public ModelClass(Integer id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int compareTo(Object o) {
		return this.id - ((ModelClass) o).id;
	}

	/**
	 * @return the id
	 */
	public final Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public final int getAge() {
		return age;
	}

	/**
	 * @param name the name to set
	 */
	public final void setAge(final int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof ModelClass)) {
			return false;
		}
		ModelClass modelClass = (ModelClass) o;
		return modelClass.name.equals(name);
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + name.hashCode() + id.hashCode() + age.hashCode();
		return result;
	}

	@Override
	protected void finalize() {
		System.out.println("######### Model class finalize method called ##########");
	}

	public static List<ModelClass> getList() {
		List<ModelClass> listOfModelClasss = new ArrayList<ModelClass>();
		listOfModelClasss.add(new ModelClass(111, "John", 81));
		listOfModelClasss.add(new ModelClass(222, "Harsha", 79));
		listOfModelClasss.add(new ModelClass(333, "Ruth", 43));
		listOfModelClasss.add(new ModelClass(444, "Aroma", 63));
		listOfModelClasss.add(new ModelClass(555, "Zade", 10));
		listOfModelClasss.add(new ModelClass(666, "Xing", 58));
		listOfModelClasss.add(new ModelClass(777, "Richards", 72));
		listOfModelClasss.add(new ModelClass(888, "Sunil", 33));
		listOfModelClasss.add(new ModelClass(999, "Jordan", 18));
		listOfModelClasss.add(new ModelClass(101010, "Chris", 19));
		return listOfModelClasss;
	}

	public static void displayModelClass(List<ModelClass> listOfModelClasss) {
		System.out.println("############  List size  :" + listOfModelClasss.size());
		for (ModelClass model : listOfModelClasss) {
			System.out.println(model.getId() + ":  " + model.getName() + " : " + model.getAge());
		}
	}

}
