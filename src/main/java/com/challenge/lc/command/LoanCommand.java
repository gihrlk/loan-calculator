package com.challenge.lc.command;

import java.math.BigDecimal;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.challenge.lc.model.Loan;

public class LoanCommand implements Command {

	private Loan loan;

	public LoanCommand(String content) {
		String[] splited = content.split(" ");
		this.loan = new Loan(splited[0], splited[1], new BigDecimal(splited[2]), Integer.valueOf(splited[3]),
				new BigDecimal(splited[4]));
	}

	@Override
	public void execute() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity(LOAN_API_ENDPOINT + "add", new HttpEntity<Object>(loan, generateHeaders()),
				Loan.class);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loan == null) ? 0 : loan.hashCode());
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
		LoanCommand other = (LoanCommand) obj;
		if (loan == null) {
			if (other.loan != null)
				return false;
		} else if (!loan.equals(other.loan))
			return false;
		return true;
	}

}
