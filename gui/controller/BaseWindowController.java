package tictactoe.gui.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

public class BaseWindowController implements Initializable {

    @FXML
    private Button test;
    @FXML
    private BorderPane pane;
    @FXML
    private Button playerVPlayer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerVPlayer.setOnAction(event -> openSecondWindow(event,"test"));
    }



    private void openSecondWindow(ActionEvent event,String name){
        Parent root = null;

        if(name != null){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/InputView.fxml"));
                root = loader.load();
            }catch(IOException e){
                e.printStackTrace();
                // Custom err handeling model
            }
        } else {
            try{
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../views/InputView.fxml")));
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
