/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import tictactoe.be.DataStore;
import tictactoe.be.Player;
import tictactoe.bll.*;

/**
 * @author r00tBoys
 */
public class TicTacViewController implements Initializable {
    @FXML
    private BorderPane borderPaneId;
    @FXML
    private Label Xscore,
            Oscore,
            turnLabel,
            lblPlayer,
            lblPlayer2;

    @FXML
    private Button baseWindowAction,
            btnNewGame;

    @FXML
    private GridPane gridPane;

    private static final String TURN_LABEL = "It's: ";
    private IGameModel game;

    private String score,
            playerName;

    private GameState gameState = GameState.COMPUTER_AI;

    private final DataStore currPlayer = DataStore.getInstance();

    private Player p1,
            p2;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;

            if(this.gameState.equals(GameState.PLAYER_VS_PLAYER)){
                if (game.play(c, r)) {
                    if (game.isGameOver()) {
                        int winner = game.getWinner();
                        game.resetBoard();
                        clearBoard();
                        Xscore.setText(game.getWonGamesByX());
                        Oscore.setText(game.getWonGamesByO());
                        displayWinner(winner);
                    } else {
                        int player = game.getNextPlayer();
                        Button btn = (Button) event.getSource();
                        String xOrO = player == 1 ? "X" : "O";
                        btn.setText(xOrO);
                        if(xOrO.equals("X")){
                            btn.setStyle("-fx-text-fill: red");
                        }else {
                            btn.setStyle("-fx-text-fill: blue");
                        }
                        setPlayer();
                    }
                }
            } else {
                if (game.play(c, r)) {
                    if (game.isGameOver()) {
                        int winner = game.getWinner();
                        game.resetBoard();
                        clearBoard();
                        Xscore.setText(game.getWonGamesByX());
                        Oscore.setText(game.getWonGamesByO());
                        displayWinner(winner);
                    } else {
                        List<Button> fetchedButtons = getListOfButtons(); // pulling list of all buttons on the field
                        Button btn = (Button) event.getSource();
                        String xOrO  = "X";
                        btn.setText(xOrO);
                        Button nextButton =  fetchedButtons.get(game.aiComputer());
                        nextButton.setText("O");
                        nextButton.setStyle("-fx-text-fill: red");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void handleNewGame() {
        game.newGame();
        Xscore.setText(game.getWonGamesByX());
        Oscore.setText(game.getWonGamesByO());
        setPlayer();
        clearBoard();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(gameState.equals(GameState.PLAYER_VS_PLAYER)) {
            game = new GameBoard(this);
        } else {
            game = new GameBoardComputer(this);
        }
        setPlayer();
        game.resetBoard();
        baseWindowAction.setOnAction(event ->
                Utilities.changeScene(event, "../gui/views/BaseView.fxml", null, null, true,GameState.NOT_PLAYING));
        btnNewGame.setOnAction(event -> handleNewGame());
    }

    private List<Button> getListOfButtons(){
        List<Button> buttonList = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            Node nodeOut = borderPaneId.getChildren().get(i);
            if (nodeOut instanceof GridPane) {
                for(Node button : ((GridPane) nodeOut).getChildren()){
                    if(button instanceof Button){
                        buttonList.add((Button) button);
                    }
                }
            }
        }
        return buttonList;
    }

    private void setPlayer() {
        String xOrO = game.getPlayer() == 0 ? "X" : "O";
        turnLabel.setText(TURN_LABEL + xOrO + " turn ");
    }

    private void displayWinner(int winner) {
        String message = "";
        if (winner == 1) {
            GameBoard.counterX++;
        }
        if (winner == 0) {
            GameBoard.counterY++;
        }
        if (winner == -1) {
            message = "It's a draw :-(";
        } else {
            message = winner == 1 ? lblPlayer.getText() + " wins!!!" : lblPlayer2.getText() + " wins!!!";
        }
        if (GameBoard.counterX == GameBoard.MAX_SCORE  || GameBoard.counterY == GameBoard.MAX_SCORE) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(message);
            Optional<ButtonType> option = alert.showAndWait();
            if(ButtonType.OK.equals(option.get())){
                sendScoreToTheBoard();
                handleNewGame();
            }
        }
        turnLabel.setText(message);
    }

    private void clearBoard() {
        for (Node n : gridPane.getChildren()) {
            Button btn = (Button) n;
            btn.setText("");
        }
    }

    private void sendScoreToTheBoard() {
        score = Xscore.getText() + " - " + Oscore.getText();
        playerName = lblPlayer.getText() + " - " + lblPlayer2.getText();

        Player p = new Player(playerName, score);
        currPlayer.setPersonList(p);
        GameBoard.counterY = 0;
        GameBoard.counterX = 0;
    }
    public void setNames(String playerOne, String playerTwo) {
        lblPlayer.setText(playerOne + " (X) ");
        lblPlayer2.setText(playerTwo + " (O) ");
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
