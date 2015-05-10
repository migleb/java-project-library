package com.mif.mibu1254.models;

import java.util.Calendar;

import com.mif.mibu1254.views.WrongYearException;


public class Book {
	
	private int quantity;
	private int id;
	private String title;
	private String author = "unknown";
	private String year;
	private int available;
	
	public Book(String title, String author, String year, int quantity, int available) throws WrongYearException {
		this.title = title;
		this.author = author;
		if (Integer.parseInt(year) < Calendar.getInstance().get(Calendar.YEAR)){
			this.year = year;
		} else {
			throw new WrongYearException();
		}
		this.quantity = quantity;
		this.available = available;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void println(){
		System.out.println(this.getTitle() + " " + this.getAuthor() + " " + this.getYear() + " " + this.getQuantity());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
