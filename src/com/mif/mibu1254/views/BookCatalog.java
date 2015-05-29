package com.mif.mibu1254.views;
import java.util.ArrayList;

import com.mif.mibu1254.models.Book;

/**
 * Book catalog for saving books.
 * 
 * @author Miglë
 *
 */
public class BookCatalog {
	private final int maxBooks = 1000;
	private String catalogName;
	private int totalBooksQuantityInCatalog = 0;
	private static int totalBooksQuantity = 0;
	public ArrayList<Book> books = new ArrayList<Book>();
	
	/**
	 * Constructor for BookCatalog that implements catalog name.
	 * 
	 * @param catalogName name of the catalog
	 */
	public BookCatalog(String catalogName){
		this.catalogName = catalogName;
	}
	
	/**
	 * Method that let us add a book to a catalog.
	 * 
	 * @param book book that we want to add to catalog
	 */
	public void addBook(Book book){
		if (!books.contains(book) && !this.isFull()) {
			books.add(book);
			totalBooksQuantityInCatalog += book.getQuantity();
			totalBooksQuantity += book.getQuantity();
		}
	}
	
	/**
	 * Overrides Object's method clone so that all the fields and the array list could be cloned.
	 */
	@Override
	public BookCatalog clone() {
		BookCatalog bc = new BookCatalog("newCatalog");
		bc.catalogName = catalogName + "new";
		bc.totalBooksQuantityInCatalog = totalBooksQuantityInCatalog;
		bc.totalBooksQuantity = totalBooksQuantity;
		bc.books = cloneList(books);
		return bc;
	}
	
	/**
	 * cloneList clones the array list of books for each book. 
	 * 
	 * @param bk array list of books to be cloned
	 * @return clone array list of cloned books
	 */
	public static ArrayList<Book> cloneList(ArrayList<Book> bk) {
		ArrayList<Book> clone = new ArrayList<Book>(bk.size());
		for (Book item: bk) clone.add(item.clone());
		return clone;
	}
	
	/**
	 * Method to check if book catalog is full or not
	 * 
	 * @return boolean value
	 */
	public boolean isFull(){
		if (this.totalBooksQuantityInCatalog == maxBooks){
			return true;
		} else return false;
	}
	
	/**
	 * Method for finding books by specific name
	 * 
	 * @param title name of the book that we want to find
	 * @return matchingBooks array list of found books
	 */
	public ArrayList<Book> findBooks(String title) {
		ArrayList<Book> matchingBooks = new ArrayList<Book>();
		for (Book b : books){
			if (b.getTitle().compareToIgnoreCase(title) == 0){
				matchingBooks.add(b);
			}
		}
		return matchingBooks;
	}
	
	/**
	 * Method for finding books by specific name and author
	 * 
	 * @param title name of the book that we want to find
	 * @param author author of the book that we want to find
	 * @return matchingBooks array list of books that we matched
	 */
	public ArrayList<Book> findBooks(String title, String author) {
		ArrayList<Book> matchingBooks = new ArrayList<Book>();
		for (Book b : books){
			if (b.getAuthor().compareToIgnoreCase(author) == 0 && b.getTitle().compareToIgnoreCase(title) == 0){
				matchingBooks.add(b);
			}
		}
		return matchingBooks;
	}
	
	/**
	 * Getter to get a total books quantity in catalog
	 * 
	 * @return totalBooksQuantityInCatalog
	 */
	public int getTotalBooksQuantityInCatalog() {
		return this.totalBooksQuantityInCatalog;
	}

	/**
	 * Setter to set the total books quantity
	 * 
	 * @param totalBooksQuantity quantity of books
	 */
	public void setTotalBooksQuantityInCatalog(int totalBooksQuantity) {
		this.totalBooksQuantityInCatalog = totalBooksQuantity;
	}

	/**
	 * Getter to get the name of the catalog
	 * 
	 * @return catalogName
	 */
	public String getCatalogName() {
		return this.catalogName;
	}

	/**
	 * Setter to set the catalog name
	 * 
	 * @param catalogName
	 */
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	/**
	 * Static getter to get the total books quantity
	 * 
	 * @return totalBooksQuantity
	 */
	public static int getTotalBooksQuantity() {
		return totalBooksQuantity;
	}

	/**
	 * Setter to set the total books quantity
	 * 
	 * @param totalBooksQuantity
	 */
	public static void setTotalBooksQuantity(int totalBooksQuantity) {
		BookCatalog.totalBooksQuantity = totalBooksQuantity;
	}
	
	/**
	 * Overrides method toString
	 * 
	 */
	@Override
	public String toString(){
		return this.getCatalogName() + " " + this.getTotalBooksQuantityInCatalog() + " " + BookCatalog.getTotalBooksQuantity();
	}
	
}
