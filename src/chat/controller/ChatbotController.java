package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Aaron Montoya");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		//Makes a string called response that gets what the user typed in
		String response = display.getResponse("What do you want to talk about?");
		
		//If the response is longer than 2 and isn't quit, keep looping
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			//Call the popupChat method and pass the response to it
//			response = popupChat(response);
//			//Display the final response
//			response = display.getResponse(response);
//		}
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
