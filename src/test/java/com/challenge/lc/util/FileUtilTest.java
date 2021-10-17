package com.challenge.lc.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.challenge.lc.command.Command;
import com.challenge.lc.command.LoanCommand;

public class FileUtilTest {

	private Path workingDir;

	@BeforeEach
	public void init() {
		this.workingDir = Paths.get("src/test/resources");
	}

	@Test
	void test_readFile() throws IOException {
		Path filePath = this.workingDir.resolve("input.txt");
		List<Command> expected = new ArrayList<>();
		expected.add(new LoanCommand("IDIDI Dale 10000 5 4"));
		List<Command> actual = FileUtil.readFile(filePath.toString());
		assertTrue(expected.equals(actual));
	}

}
