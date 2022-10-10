package tictactoe.bll;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Players {
    private final ObservableList<Player> playersList;

    public Players() {
        this.playersList = FXCollections.observableArrayList();
    }

    public ObservableList<Player> getPlayerList() {
        return playersList;
    }
}
