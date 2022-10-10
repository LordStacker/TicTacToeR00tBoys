package tictactoe.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import tictactoe.bll.Player;
import tictactoe.bll.Players;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ScoreWindowController implements Initializable {

    @FXML

    private ListView<String> scoreList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // set the items to the board

    }

    public void setPlayers(List<Player> playersList) {
        // test data
        List<Player> newTest = new ArrayList<>();
        newTest.add(new Player("Tomas",30));
        newTest.add(new Player("Adam",30));
        System.out.println(playersList);
        for (Player p: newTest){
            scoreList.getItems().add(p.getName());
        }
    }
}
