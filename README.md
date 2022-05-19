#Project 1 Documentation

###Bot Name: “project1Bot”

###Channel Name Used: “harrisonProject1”

**How to Compile:**
The main method is the MyBotMain.java file. Import the java files, as well as configure a build path to include the two .jar files in the zip file (gson and pircbot). After doing this, you can compile. 

**3 API’s used:**
1.	OpenWeatherMap API
2.	FlipACoin API
3.	MusixMatch Developer API

**OpenWeatherMap:**
Retrieves temperature data of the location inputted.
Command: “*-weather <city name / zip code>*”
 	 
**FlipACoin:**
User inputs two choices, and the API retrieves whichever choice was randomly chosen.
Command: “*-coin <choice1>, <choice2>*”

**MusixMatch Developer:**
User inputs song lyrics, and the API retrieves the song from the MusixMatch database.
Disclaimer: Not entirely accurate, but this is because of the retrieval from the database by the API, not the program itself. The retrieval is more accurate when the lyrics inputted are the chorus, or if the lyrics are a more unique arrangement of words. 
Command: “*-songlyrics <lyrics>*”
 
**Other Commands:**
Help:
Displays commands that the user can input, and what they do
Command: “*-help*”

Bye:
Disconnects the bot and quits the program (used for more convenient testing of the program)
Command: “*-bye*”
 

