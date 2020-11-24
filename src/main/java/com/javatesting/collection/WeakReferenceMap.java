/**
 * 
 */
package com.javatesting.collection;

import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;

import com.javatesting.simple.ModelClass;

/**
 * @author vijpande there are four kind of reference in Java :
 * 
 *         Strong reference, Weak Reference, Soft Reference, Phantom Reference
 *
 */
public class WeakReferenceMap {

	public static void main(String[] args) {
		Properties prop = new Properties();
		System.out.println("property value : " + prop.getProperty("test"));
		
		Key key1 = new Key("ACTIVE");
		Key key2 = new Key("INACTIVE");
		WeakHashMap<Key, ModelClass> map = new WeakHashMap<Key, ModelClass>();
		map.put(key1, new ModelClass(1, "Vijay", 3));
		map.put(key2, new ModelClass(2, "Anil", 4));

		key1 = null;
		
		System.gc();
		
		for (Map.Entry<Key, ModelClass> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey().getKey() + ", Value = " + entry.getValue().getId()); 
		}
		
		key2 = null;
		
		for (Map.Entry<Key, ModelClass> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey().getKey() + ", Value = " + entry.getValue().getId()); 
		}
	}

	
}


class Key {
	private String key;
	
	public Key(final String key) {
		super();
		this.key = key;
	}

	/**
	 * @return the key
	 */
	public final String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public final void setKey(String key) {
		this.key = key;
	}
	
}
