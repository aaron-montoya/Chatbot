package chat.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.*;

public class ChatPanel extends JPanel
{
	private ChatbotController appController; 
	private JButton loadButton;
	private JButton saveButton;
	private JButton searchButton;
	private JButton tweetButton;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		//Initialize GUI data members
		loadButton = new JButton("Load", new ImageIcon(getClass().getResource("/chat/view/images/Load.png")));
		saveButton = new JButton("Save", new ImageIcon(getClass().getResource("/chat/view/images/Save.png")));
		searchButton = new JButton("Search", new ImageIcon(getClass().getResource("/chat/view/images/Search.png")));
		tweetButton = new JButton("Tweet", new ImageIcon(getClass().getResource("/chat/view/images/Tweet.png")));
		chatButton = new JButton("Chat", new ImageIcon(getClass().getResource("/chat/view/images/Chat.png")));
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		
		infoLabel = new JLabel("Type to chat with chatbot");
		chatScrollPane = new JScrollPane();
		
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupScrollPane() {
		chatScrollPane.setViewportView(chatArea);
		
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.YELLOW);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(loadButton);
		this.add(saveButton);
		this.add(searchButton);
		this.add(tweetButton);
		this.add(inputField);
		this.add(chatScrollPane);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 57, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 3, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 6, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.EAST, searchButton, -212, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 429, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, tweetButton, 429, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, -6, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, searchButton);
		appLayout.putConstraint(SpringLayout.NORTH, searchButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 6, SpringLayout.SOUTH, tweetButton);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -212, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, inputField, -352, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, tweetButton, -6, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -67, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 25, SpringLayout.WEST, this);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.tweet(inputField.getText());
			}
		});
		
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
			
	}
	
	
}
