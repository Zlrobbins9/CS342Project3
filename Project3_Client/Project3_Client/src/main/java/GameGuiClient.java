
import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameGuiClient extends Application  {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Welcome to JavaFX");
        Button help = new Button("Help");
        Button startButton = new Button("Host Server");
        TextArea textfield1 = new TextArea("Enter a server number of your liking to begin hosting!");
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
        textfield1.setMaxHeight(75);
        textfield1.setMaxWidth(200);

        Scene connectingScene = new Scene(connectingbox, 700, 700);


        Scene scene = new Scene(new VBox(), 700,700);
        primaryStage.setScene(connectingScene);
        primaryStage.show();
    }
}