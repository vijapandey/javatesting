/**
 * 
 */
package com.javatesting.simple;

import java.io.Serializable;

/**
 * @author vijpande
 *
 */
public class ModelClass implements Serializable, Comparable {
	
	private static final long serialVersionUID = 1L;
	private int id = 0;
	private String name = null;
	private int age = 0;
	
	public ModelClass(Integer id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

    
	public int compareTo(Object o) {
		return this.id - ((ModelClass)o).id;
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
	public final void setName(final int age) {
		this.age = age;
	}

}
