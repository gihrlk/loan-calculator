package com.challenge.lc.command;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.challenge.lc.model.Balance;
import com.challenge.lc.model.BalanceResponse;

public class BalanceCommand implements Command {

	private Balance balance;

	public BalanceCommand(String content) {
		String[] splited = content.split(" ");
		this.balance = new Balance(splited[0], splited[1], Integer.valueOf(splited[2]));
	}

	@Override
	public void execute() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<BalanceResponse> response = restTemplate.exchange(
				LOAN_API_ENDPOINT + "balance/" + balance.getBankName() + "/" + balance.getBorrowerName()
						+ "?emiNumber={emiNumber}",
				HttpMethod.GET, new HttpEntity<Object>(generateHeaders()), BalanceResponse.class,
				balance.getEmiNumber());

		BalanceResponse balanceResponse = response.getBody();
		LOGGER.info("{} {} {} {}", () -> balanceResponse.getBankName(), () -> balanceResponse.getBorrowerName(),
				() -> balanceResponse.getAmountPaid(), () -> balanceResponse.getRemainingEmis());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
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
		BalanceCommand other = (BalanceCommand) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		return true;
	}

}
