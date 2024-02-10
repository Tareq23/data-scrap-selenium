package com.demo.salespro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalesItem {
	
	
	private Date date;
	private String reference;
	private String biller;
	private String customer;
	private float grandTotal;
	private float paid;
	private float due;
	
	
	
	public SalesItem() {}
	
	public SalesItem(Date date, String reference, String biller, String customer, float grandTotal, float paid,
			float due) {
		super();
		this.date = date;
		this.reference = reference;
		this.biller = biller;
		this.customer = customer;
		this.grandTotal = grandTotal;
		this.paid = paid;
		this.due = due;
	}
	
	public Date getDate() {
		return date;
	}
	public String getReference() {
		return reference;
	}
	public String getBiller() {
		return biller;
	}
	public String getCustomer() {
		return customer;
	}
	public float getGrandTotal() {
		return grandTotal;
	}
	public float getPaid() {
		return paid;
	}
	public float getDue() {
		return due;
	}
	public void setDate(String dateString) {
        String pattern = "dd-MM-yyyy"; // Specify the pattern of the date string
        
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            // Parse the date string to a Date object
            Date date = dateFormat.parse(dateString);
            this.date = date;
//          System.out.println("Date object: " + date);
        } catch (ParseException e) {
            // Handle parsing exceptions
            e.printStackTrace();
        }
		
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setBiller(String biller) {
		this.biller = biller;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}
	public void setPaid(float paid) {
		this.paid = paid;
	}
	public void setDue(float due) {
		this.due = due;
	}

	@Override
	public String toString() {
		return "SalesItem [date=" + date + ", reference=" + reference + ", biller=" + biller + ", customer=" + customer
				+ ", grandTotal=" + grandTotal + ", paid=" + paid + ", due=" + due + "]\n]n";
	}
	
	

}
