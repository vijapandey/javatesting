/**
 * 
 */
package com.javatesting.collection;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author vijpande
 *
 */
public class FailFastTest {
	public static void main(String[] args) throws InterruptedException {
		final ArrayList<String> names = new ArrayList<String>();
		names.add("User1");
		names.add("User2");
		names.add("User3"); 
		names.add("User4");

		Iterator<String> i = names.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
			names.add("asd");
		}
	
		// Lets consider a possibility of sharing this ArrayList with two threads

		// This thread will print the list items
		Thread displayThread = new Thread() {
			public void run() {
				try {
					Iterator<String> i = names.iterator();
					while (i.hasNext()) {
						System.out.println(i.next());
						Thread.sleep(5000);
					}
				} catch (ConcurrentModificationException e) {
					System.out.println("DisplayThread : There is a concurrent modification on this list");
				} catch (InterruptedException e) {
				}
			}
		};
		displayThread.start();
		//Thread.sleep(5000);
		Thread removeUserThread = new Thread() {
			public void run() {
				try {
					names.remove(2);
					System.out.println("User at index 2 removed successfully");
				} catch (ConcurrentModificationException e) {
					System.out.println("RemoveUserThread : There is a concurrent modification on this list");
				}
			}
		};
		removeUserThread.start();

	}
}
