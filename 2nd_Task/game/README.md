# 🎮 General Board for Games

## 📜 Overview
This project involves creating a general board that can be utilized for various games. The board is designed to be flexible and adaptable, accommodating different game requirements and configurations.

## 🛠️ Classes

### 🏗️ Board Class
- **Summary**: Represents the general game board.
- **Fields**:
  - `Player[][] board`: The grid representing the game board.
  - `int n`: The number of rows in the board.
  - `int m`: The number of columns in the board.
- **Methods**:
  - `boolean set(int i, int j, Player p)`: Sets a player at the specified position if it is currently empty.
  - `boolean isEmpty(int i, int j)`: Checks if the specified position on the board is empty.
  - `Player get(int i, int j)`: Gets the player at the specified position on the board.
  - `boolean isFull()`: Checks if the board is completely full.
  - `String toString()`: Returns a string representation of the board.
  - `int maxLineContaining(int i, int j)`: Calculates the maximum line length containing a specific position on the board.
  - `int rayLength(int i, int j, int di, int dj)`: Calculates the length of a ray starting from a specific position in a given direction.
- **Examples**:
  ```java
  Board gameBoard = new Board(3, 3);
  gameBoard.set(0, 0, new Player("Player1", 'X'));
  System.out.println(gameBoard.toString());
  ```

### ♟️ Player Class
- **Summary**: Represents a player in a game.
- **Fields**:
  - `String name`: The name of the player.
  - `char mark`: The character representing the player's mark on the game board.
- **Methods**:
  - `String getName()`: Returns the name of the player.
  - `char getMark()`: Returns the character representing the player's mark on the game board.
- **Examples**:
  ```java
  Player player1 = new Player("Alice", 'X');
  System.out.println(player1.getName() + " plays with mark " + player1.getMark());
  ```

### 🎲 Game Class
- **Summary**: Represents a game that extends the Board class, allowing two players to play against each other.
- **Fields**:
  - `Player[] players`: An array holding the two players.
  - `Scanner s`: A Scanner object for reading player input.
- **Methods**:
  - `boolean doesWin(int i, int j)`: Checks if placing a piece at the specified position results in a win.
  - `boolean onePlay(Player p)`: Allows a player to make one move in the game.
  - `Player play()`: Starts the game and alternates between players until one wins or the board is full.
- **Examples**:
  ```java
  Game game = new Game(3, 3, new Player("Alice", 'X'), new Player("Bob", 'O'));
  game.play();
  ```

### 🕹️ FourInARow Class
- **Summary**: Represents a game of Four in a Row, extending the Game class.
- **Methods**:
  - `boolean doesWin(int i, int j)`: Determines if placing a piece at the specified position results in a win.
  - `boolean onePlay(Player p)`: Allows a player to make one move in the game.
- **Examples**:
  ```java
  FourInARow game = new FourInARow("Alice", "Bob");
  game.play();
  ```

### ❌ TicTacToe Class
- **Summary**: Represents a game of Tic Tac Toe that extends the Game class.
- **Methods**:
  - `boolean doesWin(int row, int col)`: Determines if placing a piece at the specified position results in a win.
- **Examples**:
  ```java
  TicTacToe game = new TicTacToe("Alice", "Bob");
  game.play();
  ```
## 🏁 Conclusion
The General Board project provides a flexible foundation for creating various games. By implementing a dynamic grid system and customizable pieces, the board can adapt to multiple gameplay scenarios.

## 📄 License
This project is licensed under the [MIT License](link-to-license).
