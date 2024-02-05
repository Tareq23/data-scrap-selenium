package com.thread.multitasking;

public class Thread1 extends Thread{

	public Thread1(String threadName)
	{
		super();
	}
	
	@Override
	public void run()
	{
		for(int i = 1; i < 5;  i++)
		{
			System.out.println("inside "+Thread.currentThread().getName()+" : "+i);
		}
	}
	
}
