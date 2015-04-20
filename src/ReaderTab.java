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


public class ReaderTab extends Tab {
	
	DefaultTableModel table;
	ArrayList<Object[]> booksList;
	String currentPath = ".";
	
	ReaderTab(JPanel tab){
		try {
			Class.forName("org.sqlite.JDBC");
		    c = DriverManager.getConnection("jdbc:sqlite:test.db");

		    stmt = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS READER " +
	                "(ID INTEGER PRIMARY KEY     AUTOINCREMENT," +
	                " NAME           TEXT    NOT NULL, " + 
	                " SURNAME            TEXT     NOT NULL, " + 
	                " ADDRESS        INT  			NOT NULL, " +
	                " BOOKSTAKEN         INT		NOT NULL)"; 
			stmt.executeUpdate(sql);
		} catch (Exception e) {
				e.printStackTrace();
		}
		finally {
				
		}
		lineBox.add(add);
		add.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
				printFiles();
			}
		});
	    lineBox.add(edit);
	    tab.add(lineBox, BorderLayout.NORTH);
	    
	    String[] columnNames = {"ID", "Name", "Surname", "Address", "Books Taken"};
	    this.table = new BooksTableModel(columnNames, 0);
		JTable dataTable = new JTable(this.table);
		
		dataTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if (e.getClickCount() == 2){
					JTable target = (JTable)e.getSource();
					int row = target.getSelectedRow();
				}
			}
		});
	    
	    printFiles();
		
		JScrollPane scrollPane = new JScrollPane(dataTable);
		tab.add(scrollPane);
	}
	
	private void printFiles() {
		
		this.table.setRowCount(0);
		booksList = new ArrayList<Object[]>();
		
		int id;
		String name;
		String surname;
		String address;
		int bookstaken;
		
	    try {
	    	Class.forName("org.sqlite.JDBC");
	    	c = DriverManager.getConnection("jdbc:sqlite:test.db");
	    	c.setAutoCommit(false);

	      	stmt = c.createStatement();
	      	
	      	ResultSet rs = stmt.executeQuery( "SELECT * FROM READER;" );
		      while ( rs.next() ) {
		         id = rs.getInt("id");
		         name = rs.getString("name");
		         surname  = rs.getString("surname");
		         address = rs.getString("address");
		         bookstaken = rs.getInt("bookstaken");
		         Object[] bookInfo = new Object[]{
							id,
							name,
							surname,
							address,
							bookstaken
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
	}

}
