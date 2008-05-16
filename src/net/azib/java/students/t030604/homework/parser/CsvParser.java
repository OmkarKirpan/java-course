package net.azib.java.students.t030604.homework.parser;

import net.azib.java.students.t030604.homework.IDataParser;
import net.azib.java.students.t030604.homework.TimeFormat;
import net.azib.java.students.t030604.homework.domain.AthleteScore;

import static java.lang.Float.parseFloat;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class CsvParser implements IDataParser {
	
	private final static String RECORD_DELIMITER = "\n";
	private final static String FIELD_DELIMITER = ",";
	
	private final static DateFormat dateFormat;
	private final static TimeFormat timeFormat;
	
	static {
		dateFormat = new SimpleDateFormat("dd.mm.yyyy");
		dateFormat.setLenient(false);
		timeFormat = new TimeFormat();
	}
	
	private Scanner scanner; 

	public void cleanup() {
		scanner.close();
	}

	public List<AthleteScore> parseData() throws ParserException {
		List<AthleteScore> result = new LinkedList<AthleteScore>();
		while(scanner.hasNext()){
			result.add(
					parseSingleRecord(
							scanner.next()));
		}
		return result;
	}
	
	private AthleteScore parseSingleRecord(String rawData) throws ParserException{
		String[] data = rawData.split(FIELD_DELIMITER);
		if (data.length != 13) {
			throw new ParserException("Error parsing csv file. Columns mismatch", null);
		}
		AthleteScore result = new AthleteScore();
		try {
			//parsing the name
			String temp = data[0].trim();
			result.setName(temp.substring(1, temp.length()-1).trim());
			result.setBirthDate(dateFormat.parse(data[1].trim()));
			result.setCountry(data[2].trim());
			result.setSprint100(parseFloat(data[3]));
			result.setLongJump(parseFloat(data[4]));
			result.setShotPut(parseFloat(data[5]));
			result.setHighJump(parseFloat(data[6]));
			result.setSprint400((Float)timeFormat.parse(data[7]));
			result.setHurdles110(parseFloat(data[8]));
			result.setDiscusThrow(parseFloat(data[9]));
			result.setPoleVault(parseFloat(data[10]));
			result.setJavelinThrow(parseFloat(data[11]));
			result.setRace1500((Float)timeFormat.parse(data[12]));
		} catch (Exception fatal) {
			throw new ParserException("CSV file corrupted", fatal);
		}
		if (!result.validate()) {
			throw new ParserException("invalid values detected: " + result.getValidationErrors(), null);
		}
		
		return result;
	}


	public void setup(String... args) throws ParserException {
		if (args == null || args.length == 0) {
			throw new ParserException("could not initialize CSV parser", null);
		}
		InputStream stream = getClass().getClassLoader().getResourceAsStream(args[0]);
		if (stream == null) {
			throw new ParserException("could not locate given file", null);
		}
		scanner = new Scanner(stream);
		scanner.useDelimiter(RECORD_DELIMITER);
	}

}