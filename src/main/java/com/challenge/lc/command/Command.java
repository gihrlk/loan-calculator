package com.challenge.lc.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public interface Command {
	
	static Logger LOGGER = LogManager.getLogger(Command.class);

	static final String LOAN_API_ENDPOINT = "http://localhost:8080/loan/";

	// Executes the command
	void execute();

	default MultiValueMap<String, String> generateHeaders() {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Content-Type", "application/json");
		return headers;
	}

}
