package com.javatesting.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import com.javatesting.simple.ModelClass;

public class QueueTesting {

	public static List<Object> queueList = new LinkedList<Object>();

	static transient Object[] queueArray = new Object[3];

	private static final int MIN_INITIAL_CAPACITY = 8;

	private static int start = 0;

	private static int tail = queueArray.length - 1;

	public static void main(String[] args) throws InterruptedException {
		// ArrayDeque<Object> a = new ArrayDeque<Object>();

		System.out.println("Queue and Deque  Examples");
		// queueAndDeque();

		// queueAndDequeUsingArray();

		//BlockingQueue interface implementation:: ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, SynchronousQueue etc.
		arrayBlockingQueueDemo();
		linkedBlockingQueueDemo();
		priorityBlockingQueue();
	}

	private static void priorityBlockingQueue() throws InterruptedException {
		 // create object of PriorityBlockingQueue 
        // using PriorityBlockingQueue() constructor 
        PriorityBlockingQueue<ModelClass> pbq = new PriorityBlockingQueue<ModelClass>(); 
  
        // add  numbers 
        pbq.addAll(getList());
        
        // print queue 
        System.out.println("PriorityBlockingQueue:" ); 
        for (Iterator<ModelClass> itr = pbq.iterator(); itr.hasNext();) {
			System.out.print(itr.next().getId() + " ");
		}
        
      //Comparator for name field  Java 8 lambda based comparator syntax and verify the result
        Comparator<ModelClass> nameSorter = Comparator.comparing(ModelClass::getName);
        PriorityBlockingQueue<ModelClass> priorityBlockingQueue = new PriorityBlockingQueue<>( 11, nameSorter );
        priorityBlockingQueue.addAll(getList());
        while(true) 
        {
        	ModelClass e = priorityBlockingQueue.take();
            
            if(e == null) break;
            else {
            	System.out.println(e.getId() + ":::: "  +e.getName() +"\n");
            }
        }
       
        
        
	}

	private static void linkedBlockingQueueDemo() {
		// define capacity of LinkedBlockingQueue
		int capacity = 15;

		// create object of LinkedBlockingQueue
		LinkedBlockingQueue<Integer> lbq = new LinkedBlockingQueue<Integer>(capacity);

		// add numbers
		lbq.add(1);
		lbq.add(2);
		lbq.add(3);

		// print queue
		System.out.println("LinkedBlockingQueue:" + lbq);

	}

	private static void arrayBlockingQueueDemo() {
		// define capacity of ArrayBlockingQueue
		int capacity = 15;
		// create object of ArrayBlockingQueue
		// using ArrayBlockingQueue(int initialCapacity)
		// constructor
		ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<Integer>(capacity);

		// add numbers
		abq.add(1);
		abq.add(2);
		abq.add(3);
		// print queue
		System.out.println("ArrayBlockingQueue:" + abq);
	}

	private static void queueAndDeque() {
		Deque<String> deque = new LinkedList<String>();
		System.out.println("DEL:" + deque.poll());

		// We can add elements to the queue in various ways

		// Add at the last
		deque.add("Element 1 (Tail)");

		// Add at the first
		deque.addFirst("Element 2 (Head)");

		// Add at the last
		deque.addLast("Element 3 (Tail)");

		// Add at the first
		deque.push("Element 4 (Head)");

		// Add at the last
		deque.offer("Element 5 (Tail)");

		// Add at the first
		deque.offerFirst("Element 6 (Head)");

		System.out.println(deque + "\n");

		// We can remove the first element
		// or the last element.
		// deque.removeFirst();
		// deque.removeLast();
		// System.out.println("Deque after removing " + "first and last: " + deque);

		for (Iterator<String> itr = deque.iterator(); itr.hasNext();) {
			System.out.print(itr.next() + " ");
		}
		for (Iterator<String> itr = deque.iterator(); itr.hasNext();) {
			System.out.print(itr.next() + " ");
		}

		System.out.println(deque + "\n");

	}

	private static void queueAndDequeUsingArray() {
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
		System.out.print("copyElementsFromOldToNewArray:");
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
		for (Iterator<Object> iterator = queueList.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print("[" + object + "]");
		}
		System.out.println("");
	}

	@SuppressWarnings("unused")
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
	
	private static List<ModelClass> getList() {
		List<ModelClass> listOfModelClasss = new ArrayList<ModelClass>();
		listOfModelClasss.add(new ModelClass(111, "John", 81));
		listOfModelClasss.add(new ModelClass(222, "Harsha", 79));
		listOfModelClasss.add(new ModelClass(333, "Ruth", 87));
		listOfModelClasss.add(new ModelClass(444, "Aroma", 63));
		listOfModelClasss.add(new ModelClass(555, "Zade", 83));
		listOfModelClasss.add(new ModelClass(666, "Xing", 58));
		listOfModelClasss.add(new ModelClass(777, "Richards", 72));
		listOfModelClasss.add(new ModelClass(888, "Sunil", 86));
		listOfModelClasss.add(new ModelClass(999, "Jordan", 58));
		listOfModelClasss.add(new ModelClass(101010, "Chris", 89));
		return listOfModelClasss;
	}
}
