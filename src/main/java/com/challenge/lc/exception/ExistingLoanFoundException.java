package com.challenge.lc.exception;

public class ExistingLoanFoundException extends RuntimeException {

	private static final long serialVersionUID = 6484020025523880923L;

	public ExistingLoanFoundException() {
		super("Existing loan found.");
	}

	public ExistingLoanFoundException(String message) {
		super(message);
	}

}
