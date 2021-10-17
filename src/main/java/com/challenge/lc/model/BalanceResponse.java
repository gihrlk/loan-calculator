package com.challenge.lc.model;

import java.math.BigDecimal;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceResponse balanceResponse = (BalanceResponse) o;
        return Objects.equals(bankName, balanceResponse.bankName) &&
                Objects.equals(borrowerName, balanceResponse.borrowerName) &&
                Objects.equals(amountPaid.doubleValue(), balanceResponse.amountPaid.doubleValue()) &&
                Objects.equals(remainingEmis, balanceResponse.remainingEmis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, borrowerName, amountPaid, remainingEmis);
    }

}
