package TestPackage;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*****************************************************************/
//Author: Romas James Hada, December 4, 2013
/*****************************************************************/

public class testFindNumberInString {
	public static void main(String args[]){
		String Price = "Free Shipping 3-4 days";
		double ProductPrice = 0.0;
		      
	    if(Price.contains("free") || Price.contains("FREE") || Price.contains("Free")  ){
	    	
	    	System.out.println("Price: " + Price);
			
	    }
	    
	    Pattern myPricePattern = Pattern.compile("-?[\\d\\.]+");
	    Matcher MyMatcher = myPricePattern.matcher(Price);
	    while (MyMatcher.find()) {
				ProductPrice = Math.abs(Double.parseDouble(MyMatcher.group()));
				System.out.println("Price: " + ProductPrice);
				
		}
	    
	    Pattern myPricePatterns = Pattern.compile("-?\\d+");
	    Matcher MyMatchers = myPricePatterns.matcher(Price);
	    while (MyMatchers.find()) {
				int ProductPrices = Math.abs(Integer.parseInt(MyMatchers.group()));
				System.out.println("Price: " + ProductPrices);
				
		}
	}
					
}

