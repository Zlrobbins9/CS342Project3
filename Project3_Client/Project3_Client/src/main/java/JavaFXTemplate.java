import com.sun.security.ntlm.Client;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;

public class JavaFXTemplate extends Application {
	TextArea textfield1, wordToGuess;
	BorderPane connectingbox, categories, gameBorder, winning;
	Button help, startButton, foods, animals, countries, newServer, checkLetter,
			findNewServer, sameServer;
	TextField address, title, foodsText, animalsText, countriesText,
			currentServerTitle, currentServerText, currentTitle, currentCategory,
			letterToGuess, incorrect, winningTitle, category1, category2, category3;
	VBox animalBox, foodsBox, countriesBox, currentVBox, wordGuessing;;
	HBox hbox, overall, currentServer, top, letterGuessing, currentTop, winningWords,
			serverConnection, winningTop;

	public Scene startingScene(){
		help = new Button("Help");
		startButton = new Button("Connect");
		textfield1 = new TextArea("Search a server number to begin!");
		 address = new TextField();
		address.setPromptText("*Enter address here*");
		 hbox = new HBox(help, textfield1);
		textfield1.setTranslateY(200);
		hbox.setSpacing(250.0);
		 connectingbox = new BorderPane();
		connectingbox.setTop(hbox);
		connectingbox.setLeft(startButton);
		connectingbox.setCenter(address);
		//connectingbox.setRight(textfield1);
		help.setTranslateX(50);
		address.setMaxWidth(200);
		//address.setTranslateX(50);
		startButton.setTranslateY(400);
		startButton.setTranslateX(350);
		//textfield1.setTranslateY(200);
		textfield1.setMaxHeight(50);
		textfield1.setMaxWidth(200);

		return new Scene(connectingbox, 700, 700);
	}

	public Scene categoryScene() {

	categories = new BorderPane();
	foods = new Button("Food");
	animals = new Button("Animals");
	countries = new Button("Countries");
	newServer = new Button("Join new server");
	title = new TextField("WORD GAME\n Please choose a category");
	top = new HBox(title, help);
	foodsText = new TextField("Words Left: ");
	animalsText = new TextField("Words Left: ");
	countriesText = new TextField("Words Left: ");
	currentServerTitle = new TextField("current server");
		currentServerText = new TextField("current");
	animalBox = new VBox(animals, animalsText);
	countriesBox = new VBox(countries, countriesText);
	foodsBox = new VBox(foods, foodsText);
	overall = new HBox(animalBox, foodsBox, countriesBox);
	currentServer = new HBox(currentServerTitle, currentServerText, newServer);
	categories = new BorderPane();
	categories.setTop(top);
	categories.setCenter(overall);
	categories.setBottom(currentServer);

	return new Scene(categories, 700, 700);
	}

	public Scene gameScene(){


		currentTitle = new TextField("Current Category:");
		currentCategory = new TextField("Animals");
		letterToGuess = new TextField();
		incorrect = new TextField("Incorrect: \n");
		wordToGuess = new TextArea("---");
		checkLetter = new Button("check");
		currentVBox = new VBox(currentTitle, currentCategory);
		currentTop = new HBox(currentVBox, help);
		letterGuessing = new HBox(letterToGuess, checkLetter);
		wordGuessing = new VBox(wordToGuess, letterGuessing, incorrect);
		gameBorder = new BorderPane();
		gameBorder.setTop(currentTop);
		gameBorder.setCenter(wordGuessing);
		gameBorder.setBottom(currentServer);

		return new Scene(gameBorder, 700, 700);

	}

	public Scene winScene(){

		findNewServer =  new Button("Find a new server");
		sameServer = new Button("Play again on the same server");
		winningTitle = new TextField("YOU WIN!!");
		category1 = new TextField("Category 1 word: \n word 1");
		category2 = new TextField("Category 2 word: \n word 2");
		category3 = new TextField("Category 3 word: \n word 3");
		winningWords = new HBox(category1, category2, category3);
		serverConnection = new HBox(findNewServer, sameServer);
		winningTop = new HBox(winningTitle, help);
		winning = new BorderPane();
		winning.setTop(winningTop);
		winning.setCenter(winningWords);
		winning.setBottom(serverConnection);

		return new Scene(winning, 700, 700);
	}

	public Scene loseScene(){
		TextField loseTitle, loseText;
		HBox losingBox;
		BorderPane losing;

		loseTitle = new TextField("BETTER LUCK NEXT TIME!");
		loseText = new TextField("You did not guess at\n" +
				"least 1 correct word in\n" +
				"each category");
		losingBox = new HBox(loseTitle, help);
		losing = new BorderPane();
		losing.setTop(losingBox);
		losing.setCenter(loseText);
		losing.setBottom(serverConnection);

		return new Scene(losing, 700, 700);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//System.out.println(Integer.parseInt("Zacc"));
		// TODO Auto-generated method stub
		primaryStage.setTitle("Word Game Client");
		HashMap<String,Scene> sceneMap = new HashMap<String,Scene>();
		sceneMap.put("game", gameScene());
		sceneMap.put("category", categoryScene());
		sceneMap.put("start", startingScene());
		sceneMap.put("win", winScene());
		sceneMap.put("lose", loseScene());

		Scene scene = new Scene(new VBox(), 700,700);
		primaryStage.setScene(sceneMap.get("start"));
		primaryStage.show();
		
		startButton.setOnAction(press2->
		{
			Boolean isIPValid = true;
			try {
		        int newIP = Integer.parseInt(textfield1.getText());
		    } catch (NumberFormatException nfe) {
		        isIPValid = false;
		    }
			if(isIPValid)
			{
				GameClient newClient = new GameClient(data -> {
					Platform.runLater(()->{});
				});
			}else
			{
				System.out.println("error: invalid string for IP(?)");
			}
		});
	}

}
