package com.challenge.lc.exception;

public class PaymentAmountNotValidException extends RuntimeException {

	private static final long serialVersionUID = 6484020025523880923L;

	public PaymentAmountNotValidException() {
		super("Incorrect payment.");
	}

	public PaymentAmountNotValidException(String message) {
		super(message);
	}

}
