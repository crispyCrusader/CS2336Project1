import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class findSong {
	
	// Variables accessed by the parser
		StringBuffer content;
		private int status;
		boolean isTrue = true;
		
	public findSong(String input) {
		// Calls api url function
		apiUrl3 getUrl = new apiUrl3(input);
		
		// Declares necessary variables for establishing connection to api
		URL url;
		HttpURLConnection con = null;
		
		// Establishes connection to the url
		try 
		{
			url = new URL(getUrl.apiUrl);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// Sets the request headers
		con.setRequestProperty("Content-Type", "application/json");
		
		// Gets a status code
		status = 0;
		try {
			status = con.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Retrieves the information from API's response if successful
		if (status == 200)
		{
			BufferedReader in = null;
			try {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			String inputLine;
			content = new StringBuffer();
			try {
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// Closes buffered reader instance
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Tells bot the information was not retrieved successfully
		else
		{
			isTrue = false;
		}
		
		// Stops connection to the api
		con.disconnect();
	}
}