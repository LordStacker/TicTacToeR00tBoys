package tictactoe.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import tictactoe.bll.Utils;
import java.net.URL;
import java.util.ResourceBundle;

public class BaseWindowController implements Initializable {

    @FXML
    private Button playerVPlayer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerVPlayer.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/InputView.fxml",null,null));
    }

}
