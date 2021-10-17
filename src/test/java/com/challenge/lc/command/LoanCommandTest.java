package com.challenge.lc.command;

import org.junit.jupiter.api.Test;

public class LoanCommandTest {

	@Test
	void test_execute() {
		LoanCommand lc = new LoanCommand("IDIDI Dale 10000 5 4");
		lc.execute();
	}

}
