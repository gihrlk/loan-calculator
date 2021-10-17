package com.challenge.lc.command;

import org.junit.jupiter.api.Test;

public class BalanceCommandTest {

	@Test
	void test_execute() {
		BalanceCommand lc = new BalanceCommand("IDIDI Dale 3");
		lc.execute();
	}

}
