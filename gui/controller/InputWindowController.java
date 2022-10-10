package tictactoe.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import tictactoe.bll.Utils;
import java.net.URL;
import java.util.ResourceBundle;

public class InputWindowController implements Initializable {

    @FXML
    private Button rulesAction;
    @FXML
    private Button creatorsAction;
    @FXML
    private TextField player_one_name;
    @FXML
    private TextField player_two_name;
    @FXML
    private Button start_game;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start_game.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/TicTacView.fxml",player_one_name.getText(),player_two_name.getText(),true));
        creatorsAction.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/CreatorsView.fxml",null,null,false));
        rulesAction.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/RulesView.fxml",null,null,false));
    }
}
