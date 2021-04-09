import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//add titles "Zacc and Nurs Word Guessing Game" maybe add client or server
//figure out help scenes
//fix up win/lose scenes -> add a temporary button that I will then remove
public class JavaFXTemplateServer extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Word Game Server");
		Button helpBtn = new Button("Help");
		Button startButton = new Button("Connect");
		TextField address = new TextField();
		address.setPromptText("*address will appear here*");
		TextArea textfield1 = new TextArea();
		textfield1.setPromptText("Enter a server number of your liking to begin hosting!");
		BorderPane connectingbox = new BorderPane();
		connectingbox.setTop(textfield1);
		connectingbox.setLeft(startButton);
		connectingbox.setRight(helpBtn);
		connectingbox.setCenter(address);
		address.setMaxWidth(200);
		startButton.setTranslateY(400);
		startButton.setTranslateX(350);
		textfield1.setTranslateY(200);
		textfield1.setTranslateX(275);
		textfield1.setMaxHeight(50);
		textfield1.setMaxWidth(200);
		connectingbox.setBackground(new Background(new BackgroundFill(
				Color.LAVENDERBLUSH, CornerRadii.EMPTY, Insets.EMPTY)));
		Scene connectingScene = new Scene(connectingbox, 700, 700);
		

		ListView<String> log = new ListView<String>();
		Button help2 = new Button("Help");
		TextField title = new TextField("Server Log");
		TextField currentServer = new TextField();
		TextField currentTitle = new TextField("current server");
		Button newServerbtn = new Button("host new server");
		//HBox serverTop = new HBox(title);
		HBox serverBottom = new HBox(currentTitle, currentServer, newServerbtn);
		BorderPane serverLog = new BorderPane();
		serverLog.setCenter(log);
		serverLog.setTop(title);
		serverLog.setBottom(serverBottom);
		serverLog.setRight(help2);
		serverLog.setBackground(new Background(new BackgroundFill(
				Color.MIDNIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		Scene logScene = new Scene(serverLog, 700, 700);


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
