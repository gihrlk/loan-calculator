package com.challenge.lc.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

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

	public Loan addLoan(Loan loan) throws ExistingLoanFoundException {
		return loanRepository.addLoan(loan);
	}

	public Payment addPayment(Payment payment) throws LoanNotFoundException {
		// Check the outstanding loan amount and shouldn't allow to go over
		return loanRepository.addPayment(payment);
	}

	public BalanceResponse getBalance(Balance balance) throws LoanNotFoundException {
		Loan loan = loanRepository.getLoan(balance);
		List<Payment> payments = loanRepository.getPayments(balance);
		BigDecimal totalLoan = getTotalLoan(loan);
		int numberOfEmis = getNumberOfEmis(loan.getTerm());
		BigDecimal emiAmount = totalLoan.divide(new BigDecimal(numberOfEmis), 0, RoundingMode.CEILING);
		BigDecimal paidTotal = getPaidTotal(emiAmount, balance.getEmiNumber(), payments);
		BigDecimal remainingBalance = totalLoan.subtract(paidTotal);
		int remainingEmis = remainingBalance.divide(emiAmount, 0, RoundingMode.CEILING).intValue();
		
		BigDecimal displayPaidTotal = paidTotal.setScale(0, RoundingMode.CEILING);
		
		BalanceResponse balanceResponse = new BalanceResponse(balance.getBankName(), balance.getBorrowerName(), displayPaidTotal, remainingEmis);
		return balanceResponse;
	}
	
	private BigDecimal getTotalLoan(Loan loan) {
		BigDecimal interest = loan.getPrincipalAmount().multiply(loan.getInterest().divide(new BigDecimal(100))).multiply(new BigDecimal(loan.getTerm()));
		BigDecimal total = loan.getPrincipalAmount().add(interest);
		return total;
	}
	
	private int getNumberOfEmis(int term) {
		return term * 12;
	}
	
	private BigDecimal getPaidTotal(BigDecimal emiAmount, int emiNumber, List<Payment> payments) {
		return emiAmount.multiply(new BigDecimal(emiNumber));
	}

}
