/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 *
 * @author Stegger
 */
public interface IGameModel
{

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer();

    /**
     * @return
     */

    public int getPlayer();
    /**
     * Attempts to let the current player play at the given coordinates. If the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver ==
     * true this method will always return false.
     */

    public boolean play(int col, int row);

    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will return false.
     */
    public boolean isGameOver();

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner();

    /**
     * Resets the game to a new game state.
     */
    public void newGame();

    /**
     * void
     * Clear all the tiles and Scores
     * Cleans the board
     */
    public void resetBoard();
    /*
     * String
     * Return games as string for player X
     */

    public String getWonGamesByX();
    /*
     * String
     * Return games as string for player O
     */

    public String getWonGamesByO();

    /*
     * int
     * Return int of button number from col and row
     */
    public int aiButtonNumber(int col, int row);

    /*
     * plays AI and returns random number
     */
    public int aiComputer();
}
