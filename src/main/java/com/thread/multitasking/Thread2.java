package com.thread.multitasking;

public class Thread2 implements Runnable{

	
	
	public void run() {
		for(int i = 1; i <= 5; i++)
		{
			System.out.println("inside "+Thread.currentThread().getName()+" : "+i);
		}
	}

	
	
	
	
}
