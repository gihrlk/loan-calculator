package com.challenge.lc.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.lc.exception.ExistingLoanFoundException;
import com.challenge.lc.exception.LoanNotFoundException;
import com.challenge.lc.exception.PaymentAmountNotValidException;
import com.challenge.lc.model.Balance;
import com.challenge.lc.model.BalanceResponse;
import com.challenge.lc.model.Loan;
import com.challenge.lc.model.Payment;

@SpringBootTest
public class LoanServiceTest {

	@Autowired
	LoanService loanService;

	@Test
	@Order(1)
	void test_createDuplicateLoan() {
		Loan loan = new Loan("IDIDI", "Dale", new BigDecimal(10000), 5, new BigDecimal(4));
		ExistingLoanFoundException exception = assertThrows(ExistingLoanFoundException.class, () -> {
			loanService.addLoan(loan);
			loanService.addLoan(loan);
		});

		String expectedMessage = "Existing loan found for";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	@Order(2)
	void test_addPaymentToNotExistingLoan() {
		Payment payment = new Payment("IDIDII", "Dale", new BigDecimal(1000), 12);
		LoanNotFoundException exception = assertThrows(LoanNotFoundException.class, () -> {
			loanService.addPayment(payment);
		});

		String expectedMessage = "Loan not found for";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	@Order(3)
	void test_addPaymentLargerThanOutsatdingBalance() {
		Payment payment = new Payment("IDIDI", "Dale", new BigDecimal(100000), 12);
		PaymentAmountNotValidException exception = assertThrows(PaymentAmountNotValidException.class, () -> {
			loanService.addPayment(payment);
		});

		String expectedMessage = "Lump sum amount exceeds the remaining loan balance";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	@Order(4)
	void test_checkBalance() throws LoanNotFoundException {
		Balance balance = new Balance("IDIDI", "Dale", 5);
		BalanceResponse expected = new BalanceResponse("IDIDI", "Dale", new BigDecimal(1000), 55);
		BalanceResponse actual = loanService.getBalance(balance);
		assertTrue(expected.equals(actual));
	}

}
