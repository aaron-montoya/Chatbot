package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = null;
		
		buildVerbs();
		buildTopics();
		buildQuestions();
		buildMovieList();
		buildShoppingList();
		buildCuteAnimals();
	}
	
	/**
	 * Build the verb list
	 */
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	/**
	 * Build all the topics
	 */
	private void buildTopics()
	{
		topics[0] = "Sports";
		topics[1] = "Programming";
		topics[2] = "Clothes";
		topics[3] = "Movies";
		topics[4] = "Food";
		topics[5] = "Books";
		topics[6] = "News";
	}

	/**
	 * Build the list of movies
	 */
	private void buildMovieList()
	{
		
	}
	
	/**
	 * Build the shopping list
	 */
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("malk");
		shoppingList.add("yellow");
		shoppingList.add("bop it");
		shoppingList.add("death sticks");
		shoppingList.add("melons");
		shoppingList.add("love");
		shoppingList.add("chicknen mcchugnets");
		shoppingList.add("snail bait");
	}
	
	/**
	 * Build the list of animals
	 */
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("FLOOFER");
	}
	
	/**
	 * Build the list of questions
	 */
	private void buildQuestions()
	{
		questions[0] = "What about you?";
		questions[1] = "What's your favorite sport?";
		questions[2] = "How are you today?";
		questions[3] = "Do you like food?";
		questions[4] = "What's your favorite movie?";
		questions[5] = "Do you have a favorite book?";
		questions[6] = "How 'bout dat news?";
		questions[7] = "Do you trust me?";
		questions[8] = "What's your favorite dog?";
		questions[9] = "What is your favorite song?";
	}
	
	/**
	 * Tells what the user said, then calls buildChatbotResponse
	 * @param input What the user said
	 * @return Returns a String of what the user said, plus what was added from buildChatbotResponse
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse = "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 * Uses random numbers to build a response from a verb, topic and a question. Also has a fifty percent chance of saying something from the shopping list
	 * @return Returns a sentence
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * 2);
		
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * shoppingList.size());
			response += "\n" + shoppingList.get(random) + " is something I need to get from the store";
		}
		return response;
	}
	
	/**
	 * Checks the length of the users response
	 * @param input What the user said
	 * @return Returns true if the message is long enough
	 */
	public boolean lengthChecker(String input)
	{
		boolean valid_length = false;
		
		if (input != null)
		{
			if (input.length() > 2)
			{
				valid_length = true;
			}
		}
			
		
		return valid_length;
	}
	
	/**
	 * Checks to make sure the HTML tags are correct
	 * @param input What the user said
	 * @return Returns true if it's a valid HTML tag
	 */
	public boolean htmlTagChecker(String input)
	{
		boolean valid_tag = false;
		
		if(input.contains("<B>  </B>") || input.contains("<I> sdadas </i>") || input.contains("<P>") || input.contains("<A HREF=\"sdfs.html\"> </a>"))
		{
			valid_tag = true;
		}
		else if(input.contains("<>") || input.contains("< >") || input.contains("<B>  ") || input.contains("<A HREF> </a>"))
		{
			valid_tag = false;
		}
		
		return valid_tag;
	}
	
	/**
	 * Make sure that the username is valid
	 * @param input What the user said
	 * @return Returns true if it's a valid username
	 */
	public boolean userNameChecker(String input)
	{
		boolean valid_username = false;
		if(input != null && input.length() > 0 && input.indexOf("@") == 0 && !input.contains("@@"))
		{
			valid_username = true;
		}
		return valid_username;
	
	}
	
	/**
	 * 
	 * @param contentCheck
	 * @return
	 */
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	/**
	 * Checks to make sure that the correct animal memes are there
	 * @param input What the user said
	 * @return Returns true if you have the correct memes
	 */
	public boolean cuteAnimalMemeChecker(String input)
	{
		boolean correct_memes = false;
		
		if(input.contains("pupper") || input.contains("otter") || input.contains("kittie"))
		{
			correct_memes = true;
		}
		else if(input.contains("pepe"))
		{
			correct_memes = false;
		}
		
		return correct_memes;
	}
	
	/**
	 * Makes sure that you have certain items in your shopping list
	 * @param shoppingItem The item from the shopping list
	 * @return Returns true if it doesn't have any items that shouldn't have.
	 */
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean valid_list = false;
		for(int index = 0; index < shoppingList.size(); index++)
		{
			if (shoppingItem.contains(shoppingList.get(index)))
			{
				valid_list = true;
			}
		}
		
		return valid_list;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		if (exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		boolean pass = false;
		
		if(sample.contains("sdf") || sample.contains("SDF") || sample.contains("dfg") || sample.contains("cvb") || sample.contains(",./") || sample.contains("kjh") || sample.contains("DFG") || sample.contains("CVB") || sample.contains("KJH"))
		{
			pass = true;
		}
		else if(sample.contains("S.D.F.") || sample.contains("derf"))
		{
			pass = false;
		}
		
		return pass;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String [] getVerbs()
	{
		return verbs;
	}

	public String [] getTopics()
	{
		return topics;
	}

	public String [] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
