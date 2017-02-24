//Author: Shane Asel
package ex16_6;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

public class EX16_6 extends Application {
    protected TextField tfTextField = new TextField();
    protected TextField tfColumnSize = new TextField();

    //Override start method in App class
    @Override 
    public void start(Stage primaryStage) {
        //Set parameters for text fields
        tfTextField.setText("Example");
        tfTextField.setAlignment(Pos.BOTTOM_CENTER);
        tfColumnSize.setAlignment(Pos.BOTTOM_RIGHT);
        tfColumnSize.setPrefColumnCount(3);
        tfTextField.setPrefColumnCount(12);
        tfColumnSize.setText("12");

        //Create three radio buttions
        RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbCenter = new RadioButton("Center");
        RadioButton rbRight = new RadioButton("Right");
        rbCenter.setSelected(true);

        //Create toggle group
        ToggleGroup group = new ToggleGroup();
        rbLeft.setToggleGroup(group);
        rbCenter.setToggleGroup(group);
        rbRight.setToggleGroup(group);

        //Create four hbox
        HBox paneForRadioButtons = new HBox(5);
        paneForRadioButtons.getChildren().addAll(rbLeft, rbCenter, rbRight);
        paneForRadioButtons.setAlignment(Pos.BOTTOM_LEFT);

        //Create column size
        HBox paneForColumnSize = new HBox(5);
        paneForColumnSize.getChildren().addAll(
            new Label("Column Size"), tfColumnSize);
        
        //Create label for text box
        HBox paneForTextField = new HBox(5);
        paneForTextField.setAlignment(Pos.CENTER);
        paneForTextField.getChildren().addAll(
            new Label("Enter Text Here:"), tfTextField);
       
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(paneForRadioButtons, paneForColumnSize);

        //Create a vBox and place nodes
        VBox pane = new VBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.getChildren().addAll(paneForTextField, hbox);

        //Create the handlers 
        rbLeft.setOnAction(e -> {
            if (rbLeft.isSelected()) {
                tfTextField.setAlignment(Pos.BOTTOM_LEFT);
            }
        });

        rbCenter.setOnAction(e -> {
            if (rbCenter.isSelected()) {
                tfTextField.setAlignment(Pos.BOTTOM_CENTER);
            }
        });

        rbRight.setOnAction(e -> {
            if (rbRight.isSelected()) {
                tfTextField.setAlignment(Pos.BOTTOM_RIGHT);
            }
        });

        tfColumnSize.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                tfTextField.setPrefColumnCount(Integer.parseInt(tfColumnSize.getText()));
            }
        });

        //Create scene and place in stage
        Scene scene = new Scene(pane);
        //Set stage title
        primaryStage.setTitle("Shane's Slick Text Box"); 
        //Place scene in stage
        primaryStage.setScene(scene); 
        //Display stage
        primaryStage.show(); 
    }
}