//import com.sun.security.ntlm.Client;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.HashMap;

@SuppressWarnings({ "unused", "restriction" })
public class JavaFXTemplateClient extends Application {
	TextArea textfield1, title;
	BorderPane connectingbox, categories, gameBorder, winning;
	Button helpBtn1, helpBtn2, helpBtn3, helpBtn4, helpBtn5, startButton, foods, animals, countries, newServer, newServer2, checkLetter,
			findNewServerLose, sameServerLose, findNewServerWin, sameServerWin, wordStart, startWordGame, testingWin, testingLose;
	TextField wordToGuess, address, foodsText, animalsText, countriesText,
			currentServerTitle, currentServerTitle2, currentServerText, currentServerText2, currentTitle, currentCategory,
			letterToGuess, incorrect, winningTitle, category1, category2, category3;
	VBox animalBox, foodsBox, countriesBox, currentVBox, wordGuessing;
	HBox overall, currentServer, currentServer2, letterGuessing, winningWords,
			serverConnectionLose, serverConnectionWin;

	GameClient newClient;


	public Scene startingScene(){


		startButton = new Button("Connect");
		textfield1 = new TextArea();
		textfield1.setPromptText("Search a server number to begin!");
		address = new TextField();
		helpBtn1 = new Button("Help");
		address.setPromptText("*address will appear here*");
		//textfield1.setTranslateY(200);

		connectingbox = new BorderPane();

		connectingbox.setTop(textfield1);
		connectingbox.setLeft(startButton);
		connectingbox.setCenter(address);
		connectingbox.setRight(helpBtn1);
		//helpBtn1.setTranslateX(50);
		address.setMaxWidth(200);
		//address.setTranslateX(50);
		startButton.setTranslateY(400);
		startButton.setTranslateX(350);
		textfield1.setTranslateY(200);
		textfield1.setTranslateX(275);
		textfield1.setMaxHeight(50);
		textfield1.setMaxWidth(200);
		connectingbox.setBackground(new Background(new BackgroundFill(
				Color.LAVENDERBLUSH, CornerRadii.EMPTY, Insets.EMPTY)));
		return new Scene(connectingbox, 700, 700);

	}

