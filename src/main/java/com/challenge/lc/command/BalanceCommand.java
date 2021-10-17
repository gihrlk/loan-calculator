package com.challenge.lc.command;

import com.challenge.lc.model.Balance;

public class BalanceCommand implements Command {

	private Balance balance;

	public BalanceCommand(String content) {
		String[] splited = content.split(" ");
		this.balance = new Balance(splited[0], splited[1], Integer.valueOf(splited[2]));
	}

	@Override
	public void execute() {
		System.out.println("Balance command executed");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BalanceCommand other = (BalanceCommand) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		return true;
	}

}
