// Imports necessary libraries
import java.util.Scanner;

public class apiURL {

	// Variable accessed by the HTTP requester
	String apiUrl;
	
	// Constructor
	public apiURL(Scanner input) {
		// Declares variables needed
		String temp;
		String apiKey = "449f58fd2c7ad744d1c871c27771832b";
		String cityName = new String(); 
		int zipCode;
		
		// Determines whether input is zip code or city, then generates url
		if (input.hasNextInt())
		{
			zipCode = input.nextInt();
			
			// Creates URL with the inputted zip code
			apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + zipCode + "&appid=" + apiKey;
		}
		else
		{
			temp = input.nextLine();
			
			// Replaces any detected whitespace with "%20"
			for (int i = 0; i < temp.length(); i++) {
				if (Character.isWhitespace(temp.charAt(i)))
				{
					cityName += "%20";
				}
				else
				{
					cityName += temp.charAt(i);
				}
			}
			
			// Creates URL with the inputted city/town name
			apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey;
		}
	}
}