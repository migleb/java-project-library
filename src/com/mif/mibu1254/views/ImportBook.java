package com.mif.mibu1254.views;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import com.mif.mibu1254.models.Book;

public class ImportBook {

	ImportBook(){
	}
	
	public ArrayList<Book> getList(){
		try {
			ArrayList<Book> bookList = new ArrayList<Book>();;
			JFileChooser chooser = new JFileChooser();
		    chooser.setCurrentDirectory(new File("C:/Users/user/workspace/Library"));
		    int retrival = chooser.showSaveDialog(null);
		    if (retrival == JFileChooser.APPROVE_OPTION){
		    	FileInputStream fstream = new FileInputStream(chooser.getSelectedFile());
		    	try {
		    	  ObjectInputStream ostream = new ObjectInputStream(fstream);
		    	  while (true) {
		    	    Book book;
		    	    try {
		    	      book = (Book) ostream.readObject();
		    	    } catch (EOFException e) {
		    	      break;
		    	    }
		    	    bookList.add(book);
		    	  }
		    	} finally {
		    	  fstream.close();
		    	}
		    }
		    return bookList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