	public Scene categoryScene() {

		categories = new BorderPane();
		foods = new Button("Food");
		animals = new Button("Animals");
		countries = new Button("Countries");
		helpBtn2 = new Button("Help");
		newServer2 = new Button("Join new server");
		title = new TextArea("Word Game! Please choose a category");
		title.setMaxHeight(20);
		title.setMaxWidth(240);
		foodsText = new TextField("Words Left: ");
		animalsText = new TextField("Words Left: ");
		countriesText = new TextField("Words Left: ");
		currentServerTitle2 = new TextField("current Port Number: ");
		currentServerTitle2.setEditable(false);
		currentServerText2 = new TextField();
		animalBox = new VBox(animals, animalsText);
		countriesBox = new VBox(countries, countriesText);
		foodsBox = new VBox(foods, foodsText);
		overall = new HBox(animalBox, foodsBox, countriesBox);
		animalBox.setSpacing(20);
		countriesBox.setSpacing(20);
		foodsBox.setSpacing(20);
		overall.setSpacing(100);
		currentServer2 = new HBox(currentServerTitle2, currentServerText2, newServer2);
		categories = new BorderPane();
		categories.setTop(title);
		categories.setCenter(overall);
		categories.setBottom(currentServer2);
		categories.setRight(helpBtn2);
		overall.setTranslateY(250);
		categories.setBackground(new Background(new BackgroundFill(
				Color.MIDNIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

		return new Scene(categories, 700, 700);
	}


	public Scene gameScene(){

		startWordGame = new Button("Generate Word");
		helpBtn3 = new Button("Help");
		currentTitle = new TextField("Current Category:");
		currentTitle.setMaxWidth(115);
		currentTitle.setEditable(false);
		currentCategory = new TextField();
		currentCategory.setMaxWidth(75);
		currentCategory.setEditable(false);
		letterToGuess = new TextField();
		incorrect = new TextField("Incorrect: ");
		wordToGuess = new TextField("");
		wordToGuess.setStyle("-fx-font: 90 arial;");
		wordToGuess.setMinHeight(300);
		wordToGuess.setAlignment(Pos.CENTER);
		checkLetter = new Button("check");
		currentVBox = new VBox(currentTitle, currentCategory);
		testingLose = new Button("Testing Lose");
		testingWin = new Button("Testing Win");
		letterGuessing = new HBox(letterToGuess, checkLetter, startWordGame, testingWin, testingLose);
		letterGuessing.setSpacing(20);
		wordGuessing = new VBox(wordToGuess, letterGuessing, incorrect);
		wordGuessing.setSpacing(50);
		wordGuessing.setTranslateY(20);
		newServer = new Button("Join new server");
		currentServerTitle = new TextField("current Port Number: ");
		currentServerTitle.setEditable(false);
		currentServerText = new TextField();
		currentServerText.setEditable(false);
		currentServer = new HBox(currentServerTitle, currentServerText, newServer);
		gameBorder = new BorderPane();
		gameBorder.setTop(currentVBox);
		gameBorder.setCenter(wordGuessing);
		gameBorder.setBottom(currentServer);
		gameBorder.setRight(helpBtn3);
		gameBorder.setBackground(new Background(new BackgroundFill(
				Color.LIGHTSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		return new Scene(gameBorder, 700, 700);




	}

	public Scene winScene(){

		helpBtn4 = new Button("Help");
		findNewServerWin =  new Button("Find a new server");
		sameServerWin = new Button("Play again on the same server");
		winningTitle = new TextField("YOU WIN!!");
		winningTitle.setEditable(false);
		winningTitle.setStyle("-fx-font: 30 arial;");
		winningTitle.setMaxWidth(200);
		category1 = new TextField("Category 1 word: ");
		category2 = new TextField("Category 2 word: ");
		category3 = new TextField("Category 3 word: ");
		winningWords = new HBox(category1, category2, category3);
		winningWords.setSpacing(70);
		serverConnectionWin = new HBox(findNewServerWin, sameServerWin);
		serverConnectionWin.setSpacing(70);
		winning = new BorderPane();
		winning.setTop(winningTitle);
		winning.setRight(helpBtn4);
		winning.setCenter(winningWords);
		winningWords.setTranslateY(200);
		winningTitle.setTranslateX(150);
		winning.setBottom(serverConnectionWin);
		winning.setBackground(new Background(new BackgroundFill(
				Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		return new Scene(winning, 700, 700);
	}

	public Scene loseScene(){
		TextField loseTitle;
		TextArea loseText;
		BorderPane losing;
		findNewServerLose =  new Button("Find a new server");
		sameServerLose = new Button("Play again on the same server");
		serverConnectionLose = new HBox(findNewServerLose, sameServerLose);
		serverConnectionLose.setSpacing(70);
		helpBtn5 = new Button("Help");
		loseTitle = new TextField("BETTER LUCK NEXT TIME!");
		loseTitle.setEditable(false);
		loseTitle.setStyle("-fx-font: 30 arial;");
		loseTitle.setMaxWidth(400);
		loseText = new TextArea("You did not guess at least 1 correct word in " +
				"each category");
		loseText.setWrapText(true);
		loseText.setMaxWidth(400);
		loseText.setMaxHeight(50);
		losing = new BorderPane();
		losing.setTop(loseTitle);
		losing.setRight(helpBtn5);
		losing.setCenter(loseText);
		loseText.setTranslateY(200);
		loseTitle.setTranslateX(200);
		losing.setBottom(serverConnectionLose);
		losing.setBackground(new Background(new BackgroundFill(
				Color.DARKCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
		return new Scene(losing, 700, 700);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	public void instructionHandler() {
		String a = String.format("To start the game, you must first connect the" +
				" server to any port number of your liking. In order for the Server and the Client to be" +
				" connected properly, please enter the exact same port number to the text box below.");
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, a);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.setTitle("Instructions");
		alert.setHeaderText("Connection Instructions");
		alert.show();
	}

	public void instructionHandler2() {
		String a = String.format("Continuing, you must choose a Category. You have 3 tries" +
				" in each category. You must only get 1 word correct in each category to win this game." +
				" After all 3 attempts are used in a singular category, you will not be able to continue the game.");
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, a);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.setTitle("Instructions");
		alert.setHeaderText("Category Instructions");
		alert.show();
	}

	public void instructionHandler3() {
		String a = String.format( "Now you can actually play your game. In order to receive" +
				" a word to guess, you must press the generate word button. After you receive the word you " +
				"must guess, you can input a letter or an entire word into the small box next to the check button" +
				" if it is correct, the letter will replace the dash. If it is incorrect, the incorrect letter" +
				" will show up in the incorrect letters box. After 6 incorrect letter guesses, you fail to correctly" +
				" guess the word. You then must generate a new word.");
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, a);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.setTitle("Instructions");
		alert.setHeaderText("Game Instructions");
		alert.show();
	}

	public void instructionHandler4() {
		String a = String.format( "If you would like to play again, you can either continue to play on this " +
				"server or you could pick a new server");
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, a);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.setTitle("Instructions");
		alert.setHeaderText("Ending Instructions");
		alert.show();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {

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

		helpBtn1.setOnAction( e -> {
			instructionHandler();
		});


		startButton.setOnAction(press2->
		{

			Boolean isPortValid = true;
			int newPort = 5555;

			try {
				newPort = Integer.parseInt(textfield1.getText());
			} catch (NumberFormatException nfe) {
				isPortValid = false;
			}
			if(isPortValid)
			{
				primaryStage.setScene(sceneMap.get("category"));
				primaryStage.setTitle("Client: Begin Game");
				currentServerText2.setText("" + newPort);
				newClient = new GameClient(data -> {
					Platform.runLater(()->{});
				}, newPort);
				newClient.start();
			}else
			{
				primaryStage.setScene(sceneMap.get("category"));
				primaryStage.setTitle("Client: Begin Game");
				currentServerText2.setText("" + 5555);
				GameClient newClient = new GameClient(data -> {
					Platform.runLater(()->{});
				}, 5555);
				System.out.println("error: invalid string for Port number, resorting to default values...");
				newClient.start();
			}
		});


		helpBtn2.setOnAction( e -> {
			instructionHandler2();
		});

		helpBtn3.setOnAction( e -> {
			instructionHandler3();
		});

		helpBtn4.setOnAction( e -> {
			instructionHandler4();
		});

		helpBtn5.setOnAction( e -> {
			instructionHandler4();
		});

		newServer.setOnAction(e -> {
			primaryStage.setScene(sceneMap.get("start"));
			textfield1.setText("");
			textfield1.setPromptText("Search a server number to begin!");
			address.setPromptText("*address will appear here*");
		});

		foods.setOnAction(e->{
			newClient.clientPack.categoryChosen = "Food"; //does NOT cause nullptr
			newClient.send(newClient.clientPack);
			wordToGuess.setText(newClient.clientPack.encodedWord); //however, this prints out the wrong thing
			primaryStage.setScene(sceneMap.get("game"));
			currentServerText.setText(textfield1.getText());
			currentCategory.setText("Foods");
		});
		animals.setOnAction(e->{
			newClient.clientPack.categoryChosen = "Animals"; //causing nullptr exception
			newClient.send(newClient.clientPack);
			wordToGuess.setText(newClient.clientPack.encodedWord);
			primaryStage.setScene(sceneMap.get("game"));
			currentServerText.setText(textfield1.getText());
			currentCategory.setText("Animals");
		});
		countries.setOnAction(e->{
			newClient.clientPack.categoryChosen = "Countries"; //does NOT cause nullptr exception
			newClient.clientPack.choosingCategory = true;
			System.out.println("at this point encoded word is: " + newClient.clientPack.encodedWord);
			newClient.send(newClient.clientPack);
			primaryStage.setScene(sceneMap.get("game"));
//			newClient.send(newClient.clientPack);
			currentServerText.setText(textfield1.getText());
			currentCategory.setText("Countries");
		});

		startWordGame.setOnAction(e -> {
			newClient.clientPack.choosingCategory = false;
			newClient.clientPack.wordSent = true;
			newClient.send(newClient.clientPack);
			wordToGuess.setText(newClient.clientPack.encodedWord);
			startWordGame.setDisable(true);
			wordToGuess.setStyle("-fx-font: 90 arial;");
		});

		testingWin.setOnAction(e -> {
			primaryStage.setScene(sceneMap.get("win"));
		});

		testingLose.setOnAction(e -> {
			primaryStage.setScene(sceneMap.get("lose"));
		});

		checkLetter.setOnAction(e -> {
			System.out.println("before lowercaseification, input is: " + letterToGuess.getText());
			//TODO: lowercaseify all chars of input
			//TODO; set error message for empty input.
			if(newClient.clientPack.isAllAlNum(letterToGuess.getText())) // determines there are only letters in text lettertoget.
			{
				letterToGuess.setText(lowercaseify(letterToGuess.getText())); //NEW: changes the input to all lowercase
				System.out.println("after lowercaseification, input is: " + letterToGuess.getText());
				if(letterToGuess.getText().length() == 1) //input is char
				{
					newClient.clientPack.guessType = "char";
					newClient.clientPack.letterGuess = letterToGuess.getText().charAt(0);
					newClient.send(newClient.clientPack);
				}else if(letterToGuess.getText().length() > 1) //input is string
				{
					newClient.clientPack.guessType = "String";
					newClient.clientPack.wordGuess = letterToGuess.getText();
					newClient.send(newClient.clientPack);
				}else //no input
				{
					System.out.println("error: nothing is inputted! >:(");
				}
				
			}else
			{
				System.out.println("error: invalid character, please try again.");
			}

		});
	}
	
	String lowercaseify(String upperString)
	{
		char[] tempWord = upperString.toCharArray();
		for(int i = 0; i < tempWord.length; i++) 
		{
			tempWord[i] = Character.toLowerCase(tempWord[i]);
        }
		return String.valueOf(tempWord);
	}





}
