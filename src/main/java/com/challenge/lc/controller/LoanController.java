package com.challenge.lc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.lc.exception.ExistingLoanFoundException;
import com.challenge.lc.exception.LoanNotFoundException;
import com.challenge.lc.model.Balance;
import com.challenge.lc.model.BalanceResponse;
import com.challenge.lc.model.Loan;
import com.challenge.lc.model.Payment;
import com.challenge.lc.service.LoanService;

@RestController
public class LoanController {

	private LoanService loanService;

	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}

	//@PutMapping("/loan/add")
	@RequestMapping(value = "/loan/add", method = RequestMethod.POST)
	@ExceptionHandler({ ExistingLoanFoundException.class })
	public ResponseEntity<Loan> postLoan(@RequestBody Loan loan) throws ExistingLoanFoundException {
		return ResponseEntity.ok(loanService.addLoan(loan));
	}

	//@PutMapping("/loan/payment")
	@RequestMapping(value = "/loan/payment", method = RequestMethod.POST)
	@ExceptionHandler({ ExistingLoanFoundException.class })
	public ResponseEntity<Payment> postPayment(@RequestBody Payment payment) throws ExistingLoanFoundException {
		return ResponseEntity.ok(loanService.addPayment(payment));
	}

	@GetMapping("/loan/balance/{bankName}/{borrowerName}")
	@ExceptionHandler({ LoanNotFoundException.class })
	public ResponseEntity<BalanceResponse> getBalance(@PathVariable String bankName, @PathVariable String borrowerName,
			@RequestParam int emiNumber) throws LoanNotFoundException {
		Balance balance = new Balance(bankName, borrowerName, emiNumber);
		return ResponseEntity.ok(loanService.getBalance(balance));
	}

}
