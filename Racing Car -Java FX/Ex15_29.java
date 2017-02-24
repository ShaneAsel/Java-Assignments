//Author: Shane Asel

package ex15_29;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class Ex15_29 extends Application {
    //Override start method on App class
    @Override 
	public void start(Stage primaryStage) {
            //Create car
            CarPane pane = new CarPane();

            //Define key functions
            pane.setOnMousePressed(e -> pane.pause());
            pane.setOnMouseReleased(e -> pane.play());
            pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
		pane.increaseSpeed();
            }
            else if (e.getCode() == KeyCode.DOWN) {
		pane.decreaseSpeed();
            }
            });

            //Create scene and place in stage
            Scene scene = new Scene(pane, 600, 100);
            //Set stage title
            primaryStage.setTitle("VROOM! VROOM! Shane's totally awesome Ferrari! VROOM! VROOM!"); 
            //Place scene in stage
            primaryStage.setScene(scene); 
            //Display stage
            primaryStage.show();
            //Request focus 
            pane.requestFocus(); 
	}
}
