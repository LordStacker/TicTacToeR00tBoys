package tictactoe.gui.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tictactoe.be.DataStore;
import tictactoe.be.Player;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoreWindowController implements Initializable {

    @FXML
    private Button exitScoreAction;
    @FXML
    private TableColumn<Player,String> resultName;
    @FXML
    private TableColumn<Player,Integer> resultScore;
    @FXML
    private TableView<Player> resultTable;

    private final DataStore currPlayer = DataStore.getInstance();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Player> test = currPlayer.getPersonList();
        if(test.size() != 0) {
            for (int i = 0; i < test.size(); i++) {
                resultName.setCellValueFactory(new PropertyValueFactory<>("name"));
                resultScore.setCellValueFactory(new PropertyValueFactory<>("score"));
            }
            resultTable.setItems(test);
        }
        exitScoreAction.setOnAction(this::setExitRulesAction);
    }

    private void setExitRulesAction(ActionEvent actionEvent) {
        Stage stage = (Stage) exitScoreAction.getScene().getWindow();
        stage.close();
    }
}
