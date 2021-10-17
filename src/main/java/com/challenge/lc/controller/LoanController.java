package com.challenge.lc.controller;

import org.springframework.web.bind.annotation.RestController;

import com.challenge.lc.service.LoanService;

@RestController
public class LoanController {

	private LoanService loanService;

	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}

//	@PutMapping("/loan")
//	public ResponseEntity<Loan> createNewLoan(@RequestParam String bankName,
//			@RequestParam String borrowerName, @RequestParam double loanAmount, @RequestParam int years, @RequestParam double interestRate) {
//		return ResponseEntity.ok(loanService.addLoan(bankName, borrowerName, loanAmount, years, interestRate));
//	}
//
//	@PutMapping("/loan/payment")
//	public ResponseEntity<Loan> getMoviesByName(@RequestParam String name) {
//		return ResponseEntity.ok(loanService.getMoviePriceResponseFromName(name));
//	}
//
//	@GetMapping("/loan/balance")
//	public ResponseEntity<Loan> getListOfMoviesByProvider(@RequestParam String bankName,
//			@RequestParam String borrowerName, @RequestParam int emiNumber) {
//		return ResponseEntity.ok(loanService.getListOfMoviesFromProvider(provider));
//
//		
//	}

}
