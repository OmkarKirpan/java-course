package net.azib.java.students.t092861.homework;

import java.util.ArrayList;

/**
 * @author Stanislav / 092861
 * 
 * Selection of the appropriate input and output methods must be done in the following way:
 * <program> -<input-method> [input-parameters] -<output-method> [output-parameters]
 * 
 * where
 * <program> is the main class
 * 
 * <input-method> is the name of the input method preceded by dash (-): -console, -csv, -db
 * [input-parameters] are optional parameters depending on the specified input method:
 * -console - no parameters
 * -csv - input file name or path
 * -db - competition id or name - both should work (DB connection string must be read from db.properties in the same package as the main class) 
 * 
 * <output-method> is the name of the output method preceded by dash (-): -conole, -csv, -xml, -html
 * [output-parameters] are optional parameters depending on the specified output method:
 * -conole - no parameters
 * -csv - output file name or path
 * -xml - output file name or path
 * -html - output file name or path 
 * 
 * Every call must specify both input and output method as well as any required parameters. Any combination of two input and output methods is accepted. 
 * 
 */
public class DecathlonCalculator {

	/**
	 *  
	 */
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	private Controller ctrl;

	/**
	 * @param args
	 *            - command line parameters for data input and output formats:
	 *            -console, -csv, -xml, -html
	 */
	public static void main(String[] args) {
		DecathlonCalculator calculator = new DecathlonCalculator();
		calculator.doComputation(args);
	}

	public ArrayList<Athlete> doComputation(String[] args) {
		ctrl = new Controller();
		for (int i = 0; i < args.length; i++) {
			// console read and write
			if (args[i].equals(Const.CONSOLE)) {
				if (i == 0) {
					athletes = new IOconsole(ctrl).input();
				} else if (athletes != null) {
					new IOconsole(ctrl).output(athletes);
				}

				// csv read and write
			} else if (args[i].equals(Const.CSV)) {
				if (i == 0) {
					athletes = new IOcsv(args[++i],ctrl).input();
				} else if (athletes != null) {
					new IOcsv(args[++i],ctrl).output(athletes);
				}

			} else if (args[i].equals(Const.DB)) {
				if (i == 0) {
					// db read
					athletes = new IOdb(args[++i],ctrl).input();
				}

			} else if (args[i].equals(Const.XML) && athletes != null) {
				// xml write
				new IOxml(args[++i],ctrl).output(athletes);

			} else if (args[i].equals(Const.HTML) && athletes != null) {
				// html write
				new IOhtml(args[++i],ctrl).output(athletes);

			} else {
				System.out
						.println("Invalid command-line parameter: " + args[i]);
				break;
			}
		}
		return athletes;
	}
}
