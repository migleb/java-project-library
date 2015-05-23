package com.mif.mibu1254.views;


public class WrongYearException extends ProjectException{
	public WrongYearException(){		
		super("Invalid year");
	}
	
	public WrongYearException(String message){
		super(message);
	}
}
