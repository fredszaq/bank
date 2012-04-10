package com.excilys.formation.bank.exception;

public class OperationNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1738517365109182168L;

	public OperationNotFoundException() {
		super();
	}

	public OperationNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public OperationNotFoundException(String message) {
		super(message);
	}

	public OperationNotFoundException(Throwable cause) {
		super(cause);
	}

}
