package tictactoe.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import tictactoe.bll.GameState;
import tictactoe.bll.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class BaseWindowController implements Initializable {
    @FXML
    private Button playerVComputer;
    @FXML
    private Button scoreBoardAction;
    @FXML
    private Button rulesAction;
    @FXML
    private Button creatorsAction;
    @FXML
    private Button playerVPlayer;

    // MULTIPLAYER / PLAYER VS AI

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerVPlayer.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/InputView.fxml",null,null,true, GameState.NOT_PLAYING));
        playerVComputer.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/InputView.fxml",null,null,true, GameState.NOT_PLAYING));

        creatorsAction.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/CreatorsView.fxml",null,null,false,GameState.NOT_PLAYING));
        rulesAction.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/RulesView.fxml",null,null,false,GameState.NOT_PLAYING));
    }
}
