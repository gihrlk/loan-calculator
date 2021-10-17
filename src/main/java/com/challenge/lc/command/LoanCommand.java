package com.challenge.lc.command;

public class LoanCommand implements Command {

	private String bankName;

	private String borrowerName;

	private double principalAmount;

	private double interest;

	private int term;

	public LoanCommand(String content) {
		String[] splited = content.split(" ");
		this.bankName = splited[0];
		this.borrowerName = splited[1];
		this.principalAmount = Double.valueOf(splited[2]);
		this.interest = Double.valueOf(splited[3]);
		this.term = Integer.valueOf(splited[4]);
	}

	@Override
	public void execute() {
		System.out.println("Loan command executed");
	}

}
