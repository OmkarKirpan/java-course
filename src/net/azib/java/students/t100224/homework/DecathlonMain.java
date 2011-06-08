package net.azib.java.students.t100224.homework;

import net.azib.java.students.t100224.homework.controller.DecathlonController;
import org.apache.log4j.xml.DOMConfigurator;

public class DecathlonMain {

	public static void main(String[] args) {
		if (args.length > 2) {
			new DecathlonController(args);
			DOMConfigurator.configure("./log4j.xml");
		} else
			System.err
					.println("Usage: <program> -<input-method> [input-parameters] -<output-method> [output-parameters]");
	}

}
