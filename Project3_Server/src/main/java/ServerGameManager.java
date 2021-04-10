import java.io.Serializable;
import java.util.*;



public class ServerGameManager{



	    public ArrayList<Integer> letterPos;
	    
	    String decodedWord;
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
	                        "chicken", "yogurt", "pancake","cucumber", "burger", "taco", "pasta")));
	    	
	    	CategoryMap.put("Countries", new ArrayList<>(
	                Arrays.asList("america", "chile", "cuba", "china", "sweden",
	                        "greenland", "germany", "mexico", "palestine", "india", "thailand", "britain")));
	    }
	    
	    
	    public void ExportUpdatePack()
	    {
	    	if(sendingPack.encodedWord == "no word provided" && sendingPack.categoryChosen != "none") //update word 
	    	{
	    		sendingPack.encodedWord = getWord(CategoryMap.get(sendingPack.categoryChosen));
	    	}
	    	
	    	if(!checkLetterExists(sendingPack.encodedWord,'-'))
	    	{
	    		
	    	}
	    }

	    // Gets words from the category Arrays.
	    public String getWord(ArrayList<String> myCategory)
	    {
	        int index = RNG.nextInt(myCategory.size() - 1);
	        return myCategory.get(index);
	    }
	    
	    public void encodeDecodedWord()
	    {
	    	char[] tempWord = decodedWord.toCharArray();
    		for(int i = 0; i < tempWord.length; i++) 
    		{
                if(tempWord[i] != ' ') 
                {
                	tempWord[i] = '-';
                }
            }
    		sendingPack.encodedWord = String.valueOf(tempWord);
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
	    
	    String partiallyDecodeWord(String decodedWord, String codedWord, char charGuess)
	    {
	    	char[] tempWord = codedWord.toCharArray();
    		for(int i = 0; i < tempWord.length; i++) 
    		{
                if(decodedWord.charAt(i) == charGuess) 
                {
                	tempWord[i] = charGuess;
                }
            }
    		return String.valueOf(tempWord);
	    }

	}


