//DON'T UNCOMMENT THE FOLLOWING THREE LINES.
//[46410961]
//[AVA GARDINER] (as on eStudent)
//[X] Declaration from student that they haven't viewed another person's code for this assignment. 
//(Add a x between the brackets)

package shopping;

public class StockItem {
	public String name;
	public double unitPrice;

	/**
	 * 
	 * @param str for name (assume not null)
	 * @param u for unitPrice
	 * 
	 * assign the upper case version of str to name 
	 * for this method, the only String functions allowed are length() and charAt(int).
	 * use of any other function will result in an automatic zero for this stage.
	 * assign the higher of 0 and u to unitPrice
	 * 
	 * for example, 
	 * 		if str = "Goal posts (1.5m)" and u = 259.9,
	 * 		name should become "GOAL POSTS (1.5M)" and unitPrice should become 259.9
	 */
	public StockItem(String str, double u) {
		name = convertToUpperCase(str);
		
		if(u > 0)
			unitPrice = u;
	}

	/**
	 * 
	 * @param percentageChange
	 * for example,
	 * 		if the unit price of the calling object is 1.2 before 
	 * 		the method is called with parameter 10, it should become
	 * 		1.32 after the method is called.
	 */
	public void updateRegularPrice(int percentageChange) {
		double decimal = percentageChange / 100.0;
		double value  = decimal * unitPrice;
		
		unitPrice = unitPrice + value;
	}

	/**
	 * @param other
	 * @return
	 * 1 if calling object is "more than" parameter object
	 * -1 if calling object is "less than" parameter object
	 * 0 if calling object is "equal to" parameter object
	 * 
	 * IMPORTANT!!! 
	 * Ordering criteria:
	 * first: unitPrice
	 * second: name (in lexicographic order - this is the standard ordering criteria for String compareTo)
	 * 
	 * For example 
	 * 		if calling object represents "BALL" with unit price 39.9
	 * 		and parameter object represents "BIBS" with unit price 5.9,
	 * 		return 1
	 * 
	 * 		if calling object represents "BIBS" with unit price 5.9
	 * 		and parameter object represents "BALL" with unit price 39.9,
	 * 		return -1
	 * 
	 * 		if calling object represents "BALL (SIZE 5)" with unit price 5.9
	 * 		and parameter object represents "BIBS" with unit price 5.9,
	 * 		return -1
	 * 
	 * 		if calling object represents "BIBS" with unit price 5.9
	 * 		and parameter object represents "BALL (SIZE 5)" with unit price 5.9,
	 * 		return 1
	 * 
	 * 		if calling object represents "BALL" with unit price 5.9,
	 * 		and parameter object represents "BIBS (XL)" with unit price 5.9
	 * 		return -1
	 * 
	 * 		if calling object represents "BIBS (XL)" with unit price 5.9
	 * 		and parameter object represents "BALL" with unit price 5.9,
	 * 		return 1
	 * 
	 * 		if calling object represents "BIBS (XL)" with unit price 5.9
	 * 		and parameter object represents "BIBS" with unit price 5.9,
	 * 		return 1
	 * 
	 * 		if calling object represents "BIBS" with unit price 5.9
	 * 		and parameter object represents "BIBS" with unit price 5.9,
	 * 		return 0
	 */
	public int compareTo(StockItem other) {
		if(this.unitPrice != other.unitPrice)
		{
			if(this.unitPrice > other.unitPrice)
				return 1;
			else
				return -1;
		}
		else if(!this.name.equals(other.name))
		{
			if(this.name.compareTo(other.name) > 0)
				return 1;
			else
				return -1;
		}
		else
		{
			return 0;
		}
	}
	
	//Convents characters to upper case
	private String convertToUpperCase(String str) {
		String upperCase = "";
		
		// Conversion according to ASCII values 
	    for (int index = 0; index < str.length(); index++) 
	    {
	    	char character = str.charAt(index);    //SamBa -> charAt(2) => m
	    	int temp = (int) character;  //temp = 109
	        
	    	//ASCII 97 is 'a' and 122 is 'z'
	    	if(temp >= 97 && temp <= 122)   //true
	    		temp = temp - 32;   //
	        
	    	character = (char) temp; //77 is converted to char which is 'M'
	    	upperCase += character; 
	    }
	    
	    return upperCase;
	}
}
