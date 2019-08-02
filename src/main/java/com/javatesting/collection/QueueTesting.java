package com.javatesting.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QueueTesting {

	public static List<Object> queueList = new LinkedList<Object>();

	static transient Object[] queueArray = new Object[3];

	private static final int MIN_INITIAL_CAPACITY = 8;

	private static int start = 0;

	private static int tail = queueArray.length - 1;

	public static void main(String[] args) {
		ArrayDeque<Object> a = new ArrayDeque<Object>();

		ArrayList<Object> inputList = new ArrayList<Object>();
		inputList.addAll(Arrays.asList(
				new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 }));

		for (int i = 0; i < inputList.size(); i++) {
			enqueue(inputList.get(i));
		}
		
		displayQueue();

		System.out.print("Dequeue...............");
		dequeue(2);
		
		displayQueue();
	}

	/**
	 * delete data in queue
	 */
	private static void dequeue(Integer numberToDelete) {

		if (queueArray != null) {
			int length = queueArray.length - numberToDelete;
			System.out.println(
					"Deque TOTAL :" + length + ", Tail : " + tail + ", queueArray.length :" + queueArray.length);
			// int copyInDestinationPos = length-queueArray.length;
			Object[] newQueueArray = new Object[length];
			System.arraycopy(queueArray, 0, newQueueArray, 0, length);
			queueArray = newQueueArray;

		}

	}

	/**
	 * Insert data in queue
	 */
	private static void enqueue(Object data) {
		System.out.print("Element :  " + data + " , ");
		addLast(data);
	}

	private static void addLast(Object data) {
		if (tail > -1) {
			queueArray[tail] = data;
			System.out.println("TAIL : " + tail);
			tail--;
		} else {
			copyElementsFromOldToNewArray();
			queueArray[tail] = data;
			tail--;
			System.out.println("TAIL : " + tail);
		}
	}

	private static void copyElementsFromOldToNewArray() {
		int length = queueArray.length * 2;
		int copyInDestinationPos = length - queueArray.length;
		Object[] newQueueArray = new Object[length];
		System.arraycopy(queueArray, 0, newQueueArray, copyInDestinationPos, queueArray.length);
		queueArray = new Object[length];
		queueArray = newQueueArray;
		tail = copyInDestinationPos - 1;
		// displayQueue(queueArray);
	}

	private static void displayQueue() {
		int total = queueArray.length - tail;
		System.out.println("TOTAL :" + total + ", Tail : " + tail + ", queueArray.length :" + queueArray.length);
		Object[] tmpQueueArray = new Object[total - 1];
		System.arraycopy(queueArray, tail + 1, tmpQueueArray, 0, total - 1);
		queueArray = tmpQueueArray;
		tail = -1;
		queueList = Arrays.asList(tmpQueueArray);
		for (Iterator iterator = queueList.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print("[" + object + "]");
		}
		System.out.println("");
	}

	private static int calculateSize(int numElements) {
		int initialCapacity = MIN_INITIAL_CAPACITY;
		if (numElements >= initialCapacity) {
			initialCapacity = numElements;
			initialCapacity++;
			if (initialCapacity < 0) // Too many elements, must back off
				initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
		}
		return initialCapacity;
	}
}
