package tictactoe.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import tictactoe.be.Player;
import tictactoe.bll.Utilities;

import java.net.URL;
import java.util.ResourceBundle;

public class InputWindowController implements Initializable {
    @FXML
    private Button rulesAction,
            creatorsAction,
            start_game;
    @FXML
    private TextField player_one_name,
            player_two_name;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start_game.setOnAction(event ->
                Utilities.changeScene(event, "../gui/views/TicTacView.fxml", new Player(player_one_name.getText(), null), new Player(player_two_name.getText(), null), true));
        creatorsAction.setOnAction(event ->
                Utilities.changeScene(event, "../gui/views/CreatorsView.fxml", null, null, false));
        rulesAction.setOnAction(event ->
                Utilities.changeScene(event, "../gui/views/RulesView.fxml", null, null, false));
    }
}
