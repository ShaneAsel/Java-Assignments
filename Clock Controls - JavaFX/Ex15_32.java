package ex15_32;
//Author: Shane Asel

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Ex15_32 extends Application {
    //Override start method in App class
    @Override 
    public void start(Stage primaryStage) {
        //Create clock pane
        Clock clock = new Clock();

        //Create hBox and set it porperties
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);

        //Create two buttons
        Button btStop = new Button("Stop");
        Button btStart = new Button("Begin");

        //Define key functions
        btStop.setOnAction(e -> clock.pause());
        btStart.setOnAction(e -> clock.play());

        //Place buttons in hBox
        hBox.getChildren().addAll(btStop, btStart);

        //Create border pane and place nodes in it
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(clock);
        borderPane.setBottom(hBox);

        //Create scene and place it stage
        Scene scene = new Scene(borderPane, 450, 470);
        //Set stage title
        primaryStage.setTitle("TICK TOCK - Shane's Java Clock - TICK TOCK"); 
        //Place scene in stage
        primaryStage.setScene(scene); 
        //Display stage
        primaryStage.show(); 
    }
}
