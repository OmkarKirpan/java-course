package net.azib.java.students.t040719.lessons;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
/**
 * DuplicateRemoverImpl
 *
 * @author Administrator
 */
public class DuplicateRemoverImpl implements DuplicateRemover {
	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.DuplicateRemover#removeDuplicateStrings(java.lang.String[])
	 */
	public String[] removeDuplicateStrings(String[] array) {;
		LinkedHashSet<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		return set.toArray(new String[0]);
	}
}
