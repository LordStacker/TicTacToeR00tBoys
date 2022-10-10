package tictactoe.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BaseWindowController implements Initializable {

    @FXML
    private Button playerVPlayer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        playerVPlayer.setOnAction(this::openInputWindow);

       // playerVPlayer.setOnAction();
    }

    private void openInputWindow(ActionEvent event) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/InputView.fxml"));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Input players");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}
