package com.kodilla.battleship;

public class Ship {

    private int shipLength;
    private boolean vertical = true;
    private int health;

    public Ship(int shipLength) {
        this.shipLength = shipLength;
        this.health = shipLength;
    }

    public int getShipLength() {
        return shipLength;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
