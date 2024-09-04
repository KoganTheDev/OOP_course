package game;

/**
 * Summary:
 * Represents a game of Tic Tac Toe that extends the Game class.
 *
 * Constructor:
 * TicTacToe - Constructs a TicTacToe game with two players.
 *
 * Methods:
 * doesWin - Determines if a move results in a win for Tic Tac Toe.
 */
public class TicTacToe extends Game {

	public TicTacToe(String player1, String player2) {
		super(3, 3, new Player(player1, 'X'), new Player(player2, 'O'));
	}
	
	  /**
     * Summary:
     * Determines if placing a piece at the specified position results in a win.
     *
     * Arguments:
     * @param row - (int type): The row index.
     * @param col - (int type): The column index.
     *
     * Returns:
     * @return - (boolean type): True if the move results in a win, false otherwise.
     */
	@Override
	protected boolean doesWin(int row, int col) {
		if (super.maxLineContaining(row, col) == 3) {
			return true;
		}
		else {
			return false;
		}
	}
}
