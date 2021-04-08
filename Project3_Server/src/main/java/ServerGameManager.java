import java.io.Serializable;
import java.util.*;



public class ServerGameManager{

		String infoCategories;
	    String decodedword;
	    int resetSignal;
	    char guess;
	    public static Random RNG = new Random();
	    

	    UpdatePack sendingPack = new UpdatePack();
	    HashMap<String, ArrayList<String>> CategoryMap = new HashMap<String, ArrayList<String>>();
	    
	    ServerGameManager()
	    {
	    	CategoryMap.put("Animals", new ArrayList<>(
	                Arrays.asList("cat", "pig", "butterfly", "wasp", "tiger",
	                        "bear", "penguin", "eagle", "turtle", "spider", "shark", "bee")));
	    	
	    	CategoryMap.put("Food", new ArrayList<>(
	                Arrays.asList("egg", "cereal", "banana", "grape", "rice",
	                        "chicken", "yogurt", "pancake","cucumber", "butter", "tacos")));
	    	
	    	CategoryMap.put("Countries", new ArrayList<>(
	                Arrays.asList("America", "Chile", "Cuba", "China", "Sweden",
	                        "Greenland", "Germany", "Mexico", "Palestine", "India", "Chad")));
	    }
	    
	    
	    public void ExportUpdatePack()
	    {
	    	if(sendingPack.encodedWord == "no word provided" && sendingPack.categoryChosen != "none") //update word 
	    	{
	    		sendingPack.encodedWord = getWord(CategoryMap.get(sendingPack.categoryChosen));
	    	}
	    	
	    	if(!checkLetterExists(sendingPack.encodedWord,'_'))
	    	{
	    		char[] tempWord = sendingPack.encodedWord.toCharArray();
	    		for(int i = 0; i < tempWord.length; i++) 
	    		{
	                if(tempWord[i] != ' ') 
	                {
	                	tempWord[i] = '_';
	                }
	            }
	    		sendingPack.encodedWord = String.valueOf(tempWord);
	    	}
	    }

	    // Gets words from the category Arrays.
	    public String getWord(ArrayList<String> myCategory)
	    {
	        int index = RNG.nextInt(myCategory.size() - 1);
	        return myCategory.get(index);
	    }

	    // Checks if the letter exists in the word
	    boolean checkLetterExists(String word, char searchChar) {
	        for(int i = 0; i < word.length(); i++) 
	        {
	            if(word.charAt(i) == searchChar) 
	            {
	            	return true;
	            }
	        }
	        return false;
	    }

	}


