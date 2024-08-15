package com.kodilla.battleship.players;

import java.util.Random;

public class Computer extends Player {

    private static final Random RANDOM = new Random();

    public Computer(String name) {
        super(name);
    }

    @Override
    public int[] placeShip() {
        return new int[]{RANDOM.nextInt(10), RANDOM.nextInt(10)};
    }

    @Override
    public boolean shoot(Player player) {
        return true;
    }
}
