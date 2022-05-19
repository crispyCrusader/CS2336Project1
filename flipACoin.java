// Imports the necessary libraries
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class flipACoin {

	// Variables accessed by the parser
	StringBuffer content;
	private int status;
	boolean isTrue = true;
	
	public flipACoin(Scanner userInput) {
		// Declares variables necessary to determine variables sent to the url generator
		int i = 0;
		String input = userInput.nextLine();
		String choice1 = "", choice2 = "";
		
		// Determines if user input comma
		if (input.contains(","))
		{
			// Uses comma to separate the two inputted choices into different string variables
			for (; input.charAt(i) != ','; i++)
			{
				choice1 += input.charAt(i);
			}
			
			i += 2;
			
			while (i < input.length())
			{
				choice2 += input.charAt(i);
				i++;
			}
			
			// Generates the URL with the apiUrl2 function
			apiUrl2 getUrl = new apiUrl2(choice1, choice2);
			
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
			// Tells parser information wasn't recieved
			else
			{
				isTrue = false;
			}
			
			// Stops connection to the api
			con.disconnect();
		}
		// Tells parser information wasn't recieved
		else
		{
			isTrue = false;
		}
	}
}