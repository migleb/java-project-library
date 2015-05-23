package com.mif.mibu1254.views;
import java.sql.SQLException;

import com.mif.mibu1254.models.Book;


public interface SaveListener {
	public void save(Book book) throws ClassNotFoundException, SQLException, WrongYearException;
}
