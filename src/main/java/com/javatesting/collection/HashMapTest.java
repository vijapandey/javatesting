/**
 * 
 */
package com.javatesting.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.javatesting.simple.ModelClass;

/**
 * @author vijpande
 *
 */
public class HashMapTest {

	public static void main(String[] args) {
		Map<ModelClass, Integer> map = new HashMap<ModelClass, Integer>();
		List<ModelClass> list = ModelClass.getList();
		int i = 0;
		for (Iterator<ModelClass> iterator = list.iterator(); iterator.hasNext();) {
			ModelClass modelClass = (ModelClass) iterator.next();
			map.put(modelClass, i++);
		}
      
		map.entrySet().stream().forEach(e-> System.out.println(e.getKey().getName()  + " ::: " + e.getValue())) ;
		
		System.out.println("#### SEARCHING ......");
		
		ModelClass key1 = new ModelClass(111, "John", 81);
		ModelClass key2 = new ModelClass(111, "John", 80);

	
		
		System.out.println("MAP key 1 hashcode  : " +key1.hashCode() + " Result :" + map.get(key1));
		System.out.println("MAP key 2 hashcode  : " +key2.hashCode() + " Result :" + map.get(key2));
		
		
	}

}
