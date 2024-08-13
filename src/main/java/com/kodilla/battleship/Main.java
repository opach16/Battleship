package com.kodilla.battleship;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static final int NUM_ROWS = 10;
    private static final int NUM_COLUMNS = 10;
    private static Button[][] playerButtons = new Button[NUM_ROWS][NUM_COLUMNS];
    private static Button[][] opponentButtons = new Button[NUM_ROWS][NUM_COLUMNS];
    private final Image image = new Image("image.png");

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sample.fxml"));
        BackgroundSize backgroundSize = new BackgroundSize(300, 600, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        addButtons(playerButtons, grid);

        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        addButtons(opponentButtons, grid1);

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
        stage.show();
    }

    public static Button[][] getPlayerButtons() {
        return playerButtons;
    }

    public static Button[][] getOpponentButtons() {
        return opponentButtons;
    }

    private void addButtons(Button[][] buttons, GridPane grid) {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLUMNS; j++) {
                Button button = new Button();
                grid.add(button, i, j);
                buttons[i][j] = button;
                buttons[i][j].setPrefSize(25, 25);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}