//import com.sun.security.ntlm.Client;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
	TextArea textfield1, wordToGuess, title;
	BorderPane connectingbox, categories, gameBorder, winning;
	Button helpBtn1, helpBtn2, helpBtn3, helpBtn4, helpBtn5, startButton, foods, animals, countries, newServer, newServer2, checkLetter,
			findNewServer, sameServer, wordStart, startWordGame, back1, back2;
	TextField address, foodsText, animalsText, countriesText,
			currentServerTitle, currentServerTitle2, currentServerText, currentServerText2, currentTitle, currentCategory,
			letterToGuess, incorrect, winningTitle, category1, category2, category3;
	VBox animalBox, foodsBox, countriesBox, currentVBox, wordGuessing;
	HBox overall, currentServer, currentServer2, letterGuessing, winningWords,
			serverConnection;

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
		wordToGuess = new TextArea("");
		wordToGuess.setMinHeight(300);
		checkLetter = new Button("check");
		currentVBox = new VBox(currentTitle, currentCategory);
		letterGuessing = new HBox(letterToGuess, checkLetter, startWordGame);
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
		findNewServer =  new Button("Find a new server");
		sameServer = new Button("Play again on the same server");
		winningTitle = new TextField("YOU WIN!!");
		category1 = new TextField("Category 1 word: \n word 1");
		category2 = new TextField("Category 2 word: \n word 2");
		category3 = new TextField("Category 3 word: \n word 3");
		winningWords = new HBox(category1, category2, category3);
		serverConnection = new HBox(findNewServer, sameServer);
		winning = new BorderPane();
		winning.setTop(winningTitle);
		winning.setRight(helpBtn4);
		winning.setCenter(winningWords);
		winning.setBottom(serverConnection);
		winning.setBackground(new Background(new BackgroundFill(
				Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
		return new Scene(winning, 700, 700);
	}

	public Scene loseScene(){
		TextField loseTitle, loseText;
		BorderPane losing;
		helpBtn5 = new Button("Help");
		loseTitle = new TextField("BETTER LUCK NEXT TIME!");
		loseText = new TextField("You did not guess at\n" +
				"least 1 correct word in\n" +
				"each category");
		losing = new BorderPane();
		losing.setTop(loseTitle);
		losing.setRight(helpBtn5);
		losing.setCenter(loseText);
		losing.setBottom(serverConnection);
		losing.setBackground(new Background(new BackgroundFill(
				Color.DARKCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
		return new Scene(losing, 700, 700);
	}

	public Scene helpScene1(){
		TextArea instructions1 = new TextArea("To start the game, you must first connect the" +
				" server to any port number of your liking. In order for the Server and the Client to be" +
				" connected properly, please enter the exact same port number to the text box below.");
		instructions1.setWrapText(true);
		Button back1 = new Button("Back");
		BorderPane helpPane1 = new BorderPane();
		helpPane1.setTop(instructions1);
		instructions1.setTranslateY(75);
		helpPane1.setCenter(back1);
		return new Scene(helpPane1,400,400);
	}

	public Scene helpScene2(){
		TextArea instructions2 = new TextArea("Continuing, you must choose a Category. You have 3 tries" +
				" in each category. You must only get 1 word correct in each category to win this game." +
				" After all 3 attempts are used in a singular category, you will not be able to continue the game.");

		instructions2.setWrapText(true);
		Button back2 = new Button("Back");
		BorderPane helpPane2 = new BorderPane();
		helpPane2.setTop(instructions2);
		instructions2.setTranslateY(75);
		helpPane2.setCenter(back1);
		return new Scene(helpPane2,400,400);
	}

	public Scene helpScene3(){
		TextArea instructions3 = new TextArea("Now you can actually play your game. In order to receive" +
				" a word to guess, you must press the generate word button. After you receive the word you " +
				"must guess, you can input a letter or an entire word into the small box next to the check button" +
				" if it is correct, the letter will replace the dash. If it is incorrect, the incorrect letter" +
				" will show up in the incorrect letters box. After 6 incorrect letter guesses, you fail to correctly" +
				" guess the word. You then must generate a new word.");
		instructions3.setWrapText(true);
		Button back3 = new Button("Back");
		BorderPane helpPane3 = new BorderPane();
		helpPane3.setTop(instructions3);
		instructions3.setTranslateY(75);
		helpPane3.setCenter(back1);
		return new Scene(helpPane3,400,400);
	}

//	public Scene helpScene4(){
//
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
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
		sceneMap.put("help 1",helpScene1());
		sceneMap.put("help 2",helpScene2());
//		sceneMap.put("help 3",helpScene3());
//		sceneMap.put("help 4",helpScene4());

		Scene scene = new Scene(new VBox(), 700,700);
		primaryStage.setScene(sceneMap.get("start"));
		primaryStage.show();

		helpBtn1.setOnAction( e -> {
			primaryStage.setScene(sceneMap.get("help 1"));
			back1.setOnAction( p -> {
				primaryStage.setScene(sceneMap.get("start"));
			});
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
		
		
		helpBtn2.setOnAction(e -> {
			primaryStage.setScene(sceneMap.get("help 2"));
			back2.setOnAction(p -> {
				primaryStage.setScene(sceneMap.get("start"));
			});

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
			
			System.out.println("at this point encoded word is: " + newClient.clientPack.encodedWord);
			
			primaryStage.setScene(sceneMap.get("game"));
			newClient.send(newClient.clientPack);
			currentServerText.setText(textfield1.getText());
			currentCategory.setText("Countries");
			});
		
		startWordGame.setOnAction(e -> {
			newClient.send(newClient.clientPack);
			wordToGuess.setText(newClient.clientPack.encodedWord);
			
		});
	}
	
	
	
	

}
