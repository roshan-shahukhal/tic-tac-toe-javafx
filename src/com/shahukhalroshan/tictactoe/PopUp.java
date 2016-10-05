package com.shahukhalroshan.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PopUp {
    
    private Label message;
    private Button quitButton;
    private Button continueButton;
    private Scene scene;
    
    private VBox layout;
    
    public PopUp(Stage stage) {
        message = new Label();
        message.setStyle("-fx-font-color:red");
        quitButton = new Button("Quit");
        continueButton = new Button("Continue Playing");
        
        layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        VBox.setMargin(message, new Insets(10));
        VBox.setMargin(quitButton, new Insets(10));
        VBox.setMargin(continueButton, new Insets(10));
        layout.getChildren().add(message);
        layout.getChildren().add(quitButton);
        layout.getChildren().add(continueButton);
        
        scene = new Scene(layout);
        
        stage.setScene(scene);
        
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent arg0) {
                stage.close();
            }
        });
        
        continueButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                new GameBoard(stage);
            }
        });
    }
    

    public void setMessage(String message) {
        this.message.setText(message);
    }
}
