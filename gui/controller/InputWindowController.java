package tictactoe.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import tictactoe.bll.GameState;
import tictactoe.bll.Utils;
import java.net.URL;
import java.util.ResourceBundle;

public class InputWindowController implements Initializable {

    @FXML
    private Button rulesAction;
    @FXML
    private Button creatorsAction;
    @FXML
    private TextField player_one_name;
    @FXML
    private TextField player_two_name;
    @FXML
    private Button start_game;

    private GameState state = GameState.COMPUTER_AI; // get rid off

    BaseWindowController baseController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        baseController = new BaseWindowController();

        checkGameState();
        start_game.setOnAction(event ->
                    Utils.changeScene(event,"../gui/views/TicTacView.fxml",player_one_name.getText(),player_two_name.getText(),true, state));
//        start_game.setOnAction(event ->
//                    Utils.changeScene(event,"../gui/views/TicTacViewDynamicTest.fxml",player_one_name.getText(),null,true, GameState.COMPUTER_AI));
        creatorsAction.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/CreatorsView.fxml",null,null,false,GameState.NOT_PLAYING));
        rulesAction.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/RulesView.fxml",null,null,false,GameState.NOT_PLAYING));
    }

    private void checkGameState(){
        if(state.equals(GameState.COMPUTER_AI)){
            player_two_name.setDisable(true);
        }
    }

    public void setBaseController(BaseWindowController controller){
        this.baseController = controller;
    }
}
