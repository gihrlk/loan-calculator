package com.challenge.lc.exception;

public class PaymentAmountNotValidException extends RuntimeException {

	private static final long serialVersionUID = 6484020025523880923L;

	public PaymentAmountNotValidException() {
		super();
	}

	public PaymentAmountNotValidException(String message, Throwable cause) {
		super(message, cause);
	}

	public PaymentAmountNotValidException(String message) {
		super(message);
	}

	public PaymentAmountNotValidException(Throwable cause) {
		super(cause);
	}

}
