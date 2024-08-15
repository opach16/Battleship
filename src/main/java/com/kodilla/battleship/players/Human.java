package com.kodilla.battleship.players;

public class Human extends Player {

    public Human(String name) {
        super(name);
    }

    @Override
    public int[] placeShip() {
        return new int[]{1, 2};
    }

    @Override
    public boolean shoot(Player player) {
        return true;
    }
}
