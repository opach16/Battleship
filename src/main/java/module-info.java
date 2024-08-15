module com.kodilla.battleship {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kodilla.battleship to javafx.fxml;
    exports com.kodilla.battleship;
    exports com.kodilla.battleship.players;
    opens com.kodilla.battleship.players to javafx.fxml;
}