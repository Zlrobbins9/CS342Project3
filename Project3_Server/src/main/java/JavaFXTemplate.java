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

// This is the JavaFXTemplate for the SERVER!

public class JavaFXTemplate extends Application {

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
		TextArea textfield1 = new TextArea("Search a server number to begin!");
		TextField address = new TextField();
		address.setPromptText("*Enter address here*");
		HBox hbox = new HBox(help, textfield1);
		textfield1.setTranslateY(200);
		hbox.setSpacing(250.0);
		BorderPane connectingbox = new BorderPane();
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

		Scene connectingScene = new Scene(connectingbox, 700, 700);
		
				
		Scene scene = new Scene(new VBox(), 700,700);
		primaryStage.setScene(connectingScene);
		primaryStage.show();
		
		startButton.setOnAction(press2->
		{
			Boolean isPortValid = true;
			try {
		        int newIP = Integer.parseInt(textfield1.getText());
		    } catch (NumberFormatException nfe) {
		        isPortValid = false;
		    }
				GameServer newServer = new GameServer(data->{
					Platform.runLater(()->{});
					
					
					primaryStage.setTitle("This is the Server");
serverConnection = new Server(data -> {
Platform.runLater(()->{
listItems.getItems().add(data.toString());
});

});
					
});
				});
		});
	}

}
