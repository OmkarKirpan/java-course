package net.azib.java.students.t030656;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;



/**
 * Streamikatsetus
 *
 * @author t030656
 */
public class Streamikatsetus {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		String filename = ".classpath";
		InputStream is = new FileInputStream(filename);
		Reader reader = new InputStreamReader(is, "UTF-8");
		while(reader.ready()){
			System.out.print((char)reader.read());	
		}
		System.out.println();
		reader.close();
	}

}
