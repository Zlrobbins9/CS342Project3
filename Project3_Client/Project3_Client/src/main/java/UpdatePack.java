import java.io.Serializable;

public class UpdatePack implements Serializable {
	 //replace these 3 with lists
    public int animalsAttemps;
    public int foodAttempts;
    public int countriesAttempts;

    //login, category, game, lose, win
    public String gameState = "login";

    public char letterGuess;
    public String wordGuess;
    public String guessType = "none";

    public int letterGuessLeft;
    public int wordGuessLeft;

    public boolean letterCorrect;
    public boolean wordCorrect;
    
    public boolean connectionFail;
    public boolean replayRequest;
    
	
	
	
	String categoryChosen = "none";
	String encodedWord = "no word provided";
	int WordID;
	    	
	    	//change to string to consider more scenarios, like all words exhausted and failed.
		    public boolean animalsDone;
		    public boolean countriesDone;
		    public boolean foodDone;
		    
	    	private static final long serialVersionUID = 1L;
	    	UpdatePack()
	    	{
	    		
	    	}
	    	
	    	public Boolean isAllAlNum(String testWord)
	    	{
	    		char[] tempWord = testWord.toCharArray();
	    		for(int i = 0; i < tempWord.length; i++) 
	    		{
	    			if(!Character.isLetter(tempWord[i]))
	    			{
	    				return false;
	    			}
	
	    		}
	    		return true;
	    	}
	    }
