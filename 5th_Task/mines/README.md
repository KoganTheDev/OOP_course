# 🚩 Minesweeper Game

Welcome to the **Minesweeper Game** project! This project implements the classic Minesweeper game using Java, allowing players to reveal cells, toggle flags, and avoid mines. The game dynamically generates a board with customizable size and number of mines.

## 🎮 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [How to Play](#how-to-play)
- [Code Structure](#code-structure)
- [Usage Example](#usage-example)
- [Contact](#contact)

---

## 📜 Overview

Minesweeper is a puzzle game where the objective is to open all non-mined cells on a board while avoiding mines. Players can also place flags to mark cells where they suspect mines are located. The game ends when all safe cells are revealed or a mine is opened.

This project simulates a Minesweeper board with the following key functionalities:
- Create a game board with a customizable height, width, and number of mines.
- Open cells, place flags, and reveal mines.
- Check the game status to determine if the player has won.

---

## ✨ Features

- **Dynamic Board Generation**: The game generates a board with random mine placements based on user-defined dimensions and mine count.
- **Recursive Cell Opening**: When a cell with no adjacent mines is opened, nearby cells are automatically revealed.
- **Flagging System**: Players can place and remove flags on suspected mine locations.
- **Game Completion Check**: The game detects when all safe cells have been opened, marking the game as complete.

---

## 🎯 How to Play

1. The player is presented with a grid of hidden cells.
2. The objective is to open all safe cells without triggering a mine.
3. Use the following commands:
   - **Open a cell**: Reveal its contents. If the cell contains a mine, the game ends.
   - **Flag a cell**: Mark the cell as a potential mine location.
4. The number on a cell indicates how many mines are adjacent to it.
5. Continue revealing cells and flagging suspected mines until all non-mined cells are opened.

---

## 📂 Code Structure

The project contains the following key components:

### **1. `Mines` class**
- Manages the Minesweeper board, including placing mines, opening cells, and toggling flags.
- Handles the game’s logic, like checking for mines and counting adjacent mines.

### **2. `Place` class**
- Represents a cell on the board, with properties like `value` (mine or number), `isOpen`, and `lastValue` (used for toggling flags).

---

## 💻 Usage Example

Here’s a brief example of how to create a game board and interact with it in Java:

```java
public class Main {
    public static void main(String[] args) {
        // Create a Minesweeper board with a height of 5, width of 5, and 5 mines
        Mines minesweeper = new Mines(5, 5, 5);
        
        // Open a cell at row 2, column 3
        boolean result = minesweeper.open(2, 3);
        
        // Toggle a flag at row 4, column 4
        minesweeper.toggleFlag(4, 4);
        
        // Display the current state of the board
        System.out.println(minesweeper.toString());
    }
}
```

---

## 📫 Contact

For any questions or suggestions, feel free to reach out via [LinkedIn](https://www.linkedin.com/in/yuval-kogan) or by email at [Yuvalkogan123@gmail.com].

Thank you for visiting and enjoy playing Minesweeper!
