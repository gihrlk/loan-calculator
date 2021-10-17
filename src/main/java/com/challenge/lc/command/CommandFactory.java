package com.challenge.lc.command;

import org.springframework.stereotype.Component;

@Component
public class CommandFactory {

	public static final String LOAN = "LOAN";

	public static final String PAYMENT = "PAYMENT";

	public static final String BALANCE = "BALANCE";

	public static Command getCommand(String commandString, String contentString) {
		Command command = null;
		if (commandString.equalsIgnoreCase(LOAN)) {
			command = new LoanCommand(contentString);
		} else if (commandString.equalsIgnoreCase(PAYMENT)) {
			command = new PaymentCommand(contentString);
		} else if (commandString.equalsIgnoreCase(BALANCE)) {
			command = new BalanceCommand(contentString);
		}
		return command;
	}

}
