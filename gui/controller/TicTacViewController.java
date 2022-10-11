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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import tictactoe.bll.*;

/**
 *
 * @author Stegger
 */
public class TicTacViewController implements Initializable
{
    @FXML
    private Label Xscore;

    @FXML
    private Label Oscore;
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


    private final DataStore currPlayer = DataStore.getInstance();

    private Player p1;
    private Player p2;


    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        try
        {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;
            if (game.play(c, r))
            {
                if (game.isGameOver())
                {
                    int winner = game.getWinner();
                    displayWinner(winner);
                    game.resetBoard();
                    clearBoard();
                    Xscore.setText(game.getWonGamesByX());
                    Oscore.setText(game.getWonGamesByO());
                }
                else
                {
                    int player = game.getNextPlayer();
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
        game.resetBoard();
        baseWindowAction.setOnAction(event ->
                Utilities.changeScene(event,"../gui/views/BaseView.fxml",null,null,true));
        btnNewGame.setOnAction(this::sendScoreToTheBoard);
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

    private void sendScoreToTheBoard(ActionEvent e){
        Player p = new Player(lblPlayer2.getText(),"3-5");
        currPlayer.setPersonList(p);
        Utilities.changeScene(e,"../gui/views/BaseView.fxml",null,null,true);
    }
    public void setPlayers(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;

        lblPlayer.setText(p1.getName() + " (X) ");
        lblPlayer2.setText(p2.getName() + " (O) ");
    }
}
