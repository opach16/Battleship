package com.kodilla.battleship.players;

import com.kodilla.battleship.Board;
import com.kodilla.battleship.Ship;

import java.util.List;
import java.util.Objects;

public abstract class Player {

    private final String name;
    private int points;
    private Board board = new Board();
    private List<Ship> ships = List.of(
            new Ship(5),
            new Ship(4),
            new Ship(3),
            new Ship(3),
            new Ship(2)
    );

    public Player(String name) {
        this.name = name;
    }

    public abstract int[] placeShip();

    public abstract boolean shoot(Player player);

    public String getName() {
        return name;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
