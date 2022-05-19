public class apiUrl3 {

	// Variables used by the HTTP requester
	String apiUrl;
	
	public apiUrl3(String input) {
		// Declares variables needed
		String apiKey = "";
		String inputWithoutSpace = "";
		
		// If there is a common special character, it is replaced by the ASCII value of the character
		for (int i = 0; i < input.length(); i++)
		{
			if (Character.isWhitespace(input.charAt(i)))
			{
				inputWithoutSpace += "%20";
			}
			else if(input.charAt(i) == ',')
			{
				inputWithoutSpace += "%2C";
			}
			else if(input.charAt(i) == '\'')
			{
				inputWithoutSpace += "%27";
			}
			else if(input.charAt(i) == '(')
			{
				inputWithoutSpace += "%28";
			}
			else if(input.charAt(i) == ')')
			{
				inputWithoutSpace += "%29";
			}
			else
			{
				inputWithoutSpace += input.charAt(i);
			}
		}
		
		// Generates URL needed
		apiUrl = "https://api.musixmatch.com/ws/1.1/track.search?q_lyrics=" + inputWithoutSpace + "&apikey=" + apiKey;
	}
}
