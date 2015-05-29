package com.mif.mibu1254.views;

/**
 * My exception for checking if the year is in the right format
 * 
 * @author Miglë
 *
 */
public class WrongYearException extends ProjectException{
	public WrongYearException(){		
		super("Invalid year");
	}
	
	public WrongYearException(String message){
		super(message);
	}
}
