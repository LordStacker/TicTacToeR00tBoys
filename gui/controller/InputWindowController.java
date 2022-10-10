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

import java.io.IOException;
import java.net.URL;
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
        start_game.setOnAction(this::openSecondWindow);
    }

    private void openSecondWindow(ActionEvent event){
        Parent root = null;

        if(!player_one_name.getText().isEmpty() || !player_two_name.getText().isEmpty()){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/TicTacView.fxml"));
                root = loader.load();
                TicTacViewController tc = loader.getController();
                tc.setNames(player_one_name.getText(),player_two_name.getText());
            }catch(IOException e){
                e.printStackTrace();
                // Custom err handeling model
            }
        } else {
            try{
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../views/TicTacView.fxml")));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Welcome to Tic Tac Toe");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

}
