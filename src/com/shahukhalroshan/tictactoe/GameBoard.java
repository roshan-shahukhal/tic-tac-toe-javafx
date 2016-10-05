package com.shahukhalroshan.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameBoard {
    
    private boolean alternateTurn = false;
    private Button[] buttons = new Button[9];
    private int counter = 0;
    private Stage stage;
    private Scene scene;
    
    public GameBoard(Stage stage) {
        
        createOrganizeAndAssignActionToButtons(buttons);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));

        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (counter > 8) {
                    break;
                }
                gridPane.add(buttons[counter], i, j);
                counter++;
            }
        }

        scene = new Scene(gridPane, 230, 230);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        this.stage = stage;
    }
    
    private void createOrganizeAndAssignActionToButtons(Button[] buttons) {
        
        for (int i = 0; i < 9; i++) {
            Button button = new Button();
            buttons[i] = button;
            button.setPrefWidth(80);
            button.setMaxWidth(80);
            button.setPrefHeight(80);
            button.setMaxHeight(80);
            changeTurn(button);
            
        }
    }

    public Button[] getButtons() {
        return buttons;
    }
    
    private void changeTurn(Button button) {
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                
                String winnerString = "";
                if (button.getText().isEmpty()) {
                    if (!alternateTurn) {
                        button.setText("X");
                        alternateTurn = true;
                    } else {
                        button.setText("O");
                        alternateTurn = false;
                    }
                    
                    winnerString = button.getText();
                    counter++;
                }
                
                // first column
                if(buttons[0].getText().equals(winnerString) && buttons[1].getText().equals(winnerString) && buttons[2].getText().equals(winnerString) ||
                        // second column
                        buttons[3].getText().equals(winnerString) && buttons[4].getText().equals(winnerString) && buttons[5].getText().equals(winnerString) ||
                        // third column
                        buttons[6].getText().equals(winnerString) && buttons[7].getText().equals(winnerString) && buttons[8].getText().equals(winnerString) ||
                     // first row
                        buttons[0].getText().equals(winnerString) && buttons[3].getText().equals(winnerString) && buttons[6].getText().equals(winnerString) ||
                     // second row
                        buttons[1].getText().equals(winnerString) && buttons[4].getText().equals(winnerString) && buttons[7].getText().equals(winnerString) ||
                     // third row
                        buttons[2].getText().equals(winnerString) && buttons[5].getText().equals(winnerString) && buttons[8].getText().equals(winnerString) ||
                     // first diagonal
                        buttons[0].getText().equals(winnerString) && buttons[4].getText().equals(winnerString) && buttons[8].getText().equals(winnerString) ||
                     // second diagonal
                        buttons[2].getText().equals(winnerString) && buttons[4].getText().equals(winnerString) && buttons[6].getText().equals(winnerString)) {
                    PopUp popup = new PopUp(stage);
                    popup.setMessage(winnerString + " wins");
                } else if (counter >= 9){
                    PopUp popup = new PopUp(stage);
                    popup.setMessage("Draw... ");
                }
            }
        });
    }
}
