package com.mif.mibu1254.views;
import java.util.ArrayList;

import com.mif.mibu1254.models.Book;


public class BookCatalog {
	private final int maxBooks = 1000;
	private String catalogName;
	private int totalBooksQuantityInCatalog = 0;
	private static int totalBooksQuantity = 0;
	private ArrayList<Book> books = new ArrayList<Book>();
	
	public BookCatalog(String catalogName){
		this.catalogName = catalogName;
	}
	
	public void addBook(Book book){
		if (!books.contains(book) && !this.isFull()) {
			books.add(book);
			totalBooksQuantityInCatalog += book.getQuantity();
			totalBooksQuantity += book.getQuantity();
		}
	}
	
	public boolean isFull(){
		if (this.totalBooksQuantityInCatalog == maxBooks){
			return true;
		} else return false;
	}
	
	public ArrayList<Book> findBooks(String title) {
		ArrayList<Book> matchingBooks = new ArrayList<Book>();
		for (Book b : books){
			if (b.getTitle().compareToIgnoreCase(title) == 0){
				matchingBooks.add(b);
			}
		}
		return matchingBooks;
	}
	
	public ArrayList<Book> findBooks(String title, String author) {
		ArrayList<Book> matchingBooks = new ArrayList<Book>();
		for (Book b : books){
			if (b.getAuthor().compareToIgnoreCase(author) == 0 && b.getTitle().compareToIgnoreCase(title) == 0){
				matchingBooks.add(b);
			}
		}
		return matchingBooks;
	}
	
	//setters and getters
	public int getTotalBooksQuantityInCatalog() {
		return this.totalBooksQuantityInCatalog;
	}

	public void setTotalBooksQuantityInCatalog(int totalBooksQuantity) {
		this.totalBooksQuantityInCatalog = totalBooksQuantity;
	}

	public String getCatalogName() {
		return this.catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public static int getTotalBooksQuantity() {
		return totalBooksQuantity;
	}

	public static void setTotalBooksQuantity(int totalBooksQuantity) {
		BookCatalog.totalBooksQuantity = totalBooksQuantity;
	}
	
	@Override
	public String toString(){
		return this.getCatalogName() + " " + this.getTotalBooksQuantityInCatalog() + " " + BookCatalog.getTotalBooksQuantity();
	}
	
}
