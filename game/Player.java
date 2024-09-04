package game;

/**
 * This class represents a player in a game.
 */
public class Player {
  private String name;
  private char mark;

  /**
   * Constructs a new Player object with the specified name and mark.
   * 
   * @param name The name of the player
   * @param mark The character representing the player's mark on the game board
   */
  public Player(String name, char mark) {
    this.name = name;
    this.mark = mark;
  }

  /**
   * Returns the name of the player.
   * 
   * @return The name of the player
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the character representing the player's mark on the game board.
   * 
   * @return The character representing the player's mark
   */
  public char getMark() {
    return mark;
  }

  /**
   * Returns a string representation of the Player object in the format "name(mark)".
   * 
   * @return A string representation of the Player object
   */
  @Override
  public String toString() {
    return (name + "(" + mark + ")");
  }
}
