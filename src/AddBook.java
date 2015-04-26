import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.util.*;
import java.sql.DriverManager;

import javax.swing.*;


public class AddBook extends JPanel{
	
	private SaveListener listener;
	
	public void setSaveListener(SaveListener listener){
		this.listener = listener;
	}
	
	AddBook() {
		//Connection c = null;
	    //Statement stmt = null;
	//	try {
		//	Class.forName("org.sqlite.JDBC");
		//    c = DriverManager.getConnection("jdbc:sqlite:test.db");
		//    c.setAutoCommit(false);
	
		//    stmt = c.createStatement();
	        JTextField title = new JTextField();
	        JTextField author = new JTextField();
	        JTextField year = new JTextField();
	        JTextField quantity = new JTextField();
	        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
	        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
	        decimalFormat.setGroupingUsed(false);
	        year = new JFormattedTextField(decimalFormat);
	        year.setColumns(15);
	        quantity = new JFormattedTextField(decimalFormat);
	        quantity.setColumns(15);
	        JPanel panel = new JPanel(new GridLayout(0, 2));
	        panel.add(new JLabel("Title:"));
	        panel.add(title);
	        panel.add(new JLabel("Author:"));
	        panel.add(author);
	        panel.add(new JLabel("Year:"));
	        panel.add(year);
	        panel.add(new JLabel("Quantity:"));
	        panel.add(quantity);
	        int result = JOptionPane.showConfirmDialog(null, panel, "Add book",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {
	        	if (this.listener != null){
	        		Book book = new Book(title.getText(),author.getText(),year.getText(),Integer.getInteger(quantity.getText()),Integer.getInteger(quantity.getText()));
	        		this.listener.save(book);
	        	}
	        	
//	        	stmt.executeUpdate(sql);
//	        	c.commit();
	        } else {
	            System.out.println("Cancelled");
	        }
//	        stmt.close();
//	        c.commit();
//		    c.close();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			
//		}
	}

}
