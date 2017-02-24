//Author: Shane Asel

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TttGame extends Application {
    //Override start method in App class
    @Override 
    public void start(Stage stage) {
        // Create pane
        GridPane pane = new GridPane();

   //Setting nodes to pane
    for (int i = 0; i < 3; i++) {
	for (int j = 0; j < 3; j++) {
            int n = (int)(Math.random() * 3);
            if (n == 0)
		pane.add(new ImageView(new Image("x.gif")), j, i);
            else if (n == 1)
		pane.add(new ImageView(new Image("o.gif")), j, i);
            else
            continue;
	}
    }

    //Create scene and place in the stage
    Scene scene = new Scene(pane, 120, 130);
    //Define title for stage
    stage.setTitle("Shane's Tic Tac Toe Game");
    //Set scene in the stage
    stage.setScene(scene);   
    //Display the stage
    stage.show();
    }
}