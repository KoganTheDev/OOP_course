package mines;

import java.util.Random;

/**
 * The Mines class represents a Minesweeper game board. It allows for creating a board of specified dimensions,
 * placing mines, opening cells, toggling flags, and checking the game state.
 */
public class Mines {
    private int height;
    private int width;

    private Place[][] board; // The board the game will be played on.
    private static final Random random = new Random(); // Used as a seed for the random numbers given for the mines.
    private boolean showAll = false;
    
    /**
     * Represents a cell on the Minesweeper board.
     */
    private class Place {
        private int value;
        private boolean isOpen;
        private int lastValue;
    }
    
    /**
     * Constructs a Minesweeper board with the specified height, width, and number of mines.
     * @param height The height of the board.
     * @param width The width of the board.
     * @param numMines The number of mines to be placed on the board.
     */
    public Mines(int height, int width, int numMines) {
        this.height = height;
        this.width = width; 
        board = new Place[height][width];
        
        updateNewBoardInformation(); // Sets all of the values in the board to zero and marks all places as not open.
        
        // Create Mines in random locations within the board's size limit.
        for (int i = 0; i < numMines; i++) {
            int[] validRandomLocation = randomLocationGeneratorForMines();
            
            // Set mine represented by -1.
            board[validRandomLocation[0]][validRandomLocation[1]].value = -1;    
        }
    }
    
    /**
     * Adds a mine to the specified location on the board.
     * @param row The row index of the location.
     * @param col The column index of the location.
     * @return true if the mine was successfully added, false otherwise.
     */
    public boolean addMine(int row, int col) {
        if (isLocationValid(row, col) && board[row][col].value != -1) { // Ensure location is valid and there's no mine already
            board[row][col].value = -1;
            return true;
        }
        return false; // If the function fails to set a mine in this location.
    }
    
    /**
     * Gets the representation of the cell at the specified location.
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return A string representing the cell: "X" for a mine, "F" for a flag, "." for a closed cell, 
     *         " " for an opened cell with no adjacent mines, or a number for opened cells with adjacent mines.
     */
    public String get(int row, int col) {
        int numMinesNearPoint;
        
        if (showAll) {
            if (board[row][col].value == -1) {
                return "X";
            }
            // Update the amount of mines nearby and show to the user.
            numMinesNearPoint = countMinesAround(row, col);
            if (numMinesNearPoint == 0) {
                return " ";
            }
            return "" + numMinesNearPoint;
        }
        
        if (!board[row][col].isOpen) {
            if (board[row][col].value == 2) {
                return "F";
            }
            return ".";
        }
        
        if (board[row][col].isOpen) {
            if (board[row][col].value == -1) {
                return "X";
            } else {
                numMinesNearPoint = countMinesAround(row, col);
                if (numMinesNearPoint == 0) {
                    return " ";
                }
                return "" + numMinesNearPoint;
            }
        }
        return ".";
    }
    
    /**
     * Opens the cell at the specified location.
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return true if the cell was successfully opened, false if the cell is out of bounds, already open, or a mine.
     */
    public boolean open(int row, int col) {
        if (!isLocationValid(row, col)) {
            return false; // Out of bounds
        }
        
        if (board[row][col].isOpen) {
            return false; // Already open
        }
        
        if (board[row][col].value == -1) {
            return false; // It's a mine
        }
        
        board[row][col].isOpen = true; // Mark the cell as open
        board[row][col].value = 1; // Mark cell as opened already
        
        // If the cell has no adjacent mines, recursively open adjacent cells
        if (countMinesAround(row, col) == 0) {
            int[] vectorX = {-1, 0, 1};
            int[] vectorY = {-1, 0, 1};
            
            for (int xOffset : vectorX) {
                for (int yOffset : vectorY) {
                    if (xOffset == 0 && yOffset == 0) {
                        continue; // Skip the current cell
                    }
                    
                    int newRow = row + xOffset;
                    int newCol = col + yOffset;
                    
                    if (isLocationValid(newRow, newCol) && !board[newRow][newCol].isOpen) {
                        open(newRow, newCol); // Recursive call
                    }
                }
            }
        }
        
        return true;
    }

    /**
     * Toggles a flag on or off at the specified location.
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     */
    public void toggleFlag(int row, int col) {
        if (isLocationValid(row, col)) {
            if (board[row][col].value == 2) { // If there's a flag, remove it.
                board[row][col].value = board[row][col].lastValue;
            } else {
            	board[row][col].lastValue = board[row][col].value;
                board[row][col].value = 2; // Set a flag.
            }
        }
    }
    
    /**
     * Checks if the game is complete. The game is considered complete if there are no unopened cells with value 0.
     * @return true if the game is done, false otherwise.
     */
    public boolean isDone() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (board[row][col].value == 0 && !board[row][col].isOpen) {
                    return false;
                }
            }
        }
        return true; // If no unopened cells with value 0 were found.
    }
    
    /**
     * Sets whether all cells should be shown.
     * @param showAll If true, all cells will be shown; if false, only opened cells and flags will be shown.
     */
    public void setShowAll(boolean showAll) {
        this.showAll = showAll;
    }
    
    /**
     * Returns a string representation of the board.
     * @return A string representation of the board where each cell is represented by its status.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                sb.append(get(row, col));
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    /**
     * Generates a random location for a mine on the board that is currently free.
     * @return An array of two integers where the first element is the row index and the second is the column index.
     */
    private int[] randomLocationGeneratorForMines() {
        int[] result = new int[2];
        int randomRow = random.nextInt(height);
        int randomCol = random.nextInt(width);
            
        // Find a location in the board that is free to put a mine in.
        while (board[randomRow][randomCol].value != 0) {
            randomRow = random.nextInt(height);
            randomCol = random.nextInt(width);
        }
            
        // Allocate the row and column to the array and return it.
        result[0] = randomRow;
        result[1] = randomCol;
            
        return result;
    }
    
    /**
     * Checks if the specified location is within the bounds of the board.
     * @param row The row index of the location.
     * @param col The column index of the location.
     * @return true if the location is valid, false otherwise.
     */
    private boolean isLocationValid(int row, int col) {
        return 0 <= row && row < height && 0 <= col && col < width;
    }
    
    /**
     * Initializes the board, setting all cells to default values (value = 0, isOpen = false, lastValue = 0).
     */
    private void updateNewBoardInformation() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                board[row][col] = new Place();
                board[row][col].value = 0;
                board[row][col].isOpen = false;
                board[row][col].lastValue = 0;
            }
        }
    }
    
    /**
     * Counts the number of mines around the specified cell.
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return The number of mines around the cell.
     */
    private int countMinesAround(int row, int col) {
        int numMines = 0;
        int[] vectorX = {-1, 0, 1};
        int[] vectorY = {-1, 0, 1};
        
        for (int xOffset : vectorX) {
            for (int yOffset : vectorY) {
                if (xOffset == 0 && yOffset == 0) {
                    continue; // Skip the current cell
                }
                
                int newRow = row + xOffset;
                int newCol = col + yOffset;
                
                // Increment the number of mines by one if the cell contains either a mine or a flag.
                if (isLocationValid(newRow, newCol)) {
                	if (board[newRow][newCol].value == -1 || board[newRow][newCol].value == 2) {
                		numMines++;
                	}
                }
            }
        }
        
        return numMines;
    }
}
