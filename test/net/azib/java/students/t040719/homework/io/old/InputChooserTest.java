package net.azib.java.students.t040719.homework.io.old;

import static org.junit.Assert.assertEquals;

import net.azib.java.students.t040719.homework.io.InputMethod;
import net.azib.java.students.t040719.homework.io.old.InputChooser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


import org.junit.Test;


/**
 * InputParserTest - tests the InputParser class
 *
 * @version 1.0
 * @author Romi Agar
 */
public class InputChooserTest {
	
	private static final String NL = System.getProperty("line.separator");
	
	/**
	 * @param string - input for scanner
	 * @return String - output of InputParser PrintStream
	 */
	private String processInput(String s) {
		Scanner input = new Scanner(s);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new InputChooser(input, new PrintStream(out)).processInput();
		return out.toString();
	}
	
	/**
	 * @param string - input for scanner
	 * @return InputMethod - returned InputMethod from InputParser
	 */
	private InputMethod processOutput(String s) {
		Scanner input = new Scanner(s);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		return new InputChooser(input, new PrintStream(out)).processInput();
	}
	
	private void assertOutput(String expected, String input) {
		if (expected == "")
			assertEquals(InputChooser.INSTRUCTION_TEXT + NL, processInput(input));
		else
			assertEquals(InputChooser.INSTRUCTION_TEXT + NL + expected + NL , processInput(input));
	}
	
	@Test
	public void instructionsDisplayed() {
		assertOutput("", "");
	}
	
	@Test
	public void wrongEnumRejected() {
		String input = "l";
		assertOutput("'l'" + InputChooser.ERROR_TEXT, input);
	}
	
	@Test
	public void rightEnumAccepted() {
		String input = "K";
		assertOutput("", input);
		assertEquals(InputMethod.K, processOutput(input));
	}
	
	@Test
	public void caseInsensitiveWorks() {
		String input = "d";
		assertOutput("", input);
		assertEquals(InputMethod.D, processOutput(input));
	}
	
	@Test
	public void xCancelsInput() {
		String input = "l" + NL + "x";
		assertOutput("'l'" + InputChooser.ERROR_TEXT, input);
		assertEquals(null, processOutput(input));
	}
	
	

}