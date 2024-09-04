package game;

import java.util.Scanner;

public class Game extends Board {
	protected Player[] players;
	protected Scanner s;
	
	/**
	 * Summary:
	 * Represents a game that extends the Board class, allowing two players to play against each other.
	 *
	 * Fields:
	 * players - (Player[] type): An array holding the two players.
	 * s - (Scanner type): A Scanner object for reading player input.
	 */
	public Game(int n, int m, Player p1, Player p2) {
		super(n,m);
		players = new Player[2];
		players[0] = p1;
		players[1] = p2;
		s = new Scanner(System.in);
	}
	
	/**
     * Summary:
     * Checks if placing a piece at the specified position results in a win.
     *
     * Arguments:
     * @param i - (int type): The row index.
     * @param j - (int type): The column index.
     *
     * Returns:
     * @return - (boolean type): True if the position results in a win, false otherwise.
     */
	protected boolean doesWin(int i, int j) {
		if (i == 0 && j == 0) {
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
	protected boolean onePlay(Player p) {
		int row = 0, column = 0;
		
		System.out.println(p.toString() + ", Please enter row and column: ");
		while (s.hasNextInt	()) {
			row = s.nextInt();
			column = s.nextInt();
	
			if (row >= n || row < 0 || column >= m || column < 0) {
				System.out.println("Incorrect values, please enter row and column: ");
				continue;
			}
			
			if (isEmpty(row,column)) {
				set(row,column,p);
				break;
			}
			System.out.println("There is a piece there already...");
			System.out.println(p.toString() + ",Please enter row and column: ");
		}
		
		System.out.println(toString());
		return (doesWin(row,column));
	}
	
	/**
     * Summary:
     * Starts the game and alternates between players until one wins or the board is full.
     *
     * Returns:
     * @return - (Player type): The player who wins the game, or null if the game is a tie.
     */
	public Player play() {
		while (true) {
			if (isFull()) {
				System.out.println("It`s A Tie!");
				s.close();
				return null;
			}
			if (onePlay(players[0])) {
				System.out.println(players[0].toString() + " Won!");
				s.close();
				return players[0];
			}
			if (onePlay(players[1])) {
				System.out.println(players[1].toString() + " Won!");
				s.close();
				return players[1];
			}
		}
	}
}
