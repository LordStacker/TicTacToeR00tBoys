/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import tictactoe.gui.controller.TicTacViewController;

/**
 * @author Stegger
 */
public class GameBoardComputer implements IGameModel {
    private int player = 0;

    private char[][] board =new char[3][3];
    private int roundCount=0;
    private char token=' ';

    private int wonGamesByX=0;
    private int wonGamesByO=0;

    public final static int MAX_SCORE = 5;

    public static int counterX = 0;
    public static int counterY = 0;

    private TicTacViewController controller;
    public GameBoardComputer(TicTacViewController controller){
//        for (int r = 0; r < this.board.length; r++) {
//            for (int c = 0; c < this.board.length; c++) {
//                this.board[r][c]=0;
//            }
//        }
        this.controller = controller;
    }

    public GameBoardComputer() {}
    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer() {
        if (player == 1) {
            player = 0;
        } else {
            player = 1;
        }
        return player;
    }

    public int getPlayer(){
         return this.player;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row) {
        //Marking current field if it is empty
        if (this.board[col][row]==' ') {
            this.board[col][row]=this.player == 0 ? 'X' : 'O';
            this.roundCount++;
            printBoard(this.board);
            return true;
        }

      //  printBoard(this.board);

        return false;
    }

    private void printBoard(char[][] board) {

        for (char[] row : board){
            for (char column : row){
                System.out.println(column);
            }
            System.out.println();
        }
    }

    public boolean isGameOver() {

        //Check if there is winning row
        if (checkWinningRows(3)!=' '){
            this.token=checkWinningRows(3);
            this.roundCount=0;
            return true;

        }

        //Check if there is winning collum
        if (checkWinningColls(3)!=' '){
            this.token=checkWinningColls(3);
            this.roundCount=0;
            return true;
        }

        //Check if there is winning diagonal
        if (checkWinningDiagonals()!=' '){
            this.token=checkWinningDiagonals();
            this.roundCount=0;
            return true;
        }


        //Check if there is no free fields
        if (this.roundCount==9){
            this.roundCount=0;
            return true;
        }
        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner() {
        if (this.token=='X'){
            this.wonGamesByX++;
            return 1;
        } if(this.token=='O') {
            this.wonGamesByO++;
            return 0;
        }
        else {
            return -1;
        }
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame() {
        resetBoard();
        player = 0;
        roundCount = 0;
        wonGamesByX = 0;
        wonGamesByO = 0;
        counterX = 0;
        counterY = 0;

    }

    //Cleans current matrix
    public void resetBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j]=' ';
            }

        }
    }

    private char checkWinningRows(int row){
        for (int i = 0; i < row; i++) {
            if (this.board[i][0] == this.board[i][1]
                    && this.board[i][0] == this.board[i][2]
                    &&this.board[i][0] !=' '){

                return this.board[i][0];
            }

        }
        return ' ';
    }

    private char checkWinningColls(int coll){
        for (int i = 0; i < coll; i++) {
            if (this.board[0][i] == this.board[1][i]
                    && this.board[0][i] == this.board[2][i]
                    &&this.board[0][i] !=' '){
                return this.board[0][i];
            }

        }
        return ' ';
    }

    private char checkWinningDiagonals(){
        if (this.board[0][0] == this.board[1][1]
                && this.board[0][0] == this.board[2][2]
                && this.board[0][0]!=' '){
            return this.board[0][0];
        }else if(this.board[0][2] == this.board[1][1]
                &&this.board[0][2] == this.board[2][0]
                &&this.board[0][2] != ' '){
            return this.board[0][2];
        }

        return ' ';
    }


    public String  getWonGamesByX(){
        String pivot=""+ this.wonGamesByX;
        return pivot;
    }

    public String  getWonGamesByO(){
        String pivot=""+ this.wonGamesByO;
        return pivot;
    }
}
