package net.azib.java.students.t030630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;

/**
 * Scanning
 * 
 * @author Kasutaja
 */
public class ManualScanning {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		System.out.println("How old are you?");
		String line = reader.readLine();
		
		int age = Integer.parseInt(line);
		
		ChoiceFormat cf = new ChoiceFormat(new double[] {1, 2}, 
				new String[] {"year", "years"});
		ChoiceFormat cf2 = new ChoiceFormat(new double[] {0, 10, 20, 60}, 
				new String[] {"kid", "teenager", "grown-up", "old human"});
		System.out.println("I'm " + age + " " + cf.format(age) + " old " + cf2.format(age));
	}

}
