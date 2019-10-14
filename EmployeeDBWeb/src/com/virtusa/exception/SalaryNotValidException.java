package com.virtusa.exception;

public class SalaryNotValidException extends Exception {
	
	String message;

	public SalaryNotValidException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
