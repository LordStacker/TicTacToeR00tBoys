package tictactoe.bll;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.gui.controller.TicTacViewController;
import java.io.IOException;

public class Utils {
    //TODO: Custom exceptions
    public static void changeScene(ActionEvent event, String fxmlFile, String playerOneName, String playerTwoName) {
        Parent root = null;

        if (playerOneName != null && playerTwoName != null) {
            try {
                FXMLLoader loader = new FXMLLoader(Utils.class.getResource(fxmlFile));
                root = loader.load();
                TicTacViewController pc = loader.getController();
                pc.setNames(playerOneName, playerTwoName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                root = FXMLLoader.load(Utils.class.getResource(fxmlFile)); // leave this one when we return unfortunately null values
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tic Tac Toe");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }


}
