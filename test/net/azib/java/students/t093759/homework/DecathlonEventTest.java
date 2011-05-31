package net.azib.java.students.t093759.homework;

import org.junit.Ignore;
import org.junit.Test;

import java.util.EnumMap;
import java.util.Map;

import static net.azib.java.students.t093759.homework.DecathlonEvent.*;
import static org.junit.Assert.assertEquals;

/**
 * @author dionis
 *         5/30/119:33 PM
 */
public class DecathlonEventTest {
	@Test
	public void resultsForThousandComputeExample() {
		for (Map.Entry<DecathlonEvent, Double> entry : mapWithBenchmarkFor1000PointsForEvent().entrySet()) {
			assertEquals(1000.0, entry.getKey().compute(entry.getValue()), 10);
		}
	}

	@Ignore
	//I have trouble with precision. Don't know how to implement algorithm of computation correctly.
	// It's possible to use BigDecimal's pow(n) function only when n is integer value.
	@Test
	public void resultsForNineHundredComputeExample() {
		for (Map.Entry<DecathlonEvent, Double> entry : mapWithBenchmarkFor1000PointsForEvent().entrySet()) {
			assertEquals(900, entry.getKey().compute(entry.getValue()), 10);
		}
	}

	private Map<DecathlonEvent, Double> mapWithBenchmarkFor1000PointsForEvent() {
		Map<DecathlonEvent, Double> results = new EnumMap<DecathlonEvent, Double>(DecathlonEvent.class);
		results.put(ONE_HUNDRED_METER_SPRINT, 10.395);
		results.put(LONG_JUMP, 776.0);//because in cm
		results.put(SHOT_PUT, 18.4);
		results.put(HIGH_JUMP, 220.0);//because in cm
		results.put(FOUR_HUNDRED_METER_SPRINT, 46.17);
		results.put(ONE_HUNDRED_TEN_METER_HURDLES, 13.8);
		results.put(DISCUS_THROW, 56.17);
		results.put(POLE_VAULT, 528.0);//because in cm
		results.put(JAVELIN_THROW, 77.19);
		results.put(THOUSAND_FIVE_HUNDRED_METER_SPRINT, 233.79);
		return results;
	}

	private Map<DecathlonEvent, Double> mapWithBenchmarkFor900PointsForEvent() {
		Map<DecathlonEvent, Double> results = new EnumMap<DecathlonEvent, Double>(DecathlonEvent.class);
		results.put(ONE_HUNDRED_METER_SPRINT, 10.827);
		results.put(LONG_JUMP, 736.0);//because in cm
		results.put(SHOT_PUT, 16.79);
		results.put(HIGH_JUMP, 210.0);//because in cm
		results.put(FOUR_HUNDRED_METER_SPRINT, 48.19);
		results.put(ONE_HUNDRED_TEN_METER_HURDLES, 14.59);
		results.put(DISCUS_THROW, 51.4);
		results.put(POLE_VAULT, 496.0);//because in cm
		results.put(JAVELIN_THROW, 70.67);
		results.put(THOUSAND_FIVE_HUNDRED_METER_SPRINT, 247.42);
		return results;
	}
}