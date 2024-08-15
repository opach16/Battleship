package com.kodilla.battleship;

import com.kodilla.battleship.players.Computer;
import com.kodilla.battleship.players.Human;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private final Image image = new Image("image.png");

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sample.fxml"));
        BackgroundSize backgroundSize = new BackgroundSize(300, 600, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        Game game = new Game(new Human("Konrad"), new Computer("Computer"));

        Board playerBoard = game.getPlayer1().getBoard();
        Board opponentBoard = game.getPlayer2().getBoard();

        game.play();

        GridPane grid = opponentBoard.getGrid();
        grid.setAlignment(Pos.CENTER);

        GridPane grid1 = playerBoard.getGrid();
        grid.setAlignment(Pos.CENTER);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setBackground(background);
        AnchorPane.setTopAnchor(grid, 25.0);
        AnchorPane.setLeftAnchor(grid, 25.0);
        AnchorPane.setTopAnchor(grid1, 325.0);
        AnchorPane.setLeftAnchor(grid1, 25.0);
        anchorPane.getChildren().addAll(grid, grid1);

        Scene scene = new Scene(anchorPane, 300, 600, Color.BLACK);
        stage.setTitle("Battleship");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}