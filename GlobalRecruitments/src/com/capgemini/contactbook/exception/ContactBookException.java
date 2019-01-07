package com.capgemini.contactbook.exception;

 public class ContactBookException extends Exception {
	private String message;

	public ContactBookException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
