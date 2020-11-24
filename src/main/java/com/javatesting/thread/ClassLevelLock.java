package com.javatesting.thread;

public class ClassLevelLock implements Runnable {

	public void run() {
		Lock();
	}

	public static synchronized void Lock() {
		System.out.println(Thread.currentThread().getName());
		//synchronized (ClassLevelLock.class) {
			System.out.println("in block " + Thread.currentThread().getName());
			System.out.println("in block " + Thread.currentThread().getName() + " end");
		//}
	}

	public static void main(String[] args) {
		ClassLevelLock b1 = new ClassLevelLock();
		Thread t1 = new Thread(b1);
		Thread t2 = new Thread(b1);
		ClassLevelLock b2 = new ClassLevelLock();
		Thread t3 = new Thread(b2);
		t1.setName("First Object thread 1: t1");
		t2.setName("First Object thread 2 t2");
		t3.setName("Second Object thread 1: t3 ");
		t1.start();
		t2.start();
		t3.start();
	}

}
