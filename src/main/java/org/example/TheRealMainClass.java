package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TheRealMainClass extends Application {

    public static void main(String[] args) {
        Application.launch(TheRealMainClass.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        var promptLabel = new Label("TEXT PROCESSING TOOL!");
        var inputField = new TextField();
        var addTextButton = new Button("ADD");
        var feedBack = new Label();

        var scene = new Scene(promptLabel, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
