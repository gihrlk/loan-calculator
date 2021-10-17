package com.challenge.lc.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.challenge.lc.command.Command;
import com.challenge.lc.command.CommandFactory;

@Component
public class FileUtil {

	public static List<Command> readFile(String filePath) throws IOException {
		List<Command> results = new ArrayList<Command>();
		File file = new File(filePath);
		Scanner scanner = new Scanner(file);
		try {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String commandString = line.substring(0, line.indexOf(' '));
				String contentString = line.substring(line.indexOf(' ') + 1, line.length());
				Command command = CommandFactory.getCommand(commandString, contentString);
				if (command != null) {
					results.add(command);
				}
			}
		} finally {
			scanner.close();
		}

		return results;
	}

}
