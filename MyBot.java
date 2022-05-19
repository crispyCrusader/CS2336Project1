import org.jibble.pircbot.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MyBot extends PircBot {
    
	public MyBot() {
        this.setName("project1Bot");
    }
    
    public void onMessage(String channel, String sender, String login, String hostname, String message) {
    	
    	// Commands displayed in help
    	if (message.contains("-"))
    	{
    		// -help command displays all -<commands> the bot understands
	    	if(message.contains("-help")) {
	    		sendMessage(channel, sender + " Commands: ");
	    		sendMessage(channel, "-weather <city / zip code>: Gets the weather in the specified area");
	    		sendMessage(channel, "-coin <choice 1>, <choice 2>: Decides between any two choices you input. Use a comma between each choice");
	    		sendMessage(channel, "-songlyrics <lyrics>: Finds a song that best matches the lyrics inputted (preferrably the chorus, but the more lyrics, the better)");
	    		sendMessage(channel, "                      Disclaimer: not entirely accurate, but this is because of the database, not my data retrieval");
	    		sendMessage(channel, "-help: Displays list of available commands");
	    		sendMessage(channel, "-bye: Disconnects me");
	    	}
	    	
	    	// -weather command takes user input and retrieves weather information based on the location inputted
	    	else if (message.contains("-weather")) {
	    		// Takes user input
	    		Scanner userInput = new Scanner(message);
	    		userInput.skip(Pattern.compile("-weather "));
	    		// Calls the parser
	    		parser parsedData = new parser(userInput);
	    		// Closes the scanner instance
	    		userInput.close();
	    		
	    		// If user input is in the correct format, the data will display
	    		if (parsedData.isTrue2 == true)
	    		{
		    		sendMessage(channel, sender + ": Looks like we have " + parsedData.weatherDescription + " in " + parsedData.cityName + " today.");
		    		sendMessage(channel, "The current temperature is " + (int)parsedData.currentTemp + " degrees.");
		    		sendMessage(channel, "The high for the day is " + (int)parsedData.highTemp + " degrees.");
		    		sendMessage(channel, "The low for the day is " + (int)parsedData.lowTemp + " degrees.");
		    		sendMessage(channel, "It feels like " + (int)parsedData.feelsLike + " degrees outside.");
	    		}
	    		// If user input is not in the correct format, the bot displays the error saying no data could be retrieved
	    		else
	    		{
	    			sendMessage(channel, sender + ": I cannot retrieve data on that location. Try making sure it is typed in correctly!");
	    		}
	    	}
	    	
	    	// -coin command takes user input and decides between the two choices the user inputted
	    	else if (message.contains("-coin")) {
	    		// Takes user input
	    		Scanner userInput = new Scanner(message);
	    		userInput.skip(Pattern.compile("-coin "));
	    		// Calls the second parser
	    		parser2 coin = new parser2(userInput);
	    		// Closes scanner instance
	    		userInput.close();
	    		
	    		// If data was successfully retrieved, the data is displayed
	    		if (coin.isTrue2 == true)
	    		{
	    			sendMessage(channel, sender + ": " + coin.result);
	    		}
	    		// If data was not successfully retrieved, the bot will display an error message to the user
	    		else
	    		{
	    			sendMessage(channel, sender + ": I cannot retrieve the data on the coin flip. Make sure you put in the comma.");
	    		}
	    	}
	    	
	    	// -songlyrics Finds the song that best matches the lyrics that the user inputs
	    	else if (message.contains("-songlyrics")){
	    		// Takes user input
	    		Scanner userInput = new Scanner(message);
	    		userInput.skip(Pattern.compile("-songlyrics "));
	    		String songLyrics = userInput.nextLine();
	    		// Calls the third parser
	    		parser3 song = new parser3(songLyrics);
	    		// Closes scanner instance
	    		userInput.close();
	    		
	    		// If data was successfully retrieved, the data is displayed
	    		if (song.isTrue2 == true)
	    		{
	    			sendMessage(channel, sender + ": " + song.result);
	    		}
	    		// If data was not successfully retrieved, the bot will display an error message to the user
	    		else
	    		{
	    			sendMessage(channel, sender + ": I cannot retrieve the data on the song lyrics. Perhaps this means that the song wasn't found in the Musixmatch database, or the host URL is down for now.");
	    			sendMessage(channel, "Try using different lyrics, preferrably the chorus if you haven't already.");
	    		}
	    	}
	    	
	    	// -bye command disconnects the bot and quits the program
	    	else if (message.contains("-bye")) {
	    		sendMessage(channel, sender + ": Goodbye");
	    		disconnect();
	    		System.exit(0);
	    	}
	    	
	    	// If user inputs a -<command> not previously defined, the bot will display this message telling user to type '-help'
	    	else {
	    		sendMessage(channel, sender + " I don't know what you mean. Type in '-help' for information on what I can do!");
	    	}
    	}
    	// Hidden trigger words (just for fun)
    	else
    	{
    		// Bot will say hi
	    	if (message.contains("hello") || message.contains("Hello")) 
	    	{
	    		sendMessage(channel, sender + ": Hello! If you need any help, just type in '-help' for a list of commands I understand!");
	    	}
	    	
	    	// Pong!
	    	else if (message.contains("ping") || message.contains("Ping"))
	    	{
	    		sendMessage(channel, sender + ": Pong!");
	    	}
	    	
	    	// Ping!
	    	else if (message.contains("pong") || message.contains("Pong"))
	    	{
	    		sendMessage(channel, sender + ": Ping!");
	    	}
	    	
	    	// Please thank the bot for its services
	    	else if (message.contains("thank") || message.contains("Thank"))
	    	{
	    		sendMessage(channel, sender + ": It's my pleasure :D");
	    	}
	    	
	    	// Displays the time and day when asked
	    	else if (message.contains("time"))
	    	{
	            String time = new java.util.Date().toString();
	            sendMessage(channel, sender + ": The time is now " + time);
	    	}
    	}
     }
}