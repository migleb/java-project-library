package com.mif.mibu1254.views;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.util.*;
import java.sql.DriverManager;

import javax.swing.*;

import com.mif.mibu1254.models.Book;


public class AddBook extends JPanel{
	
	final JTextField title = new JTextField();
    final JTextField author = new JTextField();
    final JFormattedTextField year;
    final JTextField quantity;
    final JPanel panel;
	
	AddBook() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
        decimalFormat.setGroupingUsed(false);
        year = new JFormattedTextField(decimalFormat);
        year.setColumns(15);
        quantity = new JFormattedTextField(decimalFormat);
        quantity.setColumns(15);
        panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Title:"));
        panel.add(title);
        panel.add(new JLabel("Author:"));
        panel.add(author);
        panel.add(new JLabel("Year:"));
        panel.add(year);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantity);
	}
	
	public void show(SaveListener listener) {
		int result = JOptionPane.showConfirmDialog(null, panel, "Add book",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
        	if (listener != null){
        		try{
        		Book book = new Book(title.getText(),author.getText(),year.getText(),Integer.parseInt(quantity.getText()),Integer.parseInt(quantity.getText()));
        		listener.save(book);
        		} catch (WrongYearException e){
        		}
        	}
        } else {
            System.out.println("Cancelled");
        }
	}

}