package com.kodilla.battleship;

import com.kodilla.battleship.players.Player;

public class Game {

    private final Player player1;
    private final Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        player1.getBoard().colocateShips(player1.getShips().get(0), new int[]{1, 2});
        player1.getBoard().colocateShips(player1.getShips().get(1), new int[]{5, 0});
        player1.getBoard().colocateShips(player1.getShips().get(2), new int[]{3, 4});
        player1.getBoard().colocateShips(player1.getShips().get(3), new int[]{9, 5});
        player1.getBoard().colocateShips(player1.getShips().get(4), new int[]{7, 7});


        player2.getBoard().colocateShips(player2.getShips().get(0), new int[]{1, 2});
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
