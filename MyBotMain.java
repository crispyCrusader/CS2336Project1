public class MyBotMain {
    
	// Main method
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
        MyBot bot = new MyBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.freenode.net");

        // Join the #pircbot channel.
        bot.joinChannel("#harrisonProject1");
        bot.sendMessage("#harrisonProject1", "Hey! I'll respond to your messages. Type in '-help' to get started and learn what I can do!");
    }
}