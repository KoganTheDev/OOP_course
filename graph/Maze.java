package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The {@code Maze} class represents a two-dimensional maze with start and end points.
 * It provides functionality to add walls, check if the maze is solvable, and get neighboring places.
 */
public class Maze implements GraphInterface<Place> {
	private Place[][] maze; /** The two-dimensional array representing the maze grid. */
	private Place start; /** The starting point in the maze. */
	private Place end; /** The ending point in the maze. */
	
	/**
     * Constructs a new {@code Maze} with the specified size, start, and end coordinates.
     *
     * @param size the size of the maze (it will be a size x size grid).
     * @param startx the x-coordinate of the starting point.
     * @param endx the x-coordinate of the ending point.
     * @param starty the y-coordinate of the starting point.
     * @param endy the y-coordinate of the ending point.
     * @throws IllegalArgumentException if the start or end coordinates are out of bounds.
     */
	public Maze(int size, int startx, int endx, int starty, int endy) throws IllegalArgumentException{
		maze = new Place[size][size];
		
		start = new Place(startx, endx, size);
		end = new Place(starty, endy, size);
		
		maze[startx][endx] = start;
		maze[starty][endy] = end;
	}
	
	/**
     * Adds a wall at the specified coordinates.
     *
     * @param x the x-coordinate where the wall will be added.
     * @param y the y-coordinate where the wall will be added.
     * @return {@code true} if the wall was added successfully, {@code false} otherwise.
     * @throws IllegalArgumentException if the coordinates are out of bounds.
     */
	public boolean addWall(int x, int y) throws IllegalArgumentException {
		// There`s a wall in this location or the place is the starting or ending location.
		if (maze[y][x] != null || (x == start.getX() && y == start.getY()) ||
				(x == end.getX() && y == end.getY())) { // There`s a wall in this location
 			return false;
		}
		
		// This coordinate is free to put a wall in.
		maze[y][x] = new Place(x, y, maze.length);
		return true;
	}
	
	/**
     * Returns a string representation of the maze.
     *
     * @return a string representation of the maze.
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int x = 0; x < maze.length; x++) {
			if (x != 0) {
				sb.append('\n');
			}
			for (int y = 0; y < maze.length; y++) {
				if (maze[x][y] == null) {
					sb.append('.');
				}
				else {
					if (maze[x][y].equals(start)) {
						sb.append('S');
					}
					else if (maze[x][y].equals(end)) {
						sb.append('E');
					}
					else if (maze[x][y] != null) { // Looks for a wall.
						sb.append('@');
					}
				}
			}
		}
		
		
		sb.append('\n');
		return sb.toString();
	}
	
	/**
     * Determines if the maze is solvable from the start to the end point.
     *
     * @return {@code true} if the maze is solvable, {@code false} otherwise.
     */
	public boolean isSolvable() {
	    Graph<Place> graph = new Graph<>();

	    // Add all vertices
	    for (int x = 0; x < maze.length; x++) {
	        for (int y = 0; y < maze.length; y++) {
	            if (maze[y][x] == null || maze[y][x].equals(start) || maze[y][x].equals(end)) {
	                Place place = new Place(x, y, maze.length);
	                try {
	                    graph.addVertex(place);
	                } catch (GraphException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }

	    // Add edges between adjacent open places
	    for (int x = 0; x < maze.length; x++) {
	        for (int y = 0; y < maze.length; y++) {
	            if (maze[y][x] == null || maze[y][x].equals(start) || maze[y][x].equals(end)) {
	                Place current = new Place(x, y, maze.length);
	                Collection<Place> neighbors = neighbours(current);
	                for (Place neighbor : neighbors) {
	                	// Check if current has an edge with neighbor already and if so, skip it.
	                	if (graph.hasEdge(current, neighbor)) {
	                		continue;
	                	}
	                    try {
	                        graph.addEdge(current, neighbor);
	                    } catch (GraphException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }

	    try {
	        return graph.connected(start, end);
	    } catch (GraphException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
	/**
     * Returns a collection of neighboring places for the specified place.
     *
     * @param p the place for which to find neighbors.
     * @return a collection of neighboring places.
     */
	@Override
	public Collection<Place> neighbours(Place p) {
	    Set<Place> neighbours = new HashSet<>();
	    
	    int x = p.getX();
	    int y = p.getY();
	    
	    // Check all four possible directions
	    if (x > 0 && (maze[y][x-1] == null || maze[y][x-1].equals(start) || maze[y][x-1].equals(end))) {
	        neighbours.add(new Place(x-1, y, maze.length));
	    }
	    if (x < maze.length - 1 && (maze[y][x+1] == null || maze[y][x+1].equals(start) || maze[y][x+1].equals(end))) {
	        neighbours.add(new Place(x+1, y, maze.length));
	    }
	    if (y > 0 && (maze[y-1][x] == null || maze[y-1][x].equals(start) || maze[y-1][x].equals(end))) {
	        neighbours.add(new Place(x, y-1, maze.length));
	    }
	    if (y < maze.length - 1 && (maze[y+1][x] == null || maze[y+1][x].equals(start) || maze[y+1][x].equals(end))) {
	        neighbours.add(new Place(x, y+1, maze.length));
	    }

	    return neighbours;
	}

}
