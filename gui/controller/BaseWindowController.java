package tictactoe.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictactoe.bll.Player;

import tictactoe.bll.Utilities;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BaseWindowController implements Initializable {
    @FXML
    private Button scoreBoardAction;
    @FXML
    private Button rulesAction;
    @FXML
    private Button creatorsAction;
    @FXML
    private Button playerVPlayer;

    // TODO : Creators and rules fxml players ui are just templates needs to be done
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerVPlayer.setOnAction(event ->
                Utilities.changeScene(event,"../gui/views/InputView.fxml",null,null,true));
        creatorsAction.setOnAction(event ->
                Utilities.changeScene(event,"../gui/views/CreatorsView.fxml",null,null,false));
        rulesAction.setOnAction(event ->
                Utilities.changeScene(event,"../gui/views/RulesView.fxml",null,null,false));
        scoreBoardAction.setOnAction(event ->
                Utilities.changeScene(event,"../gui/views/ScoreBoardView.fxml",null,null,false));
    }
}
