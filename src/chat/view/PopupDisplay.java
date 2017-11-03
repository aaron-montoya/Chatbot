package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class PopupDisplay
{
	//Created ImageIcon and a string
	private ImageIcon icon;
	private String windowTitle;
	
	public PopupDisplay()
	{
		//Set the icon to an image from the images package
		icon = new ImageIcon(getClass().getResource("images/ChatPanda.png"));
		//Set the window title
		windowTitle = "ChatPanda says...";
	}
	
	public void displayText(String message)
	{
		//Shows a message popup
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	public String getResponse(String question)
	{
		String answer = "";

		//Shows a message popup with space for the user to type a response
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		
		return answer;
	}
}
