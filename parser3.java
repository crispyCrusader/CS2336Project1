import com.google.gson.*;

public class parser3 {

	// Variables accessed by the bot
	String result;
	boolean isTrue2 = true;
	
	public parser3(String input) {
		// Calls HTTP request function
		findSong song = new findSong(input);
		
		// Creates variable for the JSON response
		StringBuffer response = song.content;
		
		// If data was retrieved, then the information is parsed
		if (song.isTrue = true)
		{
			@SuppressWarnings("deprecation")
			// Json Object for the data collected
			JsonElement jsonElement = new JsonParser().parse(response.toString());
			JsonObject  jsonObject = jsonElement.getAsJsonObject();
			
			// Navigates to the track name derived by the AP
			JsonObject message = jsonObject.getAsJsonObject("message");
			JsonObject body = message.getAsJsonObject("body");
			JsonArray trackList = body.getAsJsonArray("track_list");
			if (trackList.size() == 0)
			{
				isTrue2 = false;
			}
			else {
				JsonObject jsonObject2 = trackList.get(0).getAsJsonObject();
				JsonObject track = jsonObject2.getAsJsonObject("track");
				result = track.get("track_name").getAsString();
			}
		}
		// Tells the bot the data retrieval was unsuccessful
		else
		{
			isTrue2 = false;
		}
	}
}