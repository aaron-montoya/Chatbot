package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;

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
	
	/**
	 * Makes a chatbot, popupdisplay and a chatframe
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Aaron Montoya");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	/**
	 * Asks what the user wants to talk about
	 */
	public void start()
	{
		display.displayText("Welcome to ChatPanda™");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.getResponse(response);
//		}
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
}
