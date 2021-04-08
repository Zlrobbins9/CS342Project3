import java.io.Serializable;
import java.util.ArrayList;

public class SerializableInfo implements Serializable {
    private static final long  serialVersionUID = 1L;
    public String categChoice;
    public int size;

    public int animalsAttemps;
    public int foodAttempts;
    public int countriesAttempts;

    public boolean animalsDone;
    public boolean countriesDone;
    public boolean foodDone;

    public char letterGuess;
    public String wordGuess;

    public int letterGuessLeft;
    public int wordGuessLeft;

    public boolean letterCorrect;
    public boolean wordCorrect;
    public boolean isCategChosen;
    public boolean isLetterGuessing;
    public boolean isWordGuessing;

    public boolean connectionFail;
    public boolean replayRequest;

    public ArrayList<Integer> letterPos;

    public SerializableInfo() {
        categChoice = "";
        size = 0;
        animalsAttemps = foodAttempts = countriesAttempts = 3;

        letterGuess = '\0';
        wordGuess = "";

        isCategChosen = isLetterGuessing = isWordGuessing = false;
        connectionFail = replayRequest = false;
        animalsDone = foodDone = countriesDone = false;

        letterCorrect = wordCorrect = false;
        letterPos = new ArrayList<Integer>();
    }
}
