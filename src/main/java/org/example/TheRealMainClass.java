package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class TheRealMainClass extends Application {

    static int choice;

    public static Set<String> textProcessingSet = new HashSet<String>();

    // Layout declaration
    VBox layout = new VBox(10);

    // Text Field declaration
    private final TextField  inputChoice  = new TextField();
    private final TextField  enterText = new TextField();

    // Labels declaration
    public Label feedBack = new Label();
    public Label guideLabel = new Label("Choose an Option");

    // Button declaration
    public Button submitButton = new Button("Submit");
    public Button addButton = new Button("Add Text");
    public Button searchButton = new Button("Search");
    public Button replaceButton = new Button("Replace Text");
    public Button showMenuButton = new Button("Show Menu");


    // View declaration
    private final TableView<String> tableView = new TableView<>();
    private final ObservableList<String> textPhrases = FXCollections.observableArrayList();

    public static void main(String[] args) {
        Application.launch(TheRealMainClass.class, args);
    }

    public void displayMenu(){
        guideLabel.setText("Choose an Option");

        Label inputChoiceLabel = new Label("Input Choice");
        inputChoice.setPromptText("Enter your choice here");

        feedBack.setText("");

        layout.getChildren().addAll(guideLabel,inputChoiceLabel,inputChoice,submitButton,feedBack);

        submitButton.setOnAction(e -> {
            try{
                choice = Integer.parseInt(inputChoice.getText());
                feedBack.setText("check");
            } catch(Exception ex){
                choice = -1;
                feedBack.setText("Invalid choice");
            }
            inputChoice.clear();
            switchChoice(choice);
        });
    }

    public void switchChoice(int choice) {
        switch (choice){
            case 1:
                layout.getChildren().clear();

                if(textProcessingSet.isEmpty()){
                    guideLabel.setText("Nothing to Display");
                    layout.getChildren().addAll(guideLabel,showMenuButton);
                } else {

                    textPhrases.setAll(textProcessingSet);
                    layout.getChildren().addAll(tableView, showMenuButton);
                }

                showMenuButton.setOnAction(e1 -> {
                    layout.getChildren().clear();
                    displayMenu();
                });

                break;
            case 2:
                guideLabel.setText("Add A New Phrase");

                Label enterTextLabel = new Label("Enter Phrase");
                enterText.setPromptText("Enter phrase to add here");

                feedBack.setText("");

                layout.getChildren().clear();
                layout.getChildren().addAll(guideLabel, enterTextLabel, enterText,addButton, feedBack);

                addButton.setOnAction(e -> {
                    layout.getChildren().clear();
                    if (enterText.getText().trim().isEmpty()) {

                        feedBack.setText("Empty text phrases are not allowed!");
                        layout.getChildren().addAll(guideLabel, enterTextLabel, enterText,addButton, feedBack);
                        enterText.clear();

                    } else {

                        textProcessingSet.add(enterText.getText().trim());
                        textPhrases.setAll(textProcessingSet);

                        guideLabel.setText("Text added successfully!");
                        feedBack.setText("You have " + textProcessingSet.size() + " phrases available in the set!");
                        layout.getChildren().addAll(guideLabel,feedBack,showMenuButton);
                        enterText.clear();
                    }

                    showMenuButton.setOnAction(e1 -> {
                        layout.getChildren().clear();
                        displayMenu();
                    });

                });

                break;
            case 3:
                feedBack.setText("Replace Text");
                break;
            case 4:
                feedBack.setText("Delete Text");
                break;
            case 5:
                layout.getChildren().clear();
                if(textProcessingSet.isEmpty()){
                    guideLabel.setText("Nothing to Search!");
                    layout.getChildren().addAll(guideLabel,showMenuButton);
                } else {
                    guideLabel.setText("Search Here");
                    enterTextLabel = new Label("Enter Phrase To Search");
                    enterText.setPromptText("Enter phrase to search here");

                    feedBack.setText("");

                    layout.getChildren().clear();
                    layout.getChildren().addAll(guideLabel, enterTextLabel, enterText,searchButton, feedBack);

                    searchButton.setOnAction(e1 -> {
                                layout.getChildren().clear();
                                if (enterText.getText().trim().isEmpty()) {

                                    feedBack.setText("Empty search phrases are not allowed!");
                                    layout.getChildren().addAll(guideLabel, enterTextLabel, enterText,searchButton, feedBack);
                                    enterText.clear();

                                }
                    });
                }

                showMenuButton.setOnAction(e1 -> {
                    layout.getChildren().clear();
                    displayMenu();
                });
                break;
            default:
                feedBack.setText("Invalid choice");
                break;
        }

    }

    @Override
    public void start(Stage stage) throws Exception {
        tableView.setItems(textPhrases);

        TableColumn<String, String> textPhrasesColumn = new TableColumn<>("Text Phrases");

        textPhrasesColumn.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue()));

        tableView.getColumns().add(textPhrasesColumn);
        tableView.setItems(textPhrases);

        stage.setTitle("TEXT PROCESSING TOOL");

        layout.setPadding(new Insets(10, 20, 10, 20));

        displayMenu();

        final Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.show();


    }
}
