package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TheRealMainClass extends Application {

    static int choice;

    public static void main(String[] args) {
        Application.launch(TheRealMainClass.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        var promptLabel = new Label("Choose An Option:");
        var inputChoice = new TextField();
        var enterChoiceButton = new Button("Submit");
        var feedBack = new Label();

        var layout = new VBox(10,promptLabel,inputChoice,enterChoiceButton,feedBack);

        var scene = new Scene(layout, 400, 400);
        stage.setTitle("TEXT PROCESSING TOOL");
        stage.setScene(scene);
        stage.show();

        enterChoiceButton.setOnAction(e->{
            try{
                choice = Integer.parseInt(inputChoice.getText());
                feedBack.setText("You entered: " + choice);
            } catch(Exception ex){
                choice = -1;
                feedBack.setText("Invalid Input!");
            }


        });
    }
}
