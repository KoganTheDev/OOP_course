package game;

public class Board {
	protected Player[][] board;
	protected int n,m;
	
	/**
	 * Summary:
	 * Represents a game board with a grid of players and methods to manipulate the board.
	 *
	 * Fields:
	 * board - (Player[][] type): The grid representing the game board.
	 * n - (int type): The number of rows in the board.
	 * m - (int type): The number of columns in the board.
	 */
	public Board(int n, int m) {
		board = new Player[n][m];
		this.n = n;
		this.m = m;
	}
	
	/**
     * Summary:
     * Sets a player at the specified position if it is currently empty.
     *
     * Arguments:
     * @param i - (int type): The row index.
     * @param j - (int type): The column index.
     * @param p - (Player type): The player to place on the board.
     *
     * Returns:
     * @return - (boolean type): True if the player was set, false if the position was already taken.
     */
	protected boolean set(int i, int j, Player p) {
		if (board[i][j] == null) {
			board[i][j] = p;
			return true;
		}
		return false; // In case the board at row i column j is already taken.
	}
	
	/**
     * Summary:
     * Checks if the specified position on the board is empty.
     *
     * Arguments:
     * @param i - (int type): The row index.
     * @param j - (int type): The column index.
     *
     * Returns:
     * @return - (boolean type): True if the position is empty, false otherwise.
     */
	public boolean isEmpty(int i, int j) {
		if (board[i][j] == null) {
			return true;
		}
		return false; // In case the board at row i column j contains something
	}
	
    /**
     * Summary:
     * Gets the player at the specified position on the board.
     *
     * Arguments:
     * @param i - (int type): The row index.
     * @param j - (int type): The column index.
     *
     * Returns:
     * @return - (Player type): The player at the specified position, or null if the position is empty.
     */
	public Player get(int i, int j) {
		if (board[i][j] != null) {
			return (board[i][j]);
		}
		return null;
	}
	
	 /**
     * Summary:
     * Checks if the board is completely full.
     *
     * Returns:
     * @return - (boolean type): True if the board is full, false otherwise.
     */
	public boolean isFull() {
		int row,column;
		
		for (row=0;row<n;row++) {
			for (column=0;column<m;column++) {
				if (board[row][column] == null) {
					return false;
				}
			}
		}
		return true;
	}
	
	  /**
     * Summary:
     * Returns a string representation of the board.
     *
     * Returns:
     * @return - (String type): A string representation of the board.
     */
	public String toString() {
		int row, column;
		String boardAsString = "";
		
		for (row=0;row<n;row++) {
			for (column=0;column<m;column++) {
				if (board[row][column] != null) {
					boardAsString += board[row][column].getMark();
				}
				else {
					boardAsString += ".";
				}
			}
			boardAsString += '\n'; 
		}
		
		return boardAsString;
	}
	
	/**
	 * Summary:
	 * Calculates the maximum line length containing a specific position on the board.
	 *
	 * Arguments:
	 * @param i - (int type): The row index.
	 * @param j - (int type): The column index.
	 *
	 * Returns:
	 * @return - (int type): The length of the longest line containing the specified position.
	 */
	protected int maxLineContaining(int i, int j) {
		int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};
		int directionIndex;
		
		int lineLength;
		int largestLength = 0;
		
		for (directionIndex = 0; directionIndex < directions.length; directionIndex++) {
			lineLength = rayLength(i,j, directions[directionIndex][0], directions[directionIndex][1]);
			lineLength +=  rayLength(i,j, -directions[directionIndex][0], -directions[directionIndex][1]);
			lineLength -= 1; // The initial point is counted twice, therefore we need to substract by one.
			
			if (lineLength > largestLength) {
				largestLength = lineLength;
			}
		}
		
		return largestLength;
	}
	
	 /**
     * Summary:
     * Calculates the length of a ray starting from a specific position in a given direction.
     *
     * Arguments:
     * @param i - (int type): The row index.
     * @param j - (int type): The column index.
     * @param di - (int type): The row direction.
     * @param dj - (int type): The column direction.
     *
     * Returns:
     * @return - (int type): The length of the ray.
     */
	private int rayLength(int i, int j, int di, int dj) {
		Player player = board[i][j];
		int counter = 0; 
		int row = i, column = j;
		
		while (row < n && row >= 0 && column < m && column >= 0) {
			if (this.get(row, column) == null) {
				return counter;
			}
			else if (this.get(row, column).equals(player)){
				counter++;
			}
			row += di;
			column += dj;
		}
	
		return counter;
	}
}
	