package com.challenge.lc.command;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class CommandFactoryTest {

	@Test
	void test_getLoanCommand() throws IOException {
		Command command = CommandFactory.getCommand("LOAN", "IDIDI Dale 10000 5 4");
		assertTrue(command instanceof LoanCommand);
	}

	@Test
	void test_getPaymentCommand() throws IOException {
		Command command = CommandFactory.getCommand("PAYMENT", "IDIDI Dale 1000 5");
		assertTrue(command instanceof PaymentCommand);
	}

	@Test
	void test_getBalanceCommand() throws IOException {
		Command command = CommandFactory.getCommand("BALANCE", "IDIDI Dale 5");
		assertTrue(command instanceof BalanceCommand);
	}

}
