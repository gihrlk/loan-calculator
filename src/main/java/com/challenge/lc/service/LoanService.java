package com.challenge.lc.service;

import org.springframework.stereotype.Service;

import com.challenge.lc.model.Loan;
import com.challenge.lc.repository.LoanRepository;

@Service
public class LoanService {

	private LoanRepository loanRepository;

	public LoanService(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}

	public void addLoan(String bankName, String borrowerName, double loanAmount, int years, double interestRate) {
		Loan loan = new Loan(bankName, borrowerName, loanAmount, years, interestRate);
		loanRepository.addLoan(loan);
	}

	public Loan addPayment(String bankName, String borrowerName, double amount, int emiNumber) {
		Loan loan = loanRepository.getLoan(bankName, borrowerName);
		// do the calc and save
		return loan;
	}

	public Loan getBalance(String bankName, String borrowerName, int emiNumber) {
		Loan loan = loanRepository.getLoan(bankName, borrowerName);
		return loan;
	}

}
