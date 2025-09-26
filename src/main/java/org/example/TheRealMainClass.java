package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class TheRealMainClass extends Application {

    static int choice;

    public static Set<String> textProcessingSet = new HashSet<String>();

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
            } catch(Exception ex){
                choice = -1;
            }

            switch (choice){
                case 1:
                    feedBack.setText("View A list of available Text");

                    break;
                case 2:
                    feedBack.setText("Add Text");
                    break;
                case 3:
                    feedBack.setText("Replace Text");
                    break;
                case 4:
                    feedBack.setText("Delete Text");
                    break;
                case 5:
                    feedBack.setText("Exit");
                    break;
                case 6:
                    feedBack.setText("Search Text");
                    break;
                default:
                    feedBack.setText("Invalid choice");
                    break;
            }

        });
    }
}
