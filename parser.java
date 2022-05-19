// Imports necessary libraries
import java.util.Scanner;
import com.google.gson.*;

public class parser {

	// Declares variables accessed by the bot
	String cityName;
	String weatherDescription;
	double currentTemp;
	double highTemp;
	double lowTemp;
	double feelsLike;
	boolean isTrue2 = true;
	
	public parser(Scanner input) {
		// Calls HTTP requester
		jsonRetrieve jr = new jsonRetrieve(input);
		
		// Declares variable for the JSON response
		StringBuffer response = jr.content;
		
		if (jr.isTrue == true)
		{
			// Declares a JSON object to store the retrieved information
			@SuppressWarnings("deprecation")
			JsonElement jsonElement = new JsonParser().parse(response.toString());
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			
			// Object for city name
			cityName = jsonObject.get("name").getAsString();
			
			// Object for weather description
			JsonArray weather = jsonObject.getAsJsonArray("weather");
			JsonObject description = weather.get(0).getAsJsonObject();
			weatherDescription = description.get("description").getAsString();
			
			// Object for current temperature, high, low, and feels like
			JsonObject temperature = jsonObject.getAsJsonObject("main");
			// Current temp
			currentTemp = temperature.get("temp").getAsDouble();
			currentTemp = (currentTemp - 273.15) * (9.0 / 5.0) + 32;
			// High temp
			highTemp = temperature.get("temp_max").getAsDouble();
			highTemp = (highTemp - 273.15) * (9.0 / 5.0) + 32;
			// Low temp
			lowTemp = temperature.get("temp_min").getAsDouble();
			lowTemp = (lowTemp - 273.15) * (9.0 / 5.0) + 32;
			// Feels like
			feelsLike = temperature.get("feels_like").getAsDouble();
			feelsLike = (feelsLike - 273.15) * (9.0 / 5.0) + 32;
		}
		// Tells the bot the data retrieval was unsuccessful
		else
		{
			isTrue2 = false;
		}
	}
}