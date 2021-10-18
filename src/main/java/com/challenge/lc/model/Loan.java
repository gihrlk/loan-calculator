package com.challenge.lc.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Loan {

	@JsonProperty("bankName")
	String bankName;

	@JsonProperty("borrowerName")
	String borrowerName;

	@JsonProperty("principalAmount")
	BigDecimal principalAmount;

	@JsonProperty("term")
	int term;

	@JsonProperty("interest")
	BigDecimal interest;
	
	@JsonProperty("emiAmount")
	BigDecimal emiAmount;
	
	@JsonProperty("totalAmount")
	BigDecimal totalAmount;
	
	public Loan() {
		
	}

	public Loan(String bankName, String borrowerName, BigDecimal principalAmount, Integer term, BigDecimal interest) {
		this.bankName = bankName;
		this.borrowerName = borrowerName;
		this.principalAmount = principalAmount;
		this.term = term;
		this.interest = interest;
	}
	
	public Loan(String bankName, String borrowerName, BigDecimal principalAmount, Integer term, BigDecimal interest, BigDecimal emiAmount, BigDecimal totalAmount) {
		this.bankName = bankName;
		this.borrowerName = borrowerName;
		this.principalAmount = principalAmount;
		this.term = term;
		this.interest = interest;
		this.emiAmount = emiAmount;
		this.totalAmount = totalAmount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public BigDecimal getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(BigDecimal principalAmount) {
		this.principalAmount = principalAmount;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public BigDecimal getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(BigDecimal emiAmount) {
		this.emiAmount = emiAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((borrowerName == null) ? 0 : borrowerName.hashCode());
		result = prime * result + ((emiAmount == null) ? 0 : emiAmount.hashCode());
		result = prime * result + ((interest == null) ? 0 : interest.hashCode());
		result = prime * result + ((principalAmount == null) ? 0 : principalAmount.hashCode());
		result = prime * result + term;
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (borrowerName == null) {
			if (other.borrowerName != null)
				return false;
		} else if (!borrowerName.equals(other.borrowerName))
			return false;
		if (emiAmount == null) {
			if (other.emiAmount != null)
				return false;
		} else if (!emiAmount.equals(other.emiAmount))
			return false;
		if (interest == null) {
			if (other.interest != null)
				return false;
		} else if (!interest.equals(other.interest))
			return false;
		if (principalAmount == null) {
			if (other.principalAmount != null)
				return false;
		} else if (!principalAmount.equals(other.principalAmount))
			return false;
		if (term != other.term)
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		return true;
	}

}
