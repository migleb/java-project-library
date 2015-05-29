package com.mif.mibu1254.views;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import com.mif.mibu1254.models.Book;

/**
 * Exports books to binary file when export is clicked
 * 
 * @author Miglë
 *
 */
public class ExportBook extends JPanel{
	ExportBook(ArrayList<Book> bookList) {
		try {
			JFileChooser chooser = new JFileChooser();
		    chooser.setCurrentDirectory(new File("C:/Users/user/workspace/Library"));
		    int retrival = chooser.showSaveDialog(null);
		    if (retrival == JFileChooser.APPROVE_OPTION) {
		    	
		    	new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
//				            FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
//				            fw.write(bookList.get(0).toString());
//				            fw.close();
				    		FileOutputStream fos = new FileOutputStream(chooser.getSelectedFile() + ".bin");
					        ObjectOutputStream oos = new ObjectOutputStream(fos);
					        int i = 0;
					        for (Book book : bookList) {
					        	oos.writeObject(bookList.get(i));
					        	i++;
					        }
					        oos.close();
					        fos.close();
				        } catch (Exception ex) {
				            ex.printStackTrace();
				        }
					}
				}).start();
		    	
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
