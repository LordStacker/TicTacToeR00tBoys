package tictactoe.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import tictactoe.bll.GameState;
import tictactoe.bll.Utils;
import java.net.URL;
import java.util.ResourceBundle;

public class InputComputerWindowController implements Initializable {

    @FXML
    private Button rulesAction;
    @FXML
    private Button creatorsAction;
    @FXML
    private TextField player_one_name;
    @FXML
    private Button start_game;

    private final GameState state = GameState.COMPUTER_AI;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start_game.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/TicTacView.fxml",player_one_name.getText(),null,true, state));
        creatorsAction.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/CreatorsView.fxml",null,null,false,GameState.NOT_PLAYING));
        rulesAction.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/RulesView.fxml",null,null,false,GameState.NOT_PLAYING));
    }
}
