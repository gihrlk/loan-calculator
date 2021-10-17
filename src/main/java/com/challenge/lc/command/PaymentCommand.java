package com.challenge.lc.command;

public class PaymentCommand implements Command {

	private String bankName;

	private String borrowerName;

	private double paymentAmount;

	private int emiNumber;

	public PaymentCommand(String content) {
		String[] splited = content.split(" ");
		this.bankName = splited[0];
		this.borrowerName = splited[1];
		this.paymentAmount = Double.valueOf(splited[2]);
		this.emiNumber = Integer.valueOf(splited[3]);
	}

	@Override
	public void execute() {
		System.out.println("Payment command executed");
	}

}
