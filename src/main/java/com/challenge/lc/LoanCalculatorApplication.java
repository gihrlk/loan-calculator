package com.challenge.lc;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.challenge.lc.command.Command;
import com.challenge.lc.util.FileUtil;

@SpringBootApplication
public class LoanCalculatorApplication implements CommandLineRunner {

	final static Logger LOGGER = LogManager.getLogger(LoanCalculatorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LoanCalculatorApplication.class, args).close();
	}

	@Override
	public void run(String... args) throws Exception {
		if (args != null && args.length == 1) {
			try {
				List<Command> commandList = FileUtil.readFile(args[0]);
				for (Command command : commandList) {
					command.execute();
				}
			} catch (IOException e) {
				LOGGER.error("Error while reading the input file.");
			}
		} else {
			LOGGER.error("Please specify the input file.");
		}
	}

}
