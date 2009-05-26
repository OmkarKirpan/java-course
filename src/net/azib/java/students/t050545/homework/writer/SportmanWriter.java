package net.azib.java.students.t050545.homework.writer;

import net.azib.java.students.t050545.homework.sport.Competition;

/**
 * SportmanWriter
 *
 * @author libricon
 */
public interface SportmanWriter {
	
	/** Method  should write to it's outStream all result
	 * @param competition  competition
	 * @throws Exception 
	 */
	void printResultTable(Competition competition) throws Exception;
	/**
	 *  Method close streams 
	 */
	void close();

}