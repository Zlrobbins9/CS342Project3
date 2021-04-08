import java.io.Serializable;

public class UpdatePack implements Serializable {
	 //replace these 3 with lists
    public int animalsAttemps;
    public int foodAttempts;
    public int countriesAttempts;



    public char letterGuess;
    public String wordGuess;

    public int letterGuessLeft;
    public int wordGuessLeft;

    public boolean letterCorrect;
    public boolean wordCorrect;
    
    public boolean isLetterGuessing;
    public boolean isWordGuessing;

    public boolean connectionFail;
    public boolean replayRequest;
    
	
	
	
	String categoryChosen = "none";
	    	String encodedWord = "no word provided";
	    	int WordID;
	    	char chosenChar = ' ';
	    	int incorrectguesses = 0;
	    	
	    	//change to string to consider more scenarios, like all words exhausted and failed.
		    public boolean animalsDone;
		    public boolean countriesDone;
		    public boolean foodDone;
		    
	    	private static final long serialVersionUID = 1L;
	    	UpdatePack()
	    	{
	    		
	    	}
	    }
