package com.challenge.lc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.challenge.lc.exception.ExistingLoanFoundException;
import com.challenge.lc.exception.LoanNotFoundException;
import com.challenge.lc.model.Balance;
import com.challenge.lc.model.Loan;
import com.challenge.lc.model.Payment;

@Component
public class LoanRepository {

	private List<Loan> loanList = new ArrayList<Loan>();

	private List<Payment> paymentList = new ArrayList<Payment>();

	public List<Loan> getLoanList() {
		return loanList;
	}

	public void setLoanList(List<Loan> loanList) {
		this.loanList = loanList;
	}

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	public Loan addLoan(Loan loan) throws ExistingLoanFoundException {
		// Check if the load already exists
		Loan existingLoan = getLoan(loan.getBankName(), loan.getBorrowerName());
		if (existingLoan != null) {
			throw new ExistingLoanFoundException();
		} else {
			loanList.add(loan);
		}

		return loan;
	}

	public Payment addPayment(Payment payment) throws LoanNotFoundException {
		// Check if the load already exists
		Loan existingLoan = getLoan(payment.getBankName(), payment.getBorrowerName());
		if (existingLoan == null) {
			throw new LoanNotFoundException();
		} else {
			paymentList.add(payment);
		}

		return payment;
	}

//	public Loan getLoan(Balance balance) {
//		// Check if the load already exists
//		Loan existingLoan = getLoan(balance.getBankName(), balance.getBorrowerName());
//		if (existingLoan == null) {
//			throw new LoanNotFoundException();
//		}
//
//		return existingLoan;
//	}

	public List<Payment> getPayments(String bankName, String borrowerName) {
		List<Payment> payments = paymentList.stream()
				.filter(payment -> payment.getBankName().equalsIgnoreCase(bankName)
						&& payment.getBorrowerName().equalsIgnoreCase(borrowerName))
				.collect(Collectors.toList());
		return payments;
	}

	public Loan getLoan(String bankName, String borrowerName) {
		Optional<Loan> optionalLoan = loanList.stream().filter(loan -> loan.getBankName().equalsIgnoreCase(bankName)
				&& loan.getBorrowerName().equalsIgnoreCase(borrowerName)).findFirst();
		if (optionalLoan.isPresent()) {
			return optionalLoan.get();
		}
		return null;
	}

}
