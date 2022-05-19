import java.util.Scanner;
import com.google.gson.*;

public class parser2 {
	
	// Variables accessed by the bot
	String result;
	boolean isTrue2 = true;

	public parser2(Scanner userInput) {
		// Calls URL connection function
		flipACoin coin = new flipACoin(userInput);
		
		// Declares the response variable, based on the content of the previously called functions
		StringBuffer response = coin.content;
		
		// Determines if flipACoin kept isTrue as true
		if (coin.isTrue == true)
		{
			// Gets the JSON result as a string
			@SuppressWarnings("deprecation")
			JsonElement jsonElement = new JsonParser().parse(response.toString());
			
			result = jsonElement.getAsString();
		}
		// Tells the bot the data retrieval was unsuccessful
		else
		{
			isTrue2 = false;
		}
	}
}