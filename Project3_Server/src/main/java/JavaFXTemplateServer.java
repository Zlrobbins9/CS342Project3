import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
		Button help = new Button("Help");
		Button startButton = new Button("Connect");
		TextField address = new TextField();
		address.setPromptText("*address will appear here*");
		TextArea textfield1 = new TextArea();
		textfield1.setPromptText("Enter a server number of your liking to begin hosting!");
		BorderPane connectingbox = new BorderPane();
		connectingbox.setTop(textfield1);
		connectingbox.setLeft(startButton);
		connectingbox.setCenter(address);
		address.setMaxWidth(200);
		startButton.setTranslateY(400);
		startButton.setTranslateX(350);
		textfield1.setTranslateY(200);
		textfield1.setTranslateX(275);
		textfield1.setMaxHeight(50);
		textfield1.setMaxWidth(200);

		Scene connectingScene = new Scene(connectingbox, 700, 700);
		

		TextArea log = new TextArea();
		TextField title = new TextField("Server Log");
		TextField currentServer = new TextField();
		TextField currentTitle = new TextField("current server");
		Button newServerbtn = new Button("host new server");
		HBox serverTop = new HBox(title, help);
		HBox serverBottom = new HBox(currentTitle, currentServer, newServerbtn);
		BorderPane serverLog = new BorderPane();
		serverLog.setCenter(log);
		serverLog.setTop(serverTop);
		serverLog.setBottom(serverBottom);

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
					Platform.runLater(()->{});
				
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
