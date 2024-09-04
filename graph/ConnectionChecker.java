package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The {@code ConnectionChecker} class provides functionality to check the connection
 * between two vertices in a graph.
 *
 * @param <V> the type of vertices in the graph.
 */
public class ConnectionChecker<V> {
    private GraphInterface<V> graph;

    /**
     * Constructs a {@code ConnectionChecker} with the specified graph.
     *
     * @param g the graph to be used for connection checking.
     */
    public ConnectionChecker(GraphInterface<V> g) {
        this.graph = g;
    }

    /**
     * Checks if there is a path between the specified vertices in the graph.
     *
     * @param v1 the starting vertex.
     * @param v2 the target vertex.
     * @return {@code true} if there is a path from {@code v1} to {@code v2}, {@code false} otherwise.
     */
    public boolean check(V v1, V v2) {
        Set<V> visited = new HashSet<>();
        return dfs(v1, v2, visited);
    }

    /**
     * Performs a depth-first search to determine if there is a path from the current vertex to the target vertex.
     *
     * @param current the current vertex being explored.
     * @param target the target vertex.
     * @param visited the set of vertices that have been visited.
     * @return {@code true} if there is a path from {@code current} to {@code target}, {@code false} otherwise.
     */
    private boolean dfs(V current, V target, Set<V> visited) {
        if (current.equals(target)) {
            return true;
        }

        visited.add(current);

        Collection<V> neighbours = graph.neighbours(current);
        if (neighbours != null) {
            for (V neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    if (dfs(neighbour, target, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
