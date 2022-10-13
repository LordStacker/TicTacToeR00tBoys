package tictactoe.bll;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.gui.controller.BaseWindowController;
import tictactoe.gui.controller.InputWindowController;
import tictactoe.gui.controller.TicTacViewController;

import java.io.IOException;

public class Utilities {
    // 1v1 = gameState = PLAYER_VS_PLAYER
    // 1vC = gameState = PLAYER_VS_COMPUTER
    public static void changeScene(ActionEvent event, String fxmlFile, String playerOneName, String playerTwoName, boolean isGameplayAction, GameState gameState) {
        Parent root = null;
        Stage stage = null;

        if (gameState.equals(GameState.COMPUTER_AI) || gameState.equals(GameState.PLAYER_VS_PLAYER)) {
            try {
                FXMLLoader loader = new FXMLLoader(Utilities.class.getResource(fxmlFile));
                root = loader.load();
                TicTacViewController pc = loader.getController();
                if (gameState.equals(GameState.COMPUTER_AI)) {
                    pc.setNames(playerOneName, "AI");
                } else {
                    pc.setNames(playerOneName, playerTwoName);
                }
                pc.setGameState(gameState); // does not work cuz controller instance fails ...
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                root = FXMLLoader.load(Utilities.class.getResource(fxmlFile));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (isGameplayAction) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        } else {
            stage = new Stage();
        }
        stage.setTitle("Tic Tac Toe");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

}
