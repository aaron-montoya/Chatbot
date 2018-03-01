package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;
import chat.model.CTECTwitter;

/**
 * Manages the Chatbot application including the Model and Frame of the View package
 * @author Aaron Montoya
 * @version 11.21.17 Added Frame 1.3
 */
public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	private CTECTwitter myTwitter;
	
	/**
	 * Makes a chatbot, popupdisplay and a chatframe
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Aaron Montoya");
		myTwitter =  new CTECTwitter(this);
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
		getChatbot();
		getDisplay();
	}
	
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	
	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
	}
	
	/**
	 * Asks what the user wants to talk about
	 */
	public void start()
	{
		display.displayText("Welcome to ChatPanda™");
		String results = IOController.loadFromFile(this, "commonWords.txt");
		IOController.saveToFile(this, results, "");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.getResponse(response);
//		}
	}
	
	public void getChatbot()
	{
		
	}
	
	public void getDisplay()
	{
		
	}
	
	public String interactWithChatbot(String input)
	{	
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	
	/**
	 * 
	 * @param chat What the user said
	 * @return Returns chatbotSays and processConversation together
	 */
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special content/n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "";
		}
		//Continue with all checkers except length and quit checker
		
		return response;
	}
	
	public String search(String text)
	{
		return myTwitter.getMostCommonWord(text);
	}
	
	
	
	
}













