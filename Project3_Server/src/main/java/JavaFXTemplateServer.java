import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//add titles "Zacc and Nurs Word Guessing Game" maybe add client or server
//figure out help scenes
//fix up win/lose scenes -> add a temporary button that I will then remove
public class JavaFXTemplateServer extends Application {

	public void instructionHandler() {
		String a = String.format("To start the game, you must connect the" +
				" server to any port number of your liking. In order for the Server and the Client to be" +
				" connected properly, please enter the exact same port number to the text box in the Client.");
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, a);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.setTitle("Instructions");
		alert.setHeaderText("Connection Instructions");
		alert.show();
	}

	public void instructionHandler2() {
		String a = String.format("Here, the server can track all the moves that the client makes, In order to connect " +
				"to a new game, simply press the new server button at the bottom of your screen.");
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, a);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.setTitle("Server Log");
		alert.setHeaderText("Log Instructions");
		alert.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Word Game Server");
		Button helpBtn1 = new Button("Help");
		Button startButton = new Button("Connect");
		TextField address = new TextField();
		address.setPromptText("*address will appear here*");
		TextArea textfield1 = new TextArea();
		TextField screenTitle = new TextField("Nur and Zacc's Guessing Game - Server");
//		screenTitle.setWrapText(true);
		screenTitle.setMaxWidth(400);
		screenTitle.setMaxHeight(75);
		screenTitle.setAlignment(Pos.CENTER);
		screenTitle.setStyle("-fx-font: 20 arial;");
		VBox title = new VBox(screenTitle, textfield1);
		title.setSpacing(50);
		textfield1.setPromptText("Enter a server number of your liking to begin hosting!");
		BorderPane connectingbox = new BorderPane();
		connectingbox.setTop(title);
		connectingbox.setLeft(startButton);
		connectingbox.setCenter(address);
		connectingbox.setRight(helpBtn1);
		address.setMaxWidth(200);
		startButton.setTranslateY(400);
		startButton.setTranslateX(350);
		title.setTranslateY(175);
		title.setTranslateX(200);
		textfield1.setTranslateX(50);
		textfield1.setMaxHeight(50);
		textfield1.setMaxWidth(200);
		connectingbox.setBackground(new Background(new BackgroundFill(
				Color.LAVENDERBLUSH, CornerRadii.EMPTY, Insets.EMPTY)));
		Scene connectingScene = new Scene(connectingbox, 700, 700);
		helpBtn1.setOnAction( e-> {
			instructionHandler();
		});
		

		ListView<String> log = new ListView<String>();
		Button helpBtn2 = new Button("Help");
		TextField title2 = new TextField("Server Log");
		TextField currentServer = new TextField();
		TextField currentTitle = new TextField("current server");
		Button newServerbtn = new Button("host new server");
		HBox serverBottom = new HBox(currentTitle, currentServer, newServerbtn);
		BorderPane serverLog = new BorderPane();
		serverLog.setCenter(log);
		serverLog.setTop(title2);
		serverLog.setBottom(serverBottom);
		serverLog.setRight(helpBtn2);
		serverLog.setBackground(new Background(new BackgroundFill(
				Color.MIDNIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		Scene logScene = new Scene(serverLog, 700, 700);
		helpBtn2.setOnAction(e -> {
			instructionHandler2();
		});


		Scene scene = new Scene(new VBox(), 700,700);
		primaryStage.setScene(connectingScene);
		primaryStage.show();
		
		startButton.setOnAction(press2->
		{
			int newPort = 5555;
			Boolean isPortValid = true;
			try {
		        newPort = Integer.parseInt(textfield1.getText());
		    } catch (NumberFormatException nfe) {
		        isPortValid = false;
		    }
			if(isPortValid)
			{
				GameServer newServer = new GameServer(data->{
					Platform.runLater(()->{
						log.getItems().add(data.toString());
					});
				
					}, newPort);
				System.out.println("server added!");
				address.setPromptText(textfield1.getText());
				primaryStage.setScene(logScene);
				currentServer.setText(textfield1.getText());
			}else
			{
				System.out.println("error: invalid string for Port number");
			}
			
				});

		newServerbtn.setOnAction(e -> {
			primaryStage.setScene(connectingScene);
			textfield1.setText("");
			textfield1.setPromptText("Enter a server number of your liking to begin hosting!");
			address.setPromptText("*address will appear here*");
		});
		
	}

}
