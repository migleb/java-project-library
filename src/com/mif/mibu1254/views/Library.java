package com.mif.mibu1254.views;
/*
 * Author: Miglë Buèelytë
 */

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Library {
	
	public static void main (String[] args) {
		Library library = new Library();
		try {
			MainWindow mainWindow = new MainWindow();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
		/*
		Connection c = null;
	    Statement stmt = null;
	    try {
	 
	      
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      stmt = c.createStatement();
	      String sql = "INSERT INTO LIBRARY (ID,TITLE,AUTHOR,QUANTITY,AVAILABLE) " +
	                   "VALUES (6, 'Knyga6', 'Autorius6', 7, 7 );"; 
	      stmt.executeUpdate(sql);
	      /*stmt = c.createStatement();
	      
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM LIBRARY;" );
	      while ( rs.next() ) {
	         int id = rs.getInt("id");
	         String  title = rs.getString("title");
	         String author  = rs.getString("author");
	         int quantity = rs.getInt("quantity");
	         int available = rs.getInt("available");
	         System.out.println( "ID = " + id );
	         System.out.println( "TITLE = " + title );
	         System.out.println( "AUTHOR = " + author );
	         System.out.println( "QUANTITY = " + quantity );
	         System.out.println( "AVAILABLE = " + available );
	         System.out.println();
	      }
	      rs.close();
     
	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }*/
	    /*System.out.println("Operation done successfully");
	    
		/*Scanner s = new Scanner(System.in);
		try {
			System.out.println("Enter new book catalog name: ");
			String temp = s.nextLine();
			BookCatalog bookCatalog = new BookCatalog(temp);
			BookCatalog bookCatalog2 = new BookCatalog(temp + "2");
			System.out.println("Enter book title: ");
			String title = s.nextLine();
			System.out.println("Enter book author: ");
			String author = s.nextLine();
			System.out.println("Enter book year: ");
			String year = s.nextLine();
			System.out.println("Enter quantity: ");
			int quantity = s.nextInt();
			Book book1 = new Book("pav","aut","1999",5);
			Book book2 = new Book(title, author, year, quantity);
			Book book3 = new Book(title + "2", author, year);
			System.out.println("------------------");
			
			//printing info about books
			System.out.println("Books: ");
			book1.println();
			book2.println();
			book3.println();
			System.out.println("------------------");
			
			//adding books to catalogs
			bookCatalog.addBook(book1);
			bookCatalog.addBook(book2);
			bookCatalog.addBook(book3);
			bookCatalog2.addBook(book2);
			
			//printing info of catalogs
			System.out.println("Catalogs: ");
			bookCatalog.println();
			bookCatalog2.println();
			System.out.println("------------------");
			
			//Finding book with specific title (or title and author)
			System.out.println("Books that were found by title: ");
			ArrayList<Book> foundBooks = bookCatalog.findBooks("pav");
			if (foundBooks.size() > 0){
				for (Book b : foundBooks){
					b.println();
				}
			} else {
				System.out.println("No books were found.");
			}
			
		} finally {
			s.close();
		}*/
	}
	
	
}