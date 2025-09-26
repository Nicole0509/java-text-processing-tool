package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TheRealMainClass extends Application {

    static int choice;

    private final TextField  inputChoice  = new TextField();
    private TextField  enterText = new TextField();

    public Label feedback = new Label();
    public Label guideLabel = new Label("Choose an Option");

    private TableView<String> tableView = new TableView<>();
    private final ObservableList<String[]> data = FXCollections.observableArrayList();

    public static void main(String[] args) {
        Application.launch(TheRealMainClass.class, args);
    }

    public void switchChoice(int choice) {
        feedback.setText("switchoice says hi");
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button submitButton = new Button("Submit");
        Button createButton = new Button("Create");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");

        stage.setTitle("TEXT PROCESSING TOOL");

        Label inputChoiceLabel = new Label("Input Choice");
        inputChoice.setPromptText("Enter your choice here");

        VBox layout = new VBox(10,guideLabel,inputChoiceLabel,inputChoice,submitButton,feedback);
        layout.setPadding(new Insets(10, 10, 10, 10));

        final Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.show();

        submitButton.setOnAction(e -> {
            try{
                choice = Integer.parseInt(inputChoice.getText());
                feedback.setText("check");
            } catch(Exception ex){
                choice = -1;
                feedback.setText("Invalid choice");
            }

            switchChoice(choice);
        });
    }
}
