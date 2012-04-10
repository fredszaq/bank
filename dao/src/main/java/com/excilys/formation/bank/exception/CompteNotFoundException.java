package com.excilys.formation.bank.exception;

public class CompteNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1738517365109182168L;

	public CompteNotFoundException() {
		super();
	}

	public CompteNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CompteNotFoundException(String message) {
		super(message);
	}

	public CompteNotFoundException(Throwable cause) {
		super(cause);
	}

}
