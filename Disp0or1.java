//Author: Shane Asel
package disp0or1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;

public class Disp0or1 extends Application {
    //Override start method in the App class
    @Override 
    public void start(Stage primaryStage) {
        //Create GridPane and set its parameters 
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setHgap(5);
        pane.setVgap(5);

        //Set text fields containing a randomly generated string of either 0 or 1 in the pane
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                TextField text = new TextField();
                text.setPrefColumnCount(1);
                text.setText(String.valueOf((int)(Math.random() * 2)));
                pane.add(text, i, j);
                pane.setHalignment(text, HPos.CENTER);
                pane.setValignment(text, VPos.CENTER);
            }
        }

    //Create scene and put it in the stage
    Scene scene = new Scene(pane);  
    //Set stage title
    primaryStage.setTitle("Shane's Random 0 or 1 Generator");
    //Place scene in stage 
    primaryStage.setScene(scene);
    //Display stage 
    primaryStage.show(); 
    }
}