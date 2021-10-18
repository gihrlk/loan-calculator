package com.challenge.lc.exception;

public class ExistingLoanFoundException extends RuntimeException {

	private static final long serialVersionUID = 6484020025523880923L;

	public ExistingLoanFoundException() {
		super();
	}

	public ExistingLoanFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExistingLoanFoundException(String message) {
		super(message);
	}

	public ExistingLoanFoundException(Throwable cause) {
		super(cause);
	}

}
