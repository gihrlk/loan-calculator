package com.challenge.lc.exception;

public class LoanNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6484020025523880923L;

	public LoanNotFoundException() {
		super();
	}

	public LoanNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoanNotFoundException(String message) {
		super(message);
	}

	public LoanNotFoundException(Throwable cause) {
		super(cause);
	}

}
