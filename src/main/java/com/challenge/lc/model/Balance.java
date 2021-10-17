package com.challenge.lc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Balance {

	@JsonProperty("bankName")
	String bankName;

	@JsonProperty("borrowerName")
	String borrowerName;

	@JsonProperty("emiNumber")
	int emiNumber;

	public Balance() {

	}

	public Balance(String bankName, String borrowerName, int emiNumber) {
		this.bankName = bankName;
		this.borrowerName = borrowerName;
		this.emiNumber = emiNumber;
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

	public int getEmiNumber() {
		return emiNumber;
	}

	public void setEmiNumber(int emiNumber) {
		this.emiNumber = emiNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((borrowerName == null) ? 0 : borrowerName.hashCode());
		result = prime * result + emiNumber;
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
		Balance other = (Balance) obj;
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
		if (emiNumber != other.emiNumber)
			return false;
		return true;
	}

}
