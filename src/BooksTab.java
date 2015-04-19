import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class BooksTableModel extends DefaultTableModel{
	
	public BooksTableModel(String[] columnNames, int i){
		super(columnNames, i);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {                
		return false;
	};
}

public class BooksTab extends Tab {
	
	  DefaultTableModel table;
	  ArrayList<Object[]> booksList;
	  String currentPath = ".";
	
	BooksTab(JPanel tab){
		
		lineBox.add(add);
		add.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
				AddBook addb = new AddBook();
				printFiles();
			}
		});
	    lineBox.add(edit);
	    tab.add(lineBox, BorderLayout.NORTH);
	    
	    String[] columnNames = {"ID", "Title", "Author", "Year", "Quantity", "Available"};
	    this.table = new BooksTableModel(columnNames, 0);
		JTable dataTable = new JTable(this.table);
		
		dataTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if (e.getClickCount() == 2){
					JTable target = (JTable)e.getSource();
					int row = target.getSelectedRow();
					
					analyzeRow(row);
				}
			}
		});
		
	printFiles();
	
	JScrollPane scrollPane = new JScrollPane(dataTable);
	tab.add(scrollPane);
	
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
	  
	  public void analyzeRow(int num){
		  
	  }
}
