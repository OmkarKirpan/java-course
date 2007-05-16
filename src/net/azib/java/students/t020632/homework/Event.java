package net.azib.java.students.t020632.homework;

/**
 * Event is a class which represents one decathlon event
 *
 * @author Marek Soobik t020632
 */
public class Event {
	
	private EventInfo eventInfo;
	private EventCalculator calculator;
	private String result;
	private float fResult;
	private int score;
	
	public Event(EventInfo ei, EventCalculator ec){
		eventInfo = ei; 
		calculator = ec;
	}
	
	/**
	 * Sets result for the event
	 * 
	 * @param result
	 */
	public void setResult(float result){
		this.fResult = result;
	}
	
	/**
	 * Sets result for the event
	 * 
	 * @param result
	 */
	public void setResult(String result){
		this.result = result;
	}
	
	
	/**
	 * Calculates score for this event
	 * 
	 * @return
	 */
	public int calculate(){
		int score = 0;
		
		score = calculator.calculate(eventInfo, fResult);
		
		return score;
		
	}
	
	public EventInfo getEventInfo(){
		return eventInfo;
	}
	
	public EventCalculator getCalculator(){
		return calculator;
	}
	
	public float getFResult(){
		return fResult;
	}
	
	public String getResult(){
		return result;
	}
	
	public int getScore(){
		return this.score;
	}
	
	
	
}
