package com.RestExceptionHandling.handleExcep.exception;

public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4973601163529059676L;

	public StudentNotFoundException(String msg)
	{
		super(msg);
	}
	
}
