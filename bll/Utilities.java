package tictactoe.bll;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.gui.controller.TicTacViewController;
import java.io.IOException;

public class Utilities {
    //TODO: Custom exceptions
    public static void changeScene(ActionEvent event, String fxmlFile, Player p1,Player p2,boolean isGameplayAction) {
        Parent root = null;
        Stage stage = null;
        // TODO : we can still pass empty "" string :(
        if (p1 != null && p2 != null) {
            try {
                FXMLLoader loader = new FXMLLoader(Utilities.class.getResource(fxmlFile));
                root = loader.load();
                TicTacViewController pc = loader.getController();
                pc.setPlayers(p1,p2);
               // pc.setNames(p1.getName(), p2.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                root = FXMLLoader.load(Utilities.class.getResource(fxmlFile)); // leave this one when we return unfortunately null values
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(isGameplayAction){
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        }else {
            stage = new Stage();
        }
        stage.setTitle("Tic Tac Toe");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

}
