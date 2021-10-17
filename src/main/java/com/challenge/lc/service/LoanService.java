package com.challenge.lc.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.challenge.lc.exception.ExistingLoanFoundException;
import com.challenge.lc.exception.LoanNotFoundException;
import com.challenge.lc.model.Balance;
import com.challenge.lc.model.BalanceResponse;
import com.challenge.lc.model.Loan;
import com.challenge.lc.model.Payment;
import com.challenge.lc.repository.LoanRepository;

@Service
public class LoanService {

	private LoanRepository loanRepository;

	public LoanService(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}

	public void addLoan(Loan loan) throws ExistingLoanFoundException {
		loanRepository.addLoan(loan);
	}

	public void addPayment(Payment payment) throws LoanNotFoundException {
		loanRepository.addPayment(payment);
	}

	public BalanceResponse getBalance(Balance balance) throws LoanNotFoundException {
		BalanceResponse balanceResponse = new BalanceResponse("IDIDI", "Dale", new BigDecimal(1000), 10);
		return balanceResponse;
	}

}
