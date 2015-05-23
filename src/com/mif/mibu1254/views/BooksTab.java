package com.mif.mibu1254.views;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mif.mibu1254.models.Book;



public class BooksTab extends Tab {
	
	private ArrayList<Object[]> booksList;
	String currentPath = ".";
	
	BooksTab(JPanel tab) throws ClassNotFoundException, SQLException, WrongYearException{
		super(tab);
		try {
		Class.forName("org.sqlite.JDBC");
	    c = DriverManager.getConnection("jdbc:sqlite:test.db");

	    stmt = c.createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS LIBRARY " +
                "(ID INTEGER PRIMARY KEY     AUTOINCREMENT," +
                " TITLE           TEXT    NOT NULL, " + 
                " AUTHOR            TEXT     NOT NULL, " + 
                " YEAR        INT  			NOT NULL, " + 
                " QUANTITY     INT 		  	NOT NULL, " + 
                " AVAILABLE         INT		NOT NULL)"; 
		stmt.executeUpdate(sql);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
	
	@Override
	public String[] columnNames() {
		return new String[]{"ID", "Title", "Author", "Year", "Quantity", "Available"};
	}

  public void printFiles() throws SQLException, ClassNotFoundException, WrongYearException{
	  
		this.table.setRowCount(0);
		booksList = new ArrayList<Object[]>();

		BookCatalog bc = new BookCatalog("My Catalog");
		
		int id;
		String title;
		String author;
		int quantity;
		int available;
		int year;
		
		
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);

		      stmt = c.createStatement();
		      
		      
		      
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM LIBRARY;" );
		      while ( rs.next() ) {
		         id = rs.getInt("id");
		         title = rs.getString("title");
		         author  = rs.getString("author");
		         year = rs.getInt("year");
		         quantity = rs.getInt("quantity");
		         available = rs.getInt("available");
		         Book book = new Book(
							id,
							title,
							author,
							String.valueOf(year),
							quantity,
							available
						);
		         bc.books.add(book);
		         
		      }
		      rs.close();
		      for ( Book book : bc.books  ) {
		    	 Object[] ob = new Object[] { 
		    			 book.getId(),
		    			 book.getTitle(),
		    			 book.getAuthor(),
		    			 book.getYear(),
		    			 book.getQuantity(),
		    			 book.getAvailable()
		    	 };
		         this.table.addRow(ob);
		         this.booksList.add(ob);
		         
		      }
		      
		      Book b = new Book(0,"","","1999",0,0);
		      BookCatalog newbc = bc.clone();
		      newbc.books.set(0, b);
		      
		      for ( Book book : newbc.books  ) {
			    	 Object[] ob = new Object[] { 
			    			 book.getId(),
			    			 book.getTitle(),
			    			 book.getAuthor(),
			    			 book.getYear(),
			    			 book.getQuantity(),
			    			 book.getAvailable()
			    	 };
			         this.table.addRow(ob);
			         this.booksList.add(ob);
			         
			  }
		      
		      stmt.close();
		      c.close();
		
		/*try {
			this.currentPath = folder.getCanonicalPath();
			System.out.println(this.currentPath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}*/
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		AddBook addb = new AddBook();
		try {
			addb.show(new SaveListener() {
				
				@Override
				public void save(Book book) throws ClassNotFoundException, SQLException, WrongYearException {
					try {
						String sql = "INSERT INTO LIBRARY (TITLE,AUTHOR,YEAR,QUANTITY,AVAILABLE) " +
			                    "VALUES ( '" + book.getTitle() + "' , '" + 
			        			book.getAuthor() + "', " + 
			                    book.getYear() + ", " + 
			        			book.getQuantity() + ", " + 
			                    book.getQuantity() + " );"; 
						stmt.executeUpdate(sql);
					} catch (Exception e){
						e.printStackTrace();
					}
					printFiles();
				}
			});
		} catch (WrongYearException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	  
}
