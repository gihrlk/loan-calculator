package com.challenge.lc.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BalanceResponse {

	@JsonProperty("bankName")
	String bankName;

	@JsonProperty("borrowerName")
	String borrowerName;

	@JsonProperty("amountPaid")
	BigDecimal amountPaid;

	@JsonProperty("remainingEmis")
	int remainingEmis;

	public BalanceResponse() {

	}

	public BalanceResponse(String bankName, String borrowerName, BigDecimal amountPaid, int remainingEmis) {
		this.bankName = bankName;
		this.borrowerName = borrowerName;
		this.amountPaid = amountPaid;
		this.remainingEmis = remainingEmis;
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

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getRemainingEmis() {
		return remainingEmis;
	}

	public void setRemainingEmis(int remainingEmis) {
		this.remainingEmis = remainingEmis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountPaid == null) ? 0 : amountPaid.hashCode());
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((borrowerName == null) ? 0 : borrowerName.hashCode());
		result = prime * result + remainingEmis;
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
		BalanceResponse other = (BalanceResponse) obj;
		if (amountPaid == null) {
			if (other.amountPaid != null)
				return false;
		} else if (!amountPaid.equals(other.amountPaid))
			return false;
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
		if (remainingEmis != other.remainingEmis)
			return false;
		return true;
	}

}
