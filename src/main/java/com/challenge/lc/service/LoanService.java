package com.challenge.lc.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.lc.exception.ExistingLoanFoundException;
import com.challenge.lc.exception.LoanNotFoundException;
import com.challenge.lc.exception.PaymentAmountNotValidException;
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
		// Calculate the EMI
		BigDecimal totalLoan = getTotalLoan(loan);
		int numberOfEmis = getNumberOfEmis(loan.getTerm());
		BigDecimal emiAmount = totalLoan.divide(new BigDecimal(numberOfEmis), 0, RoundingMode.CEILING);
		loan.setTotalAmount(totalLoan);
		loan.setEmiAmount(emiAmount);
		return loanRepository.addLoan(loan);
	}

	public Payment addPayment(Payment payment) throws LoanNotFoundException, PaymentAmountNotValidException {
		// Check the outstanding loan amount
		// If payment is greater than the outstanding amount, raise an error
		Loan loan = loanRepository.getLoan(payment.getBankName(), payment.getBorrowerName());
		BigDecimal paidTotal = getPaidTotal(payment.getBankName(), payment.getBorrowerName(), loan.getEmiAmount(),
				payment.getEmiNumber());
		BigDecimal remainingBalance = loan.getTotalAmount().subtract(paidTotal);
		if (remainingBalance.compareTo(payment.getLumpsumAmount()) < 0) {
			return loanRepository.addPayment(payment);
		} else {
			throw new PaymentAmountNotValidException();
		}
	}

	public BalanceResponse getBalance(Balance balance) throws LoanNotFoundException {
		Loan loan = loanRepository.getLoan(balance.getBankName(), balance.getBorrowerName());
		BigDecimal paidTotal = getPaidTotal(balance.getBankName(), balance.getBorrowerName(), loan.getEmiAmount(),
				balance.getEmiNumber());
		BigDecimal remainingBalance = loan.getTotalAmount().subtract(paidTotal);
		int remainingEmis = remainingBalance.divide(loan.getEmiAmount(), 0, RoundingMode.CEILING).intValue();
		BigDecimal displayPaidTotal = paidTotal.setScale(0, RoundingMode.CEILING);
		BalanceResponse balanceResponse = new BalanceResponse(balance.getBankName(), balance.getBorrowerName(),
				displayPaidTotal, remainingEmis);
		return balanceResponse;
	}

	private BigDecimal getTotalLoan(Loan loan) {
		BigDecimal interest = loan.getPrincipalAmount().multiply(loan.getInterest().divide(new BigDecimal(100)))
				.multiply(new BigDecimal(loan.getTerm()));
		BigDecimal total = loan.getPrincipalAmount().add(interest);
		return total;
	}

	private int getNumberOfEmis(int term) {
		return term * 12;
	}

	private BigDecimal getPaidTotal(String bankName, String borrowerName, BigDecimal emiAmount, int emiNumber) {
		BigDecimal emiPayments = emiAmount.multiply(new BigDecimal(emiNumber));
		// Now calculate the extra payments
		List<Payment> payments = loanRepository.getPayments(bankName, borrowerName);
		BigDecimal lumpsumTotal = payments.stream().map(payment -> payment.getLumpsumAmount()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		return emiPayments.add(lumpsumTotal);
	}

}
