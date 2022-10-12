package tictactoe.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class RulesWindowController implements Initializable {

    @FXML
    private Button exitRulesAction;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exitRulesAction.setOnAction(this::setExitRulesAction);
    }

    private void setExitRulesAction(ActionEvent actionEvent) {
        Stage stage = (Stage) exitRulesAction.getScene().getWindow();
        stage.close();
    }


}
