package com.kodilla.battleship;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Board {

    private static final int NUM_ROWS = 10;
    private static final int NUM_COLUMNS = 10;
    private int[][] board = new int[NUM_ROWS][NUM_COLUMNS];
    private final Button[][] buttons = new Button[NUM_ROWS][NUM_COLUMNS];
    private final GridPane grid = new GridPane();

    public Board() {
        addButtons(grid);
    }

    public boolean colocateShips(Ship ship, int[] xy) {
        int x = xy[0];
        int y = xy[1];
        System.out.println(canPlaceShip(ship, x, y));
        if (canPlaceShip(ship, x, y)) {
            for (int i = 0; i < ship.getShipLength(); i++) {
                if (ship.isVertical()) {
                    board[x][y + i] = 1;
                    buttons[x][y + i].setStyle("-fx-background-color: green");
                } else {
                    board[x + i][y] = 1;
                    buttons[x + i][y].setStyle("-fx-background-color: green");
                }
            }
            return true;
        }
        return false;
    }

    public boolean canPlaceShip(Ship ship, int x, int y) {
        if ((y >= 0 && y < NUM_ROWS) && (x >= 0 && x < NUM_COLUMNS)) {
            if (ship.isVertical()) {
                if (y + ship.getShipLength() < NUM_ROWS) {
                    for (int i = 0; i < ship.getShipLength(); i++) {
                        if (board[x][y + i] != 0) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            if (!ship.isVertical()) {
                if (x + ship.getShipLength() < NUM_COLUMNS) {
                    for (int i = 0; i < ship.getShipLength(); i++) {
                        if (board[x + i][y] != 0) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void addButtons(GridPane grid) {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLUMNS; j++) {
                Button button = new Button();
                button.setOnAction(event -> handleClickRed(button));
                grid.add(button, i, j);
                this.buttons[i][j] = button;
                this.buttons[i][j].setPrefSize(25, 25);
            }
        }
    }

    public Button[][] getButtons() {
        return buttons;
    }

    public GridPane getGrid() {
        return grid;
    }

    private void handleClickRed(Button button) {
        button.setStyle("-fx-background-color: red");
    }
}