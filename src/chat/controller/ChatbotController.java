package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Aaron Montoya");
		display = new PopupDisplay();
	}
	
	public void start()
	{
		String response = display.getResponse("What do you want to talk about?");
		
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
		{
			response = popupChat(response);
			response = display.getResponse(response);
		}
	}
	
	//public String interactWithChatbot(String input)
	//{	
	//}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
}
