package com.capgemini.exceptions;

public class NoSuchCustomerException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public NoSuchCustomerException(String message) {
		super(message);
	}
}
