package net.azib.java.students.t020632.homework;


/**
 * UnitsConverter converts result to correct units. For example
 * 1500m result is given in following form: minutes:seconds.hundredths,
 * but to calculate score the result should be given in seconds
 *
 * @author Marek Soobik t020632
 */
public class UnitsConverter {
	
	private static UnitsConverter converter; 
	
	private UnitsConverter(){
		
	}
	
	/**
	 * Creates UnotConverter object or returns old object
	 * 
	 * @return
	 */
	public static UnitsConverter getUnitsConverter(){
		if(converter == null){
			converter = new UnitsConverter();
		}
		
		return converter;
	}
	
	/**
	 * Converts event result to correct units
	 * 
	 * @param 	eventInfo
	 * @param 	result as a string
	 * @return	converted result as a float
	 */
	public float convert(EventInfo eventInfo, String result){
		float convertedResult = 0;
		char dot = '.';
		char colon = ':';
		String type = eventInfo.getType();
		
		if(type.equals("fieldEvent")){
			try{
				convertedResult = (float) Float.valueOf(result);
				if(eventInfo.getUnits().equals("cm")){
					convertedResult = convertedResult*100;
					convertedResult = (int)convertedResult;
				}
			}
			catch(NumberFormatException e){
				System.out.println("Result " + result + " is not correct" + e.getMessage());
			}
			
		}
		else if(type.equals("runningEvent")){
			
			if(!result.contains(":")){
				try{
					convertedResult = Float.valueOf(result);
					return convertedResult;
				}
				catch(NumberFormatException e){
					
				}
			}
			
			int i = result.indexOf(colon);
			
			if(i == -1){
				i = result.indexOf(dot);
				
			
				
				if(i != -1){
					try{
						convertedResult = Float.valueOf(result.substring(0,i)).floatValue();		
						convertedResult = convertedResult + (Float.valueOf(result.substring(i+1,result.length())).floatValue())/100;
					}
					catch(NumberFormatException e){
						System.out.println("Result " + result + " is not correct" + e.getMessage());
					}
				}
			}
			else{
				try{
					convertedResult = 60 * (float) Float.valueOf(result.substring(0,i));
				}
				catch(NumberFormatException e){
					System.out.println("Result " + result + " is not correct" + e.getMessage());
				}
				
				int j = result.indexOf(dot);
				
				if(j != -1){
					try{
						convertedResult = convertedResult + (float) Float.valueOf(result.substring(i+1,j));		
						convertedResult = convertedResult + ((float)Float.valueOf(result.substring(j+1,result.length())))/100;
					}
					catch(NumberFormatException e){
						System.out.println("Result " + result + " is not correct" + e.getMessage());
					}
				}
				
			}
			try{
				
			}
			catch(NumberFormatException e){
				System.out.println("Result " + result + " is not correct" + e.getMessage());
			}
		}
		
		//System.out.println(convertedResult);
		return convertedResult;
	}
	
	
	
}
