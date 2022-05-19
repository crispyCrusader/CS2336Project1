public class apiUrl2 {

	// Variable accessed by HTTP requester
	String apiUrl;
	
	public apiUrl2(String input1, String input2) {
		// Declares variables needed
		String temp;
		String choice1 = "";
		String choice2 = "";
		
		// Replaces whitespace in input 1 with "%20", or the ASCII value of whitespace
		temp = input1;
		for (int i = 0; i < temp.length(); i++)
		{
			if (Character.isWhitespace(temp.charAt(i)))
			{
				choice1 += "%20";
			}
			else
			{
				choice1 += temp.charAt(i);
			}
			
		}
		// Replaces whitespace in input 2 with "%20"
		temp = input2;
		for (int j = 0; j < temp.length(); j++)
		{
			if (Character.isWhitespace(temp.charAt(j)))
			{
				choice2 += "%20";
			}
			else
			{
				choice2 += temp.charAt(j);
			}
		}
		
		// Generates the required URL
		apiUrl = "http://flipacoinapi.com/json?h=" + choice1 + "&t=" + choice2;
	}
}