package com.thread.multitasking;

import com.cochrane.review.Stack;

public class ThreadTesting {

	public static void main(String[] args) {

		
		Stack stack = new Stack(5);
		
		new Thread(() -> {
			int counter = 0;
			while(++counter < 10) {
				System.out.println("Pushed: "+stack.push(100));
			}
		}, "pusher").start();
		
		new Thread(() -> {
			int counter = 0;
			while(++counter < 10) {
				System.out.println("Popped: "+stack.pop());
			}
		}, "popper").start();
	
		
	}
	
	public static void threadCreation()
	{
		System.out.println("Main is starting");
		Thread   thread1 = new Thread1("thread1");
//		thread1.setDaemon(true);
		thread1.start();
		
		Thread thread2 = new Thread(new Thread2(), "thread2");
		thread2.start();
	
		System.out.println("Main is exiting");
	}

}
