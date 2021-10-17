package com.challenge.lc.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.lc.exception.ExistingLoanFoundException;
import com.challenge.lc.exception.LoanNotFoundException;
import com.challenge.lc.model.Balance;
import com.challenge.lc.model.BalanceResponse;
import com.challenge.lc.model.Loan;
import com.challenge.lc.model.Payment;

@SpringBootTest
public class LoanServiceTest {

	@Autowired
	LoanService loanService;

	@Test
	void test_createDuplicateLoan() {
		Loan loan = new Loan("IDIDI", "Dale", new BigDecimal(10000), 5, new BigDecimal(4));
		ExistingLoanFoundException exception = assertThrows(ExistingLoanFoundException.class, () -> {
			loanService.addLoan(loan);
			loanService.addLoan(loan);
		});

		String expectedMessage = "Existing loan found.";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void test_addPaymentToNotExistingLoan() {
		Payment payment = new Payment("IDIDII", "Dale", new BigDecimal(1000), 12);
		LoanNotFoundException exception = assertThrows(LoanNotFoundException.class, () -> {
			loanService.addPayment(payment);
		});

		String expectedMessage = "Loan not found.";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void test_checkBalance() throws LoanNotFoundException {
		Balance balance = new Balance("IDIDII", "Dale", 1);
		BalanceResponse expected = new BalanceResponse("IDIDI", "Dale", new BigDecimal(1000), 10);
		BalanceResponse actual = loanService.getBalance(balance);
		assertTrue(expected.equals(actual));
	}

}
