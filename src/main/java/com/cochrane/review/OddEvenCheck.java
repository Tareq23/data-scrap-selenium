package com.cochrane.review;


public class OddEvenCheck extends Thread{
	  private int number;

	  OddEvenCheck(int number) {
	        this.number = number;
	    }

	    public void run() {
	        if (number % 2 == 0) {
	            System.out.println(number + " is even.");
	        } else {
	            System.out.println(number + " is odd.");
	        }
	   }
	    
	    public int getSquareValue() {
	    	return this.number * 2;
	    }
}
