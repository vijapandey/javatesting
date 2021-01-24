package com.javatesting.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author vijpande
 *
 */
public class Threading {

	public static void main(String arg[]) throws InterruptedException, ExecutionException, TimeoutException {
	      int nThreads = Runtime.getRuntime().availableProcessors();
	      System.out.println(nThreads);


		//runnableExecuter();
		callableExecuter();

	}

	private static void callableExecuter() throws InterruptedException, ExecutionException, TimeoutException {
		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(30);
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};

		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);

		System.out.println("future done? " + future.isDone() +", " + future.get());

		Integer result = future.get(2, TimeUnit.SECONDS);

		System.out.println("future done? " + future.isDone());
		System.out.println("result: " + result);
		
		executor.shutdownNow();
		
		
		System.out.println("After shutdown ,future done? " + future.get());

		

	}

	private static void runnableExecuter() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		});

		try {
			System.out.println("attempt to shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("tasks interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}

	}

}
