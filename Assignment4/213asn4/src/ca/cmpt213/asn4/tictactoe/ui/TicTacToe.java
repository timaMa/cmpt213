package ca.cmpt213.asn4.tictactoe.ui;

/**
 * This is the UI class
 * Show the interface to user
 * And use the gamelogic class create the game
 * then let user play
 */

import ca.cmpt213.asn4.tictactoe.game.GameLogic;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TicTacToe extends Application
{
    public static void main(String[] args) {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        GridPane root = new GridPane();
        root.setHgap(50);
        root.setVgap(50);
        root.setPadding(new Insets(15,15,15,15));
        Scene scene = new Scene(root, 1000, 1000);

        GameLogic game1 = new GameLogic(root);
        game1.insert();
        game1.gameStart();

        Button but = new Button("New Game");
        but.setPrefSize(100, 50);
        root.add(but,4, 1);
        but.setOnAction((event) -> {
            game1.listOfButton.clear();
            game1.root.getChildren().clear();
            game1.insert();
            game1.gameStart();

        });

        primaryStage.setTitle("TicTac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
