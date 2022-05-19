// Imports necessary libraries
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class jsonRetrieve {

	// Variables accessed by the parser
	StringBuffer content;
	private int status;
	boolean isTrue = true;
	
	public jsonRetrieve(Scanner input) {
		// Calls API URL function
		apiURL getUrl = new apiURL(input); 
		
		// Declares necessary variables
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
		// Tells the parser information wasn't retrieved
		else
		{
			isTrue = false;
		}
		// Stops connection to the api
		con.disconnect();
	}
}