/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import tictactoe.bll.GameBoard;
import tictactoe.bll.IGameModel;
import tictactoe.bll.Utils;

/**
 *
 * @author Stegger
 */
public class TicTacViewController implements Initializable
{
    @FXML
    private Button baseWindowAction;
    @FXML
    private Label turnLabel;
    @FXML
    private Label lblPlayer;
    @FXML
    private Label lblPlayer2;

    @FXML
    private Button btnNewGame;

    @FXML
    private GridPane gridPane;
    
    private static final String TURN_LABEL = "It's: ";
    private IGameModel game;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        try
        {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;
            int player = game.getNextPlayer();
            if (game.play(c, r))
            {
                if (game.isGameOver())
                {
                    int winner = game.getWinner();
                    displayWinner(winner);
                }
                else
                {
                    Button btn = (Button) event.getSource();
                    String xOrO = player == 1 ? "X" : "O";
                    btn.setText(xOrO);
                    setPlayer();
                }
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void handleNewGame(ActionEvent event)
    {
        game.newGame();
        setPlayer();
        clearBoard();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        game = new GameBoard();
        setPlayer();
        baseWindowAction.setOnAction(event ->
                Utils.changeScene(event,"../gui/views/BaseView.fxml",null,null));
    }

    private void setPlayer()
    {
        String xOrO = game.getPlayer()  == 0 ? "X" : "O";
        turnLabel.setText(TURN_LABEL + xOrO + " turn ");
    }

    private void displayWinner(int winner)
    {
        String message = "";
        switch (winner)
        {
            case -1:
                message = "It's a draw :-(";
                break;
            default:
                message = "Player " + winner + " wins!!!";
                break;
        }
        lblPlayer.setText(message);
    }

    private void clearBoard()
    {
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setText("");
        }
    }

    public void setNames(String playerOne,String playerTwo) {
        lblPlayer.setText(playerOne + " (X) ");
        lblPlayer2.setText(playerTwo + " (O) ");
    }
}
