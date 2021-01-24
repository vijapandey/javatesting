/**
 * 
 */
package com.javatesting.collection;

import java.io.Serializable;
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

		//simpleTest();
		problemStatement();

	}

	private static void problemStatement() {
		HashMapTest maptest = new HashMapTest();
		Map<Account, String> map = new HashMap<Account, String>();
		Account account1 = maptest.new Account(1000, "vijay");
		Account account2 = maptest.new Account(2000, "tanishq");
		
		map.put(account1, "India");
		map.put(account2, "SriLanka");

		System.out.println("hashcode: " + account1.hashCode() + " , value :" + map.get(account1));
		
		account1.accountNumber =40000;
		
		System.out.println("hashcode: " + account1.hashCode() + " , value :" + map.get(account1));

	}

	private static void simpleTest() {
		Map<ModelClass, Integer> map = new HashMap<ModelClass, Integer>();
		List<ModelClass> list = ModelClass.getList();
		int i = 0;
		for (Iterator<ModelClass> iterator = list.iterator(); iterator.hasNext();) {
			ModelClass modelClass = (ModelClass) iterator.next();
			map.put(modelClass, i++);
		}

		map.entrySet().stream().forEach(e -> System.out.println(e.getKey().getName() + " ::: " + e.getValue()));

		System.out.println("#### SEARCHING ......");

		ModelClass key1 = new ModelClass(111, "John", 81);
		ModelClass key2 = new ModelClass(111, "John", 80);

		System.out.println("MAP key 1 hashcode  : " + key1.hashCode() + " Result :" + map.get(key1));
		System.out.println("MAP key 2 hashcode  : " + key2.hashCode() + " Result :" + map.get(key2));

	}

	public class Account implements Serializable {
		private static final long serialVersionUID = 1L;
		private int accountNumber;
		@SuppressWarnings("unused")
		private String holderName;

		public Account(int accountNumber, String holderName) {
			this.accountNumber = accountNumber;
			this.holderName = holderName;
		}

		// Depends only on account number
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + accountNumber;
			return result;
		}

		// Compare only account numbers
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Account other = (Account) obj;
			if (accountNumber != other.accountNumber)
				return false;
			return true;
		}

	}
}
