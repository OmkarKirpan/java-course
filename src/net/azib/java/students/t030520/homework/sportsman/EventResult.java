package net.azib.java.students.t030520.homework.sportsman;

import net.azib.java.students.t030520.homework.event.Event;
import net.azib.java.students.t030520.homework.event.TrackEvent;

/**
 * The object storing the event data: type and sportsman result.
 *
 * @author t030520
 */
public class EventResult {

	/** result for event */
	private float result;

	/** type of event */
	private Event type;

	public EventResult(float result, Event type) {
		setResult(result);
		setType(type);
	}

	/**
	 * @return the result
	 */
	public float getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(float result) {
		this.result = result;
	}

	/**
	 * @return the type
	 */
	public Event getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Event type) {
		this.type = type;
	}

	/**
	 * @return the number of scored points.
	 */
	public long getPoints() {
		Event type = getType();
		if (type instanceof TrackEvent) {
			return Math.round(type.getA()*Math.pow((type.getB() - getResult()), type.getC()));
		} else {
			return Math.round(type.getA()*Math.pow((getResult() - type.getB()), type.getC()));
		}
	}

	/**
	 * @param eventResult the result to compare.
	 * @return true if the event's results are equal.
	 */
	public boolean equals(EventResult eventResult) {
		return eventResult != null && eventResult.getType() != null && eventResult.getType().equals(this.getType());
	}

}
