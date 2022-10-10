package tictactoe.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tictactoe.bll.Players;
import tictactoe.bll.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class InputWindowController implements Initializable {

    @FXML
    private TextField player_one_name;
    @FXML
    private TextField player_two_name;
    @FXML
    private Button start_game;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start_game.setOnAction(event -> Utils.changeScene(event,"../gui/views/TicTacView.fxml",player_one_name.getText(),player_two_name.getText()));
    }

}
