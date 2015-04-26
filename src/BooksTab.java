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



public class BooksTab extends Tab {
	
	ArrayList<Object[]> booksList;
	String currentPath = ".";
	
	BooksTab(JPanel tab){
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
		
		
		add.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
				AddBook addb = new AddBook();
				addb.setSaveListener(new SaveListener() {
					
					@Override
					public void save(Book book) {
						try {
						String sql = "INSERT INTO LIBRARY (TITLE,AUTHOR,YEAR,QUANTITY,AVAILABLE) " +
			                    "VALUES ( '" + book.getTitle() + "' , '" + 
			        			book.getAuthor() + "', " + 
			                    book.getYear() + ", " + 
			        			book.getQuantity() + ", " + 
			                    book.getQuantity() + " );"; 
						stmt.executeUpdate(sql);
						c.commit();
						} catch (Exception e){
							
						}
						
					}
				});
				printFiles();
			}
		});
	}
	
	@Override
	public String[] columnNames() {
		return new String[]{"ID", "Title", "Author", "Year", "Quantity", "Available"};
	}

  public void printFiles(){
	  
		this.table.setRowCount(0);
		booksList = new ArrayList<Object[]>();
		
		int id;
		String title;
		String author;
		int quantity;
		int available;
		int year;
		
		try {
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
		         Object[] bookInfo = new Object[]{
							id,
							title,
							author,
							year,
							quantity,
							available
						};
		         this.table.addRow(bookInfo);
		         this.booksList.add(bookInfo);
		         
		      }
		      rs.close();
		      
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }
		
		/*try {
			this.currentPath = folder.getCanonicalPath();
			System.out.println(this.currentPath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}*/
	  }
	  
}
