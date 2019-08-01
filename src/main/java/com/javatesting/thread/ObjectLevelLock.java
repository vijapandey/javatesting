/**
 * 
 */
package com.javatesting.thread;

public class ObjectLevelLock implements Runnable {
	static int counter = 10;
	public void run() {
		Lock();
	}

	public void Lock() {
		System.out.println(Thread.currentThread().getName());
		synchronized (this) {
			System.out.println("in block " + Thread.currentThread().getName() + " counter: " +counter++);
			System.out.println("in block " + Thread.currentThread().getName() + " end");
		}
	}

	public static void main(String[] args) {
		ObjectLevelLock b1 = new ObjectLevelLock();
		Thread t1 = new Thread(b1);
		Thread t2 = new Thread(b1);
		ObjectLevelLock b2 = new ObjectLevelLock();
		Thread t3 = new Thread(b2);
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();
	}

}
