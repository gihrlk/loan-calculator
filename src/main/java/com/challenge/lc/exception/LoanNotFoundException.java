package com.challenge.lc.exception;

public class LoanNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6484020025523880923L;

	public LoanNotFoundException() {
		super("Loan not found.");
	}

	public LoanNotFoundException(String message) {
		super(message);
	}

}
