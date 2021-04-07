import java.io.Serializable;


import java.util.*;

public class GameState implements Serializable {
//
        private static final long serialVersionUID = 1L;

        String infoCategories;
        String wordToGuess;
        String clientToServerWord;
        int resetSignal;
        char guess;
        boolean categChosen = false;
        boolean charChosen = false;
        boolean wordChosen = false;
        public static Random RNG = new Random();

        //Category 1: Animals
        public ArrayList<String> Animals = new ArrayList<>(
                Arrays.asList("cat", "dog", "butterfly", "wasp", "tiger",
                        "bear", "penguin", "eagle", "turtle", "spider"));

        //Category 2: Food
        public ArrayList<String> Food = new ArrayList<>(
                Arrays.asList("eggs", "cereal", "bananas", "grape", "rice",
                        "chicken", "yogurt", "pancake","cucumber"));

        //Category 3: Countries
        public ArrayList<String> Countries = new ArrayList<>(
                Arrays.asList("America", "Chile", "Cuba", "China", "Sweden",
                        "Greenland", "Germany", "Mexico", "Palestine", "India"));

        // returns to category Array name
        public ArrayList<String> getCategory(String category)
        {
            if (category.equals("Animals"))
                return Animals;
            else if (category.equals("Food"))
                return Food;
            else if (category.equals("Countries"))
                return Countries;
            return new ArrayList<>();
        }

        // get words from arrays
        public String getWord(ArrayList<String> myCategory)
        {
            int index = RNG.nextInt(myCategory.size() - 1);
            return myCategory.get(index);
        }

        // checks if the letter exists in the word
        String checkLetterExists(String word, char y) {
            boolean isExist = false;
            StringBuilder str = new StringBuilder();
            for(int x = 0; x < word.length(); x++) {
                if(word.charAt(x) == y) {
                    isExist = true;
                    str.append(x+1);
                }
            }
            if(isExist) {
                return str.toString();
            }
            else {
                return "999";
            }
        }

    }

