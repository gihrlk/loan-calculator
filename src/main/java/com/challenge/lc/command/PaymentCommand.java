package com.challenge.lc.command;

import java.math.BigDecimal;

import com.challenge.lc.model.Payment;

public class PaymentCommand implements Command {

	private Payment payment;

	public PaymentCommand(String content) {
		String[] splited = content.split(" ");
		this.payment = new Payment(splited[0], splited[1], new BigDecimal(splited[2]), Integer.valueOf(splited[3]));
	}

	@Override
	public void execute() {
		System.out.println("Payment command executed");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
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
		PaymentCommand other = (PaymentCommand) obj;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		return true;
	}

}
