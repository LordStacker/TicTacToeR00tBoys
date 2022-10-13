package tictactoe.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import tictactoe.bll.GameState;
import tictactoe.bll.Utilities;
import java.net.URL;
import java.util.ResourceBundle;

public class BaseWindowController implements Initializable {
    @FXML
    private Button playerVComputer,
            scoreBoardAction,
            rulesAction,
            creatorsAction,
            playerVPlayer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerVPlayer.setOnAction(event ->
                Utilities.changeScene(event,"../gui/views/InputView.fxml",null,null,true, GameState.NOT_PLAYING));
        playerVComputer.setOnAction(event ->
                Utilities.changeScene(event,"../gui/views/InputViewComputer.fxml",null,null,true, GameState.NOT_PLAYING));
               creatorsAction.setOnAction(event ->
                Utilities.changeScene(event,"../gui/views/CreatorsView.fxml",null,null,false,GameState.NOT_PLAYING));
        rulesAction.setOnAction(event ->
                Utilities.changeScene(event,"../gui/views/RulesView.fxml",null,null,false,GameState.NOT_PLAYING));
        scoreBoardAction.setOnAction(event ->
                Utilities.changeScene(event, "../gui/views/ScoreBoardView.fxml", null, null, false,GameState.NOT_PLAYING));
    }
}
