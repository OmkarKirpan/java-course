package net.azib.java.students.t030655.Lab4;

/**
 * Concatenator
 *
 * @author Triin
 */
public class Concatenator {
	public String concatenate(String a, String b){
		if (b==null)
			return a;
		if (a==null)
			return b;
		
		return a+b;
	}

}
