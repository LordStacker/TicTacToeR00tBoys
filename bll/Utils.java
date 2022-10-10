package tictactoe.bll;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.gui.controller.TicTacViewController;

import java.io.IOException;
import java.util.Objects;

public class Utils {
    public static void changeScene(ActionEvent event, String fxmlFile, String playerOneName, String playerTwoName) {
        Parent root = null;

        if (!playerOneName.isEmpty() && !playerTwoName.isEmpty()) {
            try {
                FXMLLoader loader = new FXMLLoader(Utils.class.getResource(fxmlFile));
                root = loader.load();
                TicTacViewController pc = loader.getController();
                pc.setNames(playerOneName, playerTwoName);
            } catch (IOException e) {
                e.printStackTrace();
                // Custom err handeling model
            }
        } else {
            try {
                root = FXMLLoader.load(Objects.requireNonNull(Utils.class.getResource(fxmlFile)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tic Tac Toe");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }


}
