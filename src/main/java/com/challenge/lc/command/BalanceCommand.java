package com.challenge.lc.command;

public class BalanceCommand implements Command {

	private String bankName;
	
	private String borrowerName;
	
	private int emiNumber;
	
	public BalanceCommand(String content) {
		String[] splited = content.split(" ");
		this.bankName = splited[0];
		this.borrowerName = splited[1];
		this.emiNumber = Integer.valueOf(splited[2]);
	}

	@Override
	public void execute() {
		System.out.println("Balance command executed");
	}

}
