//import com.sun.security.ntlm.Client;
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

@SuppressWarnings({ "unused", "restriction" })
public class JavaFXTemplateClient extends Application {
	TextArea textfield1, wordToGuess, title;
	BorderPane connectingbox, categories, gameBorder, winning;
	Button help, startButton, foods, animals, countries, newServer, newServer2, checkLetter,
			findNewServer, sameServer, wordStart, startWordGame;
	TextField address, foodsText, animalsText, countriesText,
			currentServerTitle, currentServerTitle2, currentServerText, currentServerText2, currentTitle, currentCategory,
			letterToGuess, incorrect, winningTitle, category1, category2, category3;
	VBox animalBox, foodsBox, countriesBox, currentVBox, wordGuessing;
	HBox hbox, overall, currentServer, currentServer2, top, letterGuessing, currentTop, winningWords,
			serverConnection, winningTop;

	GameClient newClient;
	
	public Scene startingScene(){
		
		
		startButton = new Button("Connect");
		textfield1 = new TextArea();
		textfield1.setPromptText("Search a server number to begin!");
		 address = new TextField();
		address.setPromptText("*address will appear here*");
		 hbox = new HBox(help, textfield1);
		//textfield1.setTranslateY(200);
		hbox.setSpacing(250.0);
		
		 connectingbox = new BorderPane();
		 
		connectingbox.setTop(hbox);
		connectingbox.setLeft(startButton);
		connectingbox.setCenter(address);
		help.setTranslateX(50);
		address.setMaxWidth(200);
		//address.setTranslateX(50);
		startButton.setTranslateY(400);
		startButton.setTranslateX(350);
		textfield1.setTranslateY(200);
		textfield1.setTranslateX(275);
		textfield1.setMaxHeight(50);
		textfield1.setMaxWidth(200);

		return new Scene(connectingbox, 700, 700);
		
	}

	public Scene categoryScene() {

	categories = new BorderPane();
	foods = new Button("Food");
	animals = new Button("Animals");
	countries = new Button("Countries");
	newServer2 = new Button("Join new server");
	title = new TextArea("Word Game! Please choose a category");
	title.setMaxHeight(20);
	title.setMaxWidth(240);
	top = new HBox(title, help);
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
	categories.setTop(top);
	categories.setCenter(overall);
	categories.setBottom(currentServer2);
	overall.setTranslateY(250);

	return new Scene(categories, 700, 700);
	}

	public Scene gameScene(){

		startWordGame = new Button("Generate Word");
		help = new Button("Help");
		currentTitle = new TextField("Current Category:");
		currentTitle.setEditable(false);
		currentCategory = new TextField();
		letterToGuess = new TextField();
		incorrect = new TextField("Incorrect: \n");
		wordToGuess = new TextArea("");
		wordToGuess.setMinHeight(300);
		checkLetter = new Button("check");
		currentVBox = new VBox(currentTitle, currentCategory);
		currentTop = new HBox(currentVBox, help); //marked as maybe breaking
		letterGuessing = new HBox(letterToGuess, checkLetter, startWordGame);
		wordGuessing = new VBox(wordToGuess, letterGuessing, incorrect);
		wordGuessing.setSpacing(50);
		newServer = new Button("Join new server");
		currentServerTitle = new TextField("current Port Number: ");
		currentServerTitle.setEditable(false);
		currentServerText = new TextField();
		currentServerText.setEditable(false);
		currentServer = new HBox(currentServerTitle, currentServerText, newServer);
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
			currentServerText2.setText(textfield1.getText());
			currentCategory.setText("Foods");
			});
		animals.setOnAction(e->{
			newClient.clientPack.categoryChosen = "Animals"; //causing nullptr exception
			newClient.send(newClient.clientPack);
			wordToGuess.setText(newClient.clientPack.encodedWord);
			primaryStage.setScene(sceneMap.get("game"));
			currentServerText2.setText(textfield1.getText());
			currentCategory.setText("Animals");
			});
		countries.setOnAction(e->{
			newClient.clientPack.categoryChosen = "Countries"; //does NOT cause nullptr exception
			
			System.out.println("at this point encoded word is: " + newClient.clientPack.encodedWord);
			
			primaryStage.setScene(sceneMap.get("game"));
			//newClient.send(newClient.clientPack); 
			currentServerText2.setText(textfield1.getText());
			currentCategory.setText("Countries");
			});
		
		startWordGame.setOnAction(e -> {
			newClient.send(newClient.clientPack);
			wordToGuess.setText(newClient.clientPack.encodedWord);
			
		});
	}
	
	
	
	

}
