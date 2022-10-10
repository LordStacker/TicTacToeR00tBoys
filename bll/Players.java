package tictactoe.bll;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Players {
    private  ObservableList<String> players;

    public Players() {
        this.players = FXCollections.observableArrayList();
    }

    public ObservableList<String> getPlayers() {
        return players;
    }

    public void setPlayers(ObservableList<String> players) {
        this.players = players;
    }
}
