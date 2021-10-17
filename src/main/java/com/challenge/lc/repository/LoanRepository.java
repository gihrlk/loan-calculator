package com.challenge.lc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.challenge.lc.model.Loan;

@Component
public class LoanRepository {

	private List<Loan> loanList = new ArrayList<Loan>();

	public void addLoan(Loan loan) {
		Loan existingLoan = getLoan(loan.getBankName(), loan.getBorrowerName());
		if (existingLoan != null) {
			// throw Exception
		} else {
			loanList.add(loan);
		}
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
