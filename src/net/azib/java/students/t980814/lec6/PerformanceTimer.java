package net.azib.java.students.t980814.lec6;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * PerformaceTimer
 *
 * @author dell
 */
public class PerformanceTimer {

	public final static String WELCOME_TEXT = "Measuring performance of ";
	
	public PerformanceTimer(PrintStream out, Runnable runnable) {
		out.println(WELCOME_TEXT + runnable.toString());
		out.println(measureRunnablePerformanceInMillis(runnable) + "ms");
	}
	
	long startTimer() {
		return System.currentTimeMillis();
	}
	
	long stopTimer(long startTime) {
		return System.currentTimeMillis() - startTime;
	}
	
	public long measureRunnablePerformanceInMillis(Runnable runnable) {
		long startTime = startTimer();
		runnable.run();
		return stopTimer(startTime);
	}

	public static void main(String[] args) {
		new PerformanceTimer(System.out, new Runnable() {
				public void run() {
					try {
						new SimpleFileCopier().copy(new File("jura.src"), new File("copy1.dest"));
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				public String toString() {
					return "SimpleFileCopier, jura.src";
				}
		});

		new File("copy1.dest").delete();
		
		new PerformanceTimer(System.out, new Runnable() {
			public void run() {
				try {
					new BufferedFileCopier().copy(new File("jura.src"), new File("copy2.dest"));
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}

			public String toString() {
				return "BufferedFileCopier, jura.src";
			}
		});

		new File("copy2.dest").delete();

	}
}
