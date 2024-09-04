package game;

/**
 * Summary:
 * Represents a game of Four in a Row, extending the Game class.
 *
 * Constructor:
 * FourInARow - Constructs a Four in a Row game with two players.
 *
 * Methods:
 * doesWin - Determines if a move results in a win for Four in a Row.
 * onePlay - Allows a player to make one move in the game.
 * isColumnFull - Checks if a specified column is full.
 */
public class FourInARow extends Game {
	
	  /**
     * Summary:
     * Constructs a Four in a Row game with the specified player names.
     *
     * Arguments:
     * @param player1 - (String type): The name of the first player.
     * @param player2 - (String type): The name of the second player.
     */
	public FourInARow(String player1, String player2) {
		super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
		
	}
	
	/**
     * Summary:
     * Determines if placing a piece at the specified position results in a win.
     *
     * Arguments:
     * @param i - (int type): The row index.
     * @param j - (int type): The column index.
     *
     * Returns:
     * @return - (boolean type): True if the move results in a win, false otherwise.
     */
	@Override
	protected boolean doesWin(int i, int j) {
		if (super.maxLineContaining(i, j) == 4) {
			return true;
		}
		else {
			return false;
		}
	}
	
	  /**
     * Summary:
     * Allows a player to make one move in the game.
     *
     * Arguments:
     * @param p - (Player type): The player making the move.
     *
     * Returns:
     * @return - (boolean type): True if the move results in a win, false otherwise.
     */
	@Override
	protected boolean onePlay(Player p) {
		int columnByUser = 0;
		int moveNumOfRowsDown = 0;
		
		System.out.println(p.toString() + ", please enter column: ");
		while (s.hasNext()) {
			columnByUser = s.nextInt();
			if (columnByUser < 0 || columnByUser >= 7) {
				System.out.println("Please enter a vaild column between [0,6].");
				continue;
			}
			else if(isColumnFull(columnByUser)) {
				System.out.println("The column is full already try another column between [0,6]");
				continue;
			}
			else {
				for (moveNumOfRowsDown = 5; moveNumOfRowsDown >= 0;moveNumOfRowsDown--) {
					if (super.isEmpty(moveNumOfRowsDown,columnByUser)) {
						super.set(moveNumOfRowsDown, columnByUser, p);
						break;
					}
				}
				break;
			}
		}
		System.out.println(toString());
		return (doesWin(moveNumOfRowsDown,columnByUser));
	}
	
    /**
     * Summary:
     * Checks if a specified column is full.
     *
     * Arguments:
     * @param column - (int type): The column index.
     *
     * Returns:
     * @return - (boolean type): True if the column is full, false otherwise.
     */
	private boolean isColumnFull(int column){
		if (board[0][column] != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
