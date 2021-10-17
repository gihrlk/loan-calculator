package com.challenge.lc.command;

import org.junit.jupiter.api.Test;

public class PaymentCommandTest {

	@Test
	void test_execute() {
		PaymentCommand lc = new PaymentCommand("IDIDI Dale 1000 5");
		lc.execute();
	}

}
