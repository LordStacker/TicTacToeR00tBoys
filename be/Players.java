package tictactoe.be;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tictactoe.be.Player;

public class Players {
    private final ObservableList<Player> playersList;

    public Players() {
        this.playersList = FXCollections.observableArrayList();
    }

    public ObservableList<Player> getPlayerList() {
        return playersList;
    }
}
