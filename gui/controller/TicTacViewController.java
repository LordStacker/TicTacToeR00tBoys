/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import tictactoe.bll.*;
import tictactoe.bll.Utils;

/**
 * @author r00tBoys
 */
public class TicTacViewController implements Initializable {
    @FXML
    private Label Xscore,
            Oscore,
            turnLabel,
            lblPlayer,
            lblPlayer2;

    @FXML
    private Button baseWindowAction;

    @FXML
    private GridPane gridPane;
    private static final String TURN_LABEL = "It's: ";

    private IGameModel game;

    private GameState gameState = GameState.COMPUTER_AI;


    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;

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
                    setPlayer();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void handleNewGame(ActionEvent event) {
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
                Utils.changeScene(event, "../gui/views/BaseView.fxml", null, null, true,GameState.NOT_PLAYING));
    }

    private void setPlayer() {
        String xOrO = game.getPlayer() == 0 ? "X" : "O";
        turnLabel.setText(TURN_LABEL + xOrO + " turn ");
    }

    private void displayWinner(int winner) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
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
        if (GameBoard.counterX == GameBoard.MAX_SCORE || GameBoard.counterY == GameBoard.MAX_SCORE) {
            alert.setContentText(message);
            alert.show();
        }
        if (winner == -1) {
            alert.setContentText(message);
            alert.show();
        }

    }

    private void clearBoard() {
        for (Node n : gridPane.getChildren()) {
            Button btn = (Button) n;
            btn.setText("");
        }
    }

    public void setNames(String playerOne, String playerTwo) {
        lblPlayer.setText(playerOne + " (X) ");
        lblPlayer2.setText(playerTwo + " (O) ");
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
