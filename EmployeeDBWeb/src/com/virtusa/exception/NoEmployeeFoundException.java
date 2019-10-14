package com.virtusa.exception;

public class NoEmployeeFoundException extends Exception{

	String message;
	public NoEmployeeFoundException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	
	
}
