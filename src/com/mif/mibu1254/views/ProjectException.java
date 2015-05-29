package com.mif.mibu1254.views;


/**
 * My exception class that extends Exception class for all project exceptions
 * 
 * @author Miglë
 *
 */
public class ProjectException extends Exception{
	
	public ProjectException(){
		
	}
	
	public ProjectException(String message){
		super(message);
	}
}
