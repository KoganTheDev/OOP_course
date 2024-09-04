package graph;

import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;

/**
 * Represents an undirected graph using vertices of type {@code V}.
 * 
 * @param <V> the type of the vertices in the graph
 */
public class Graph<V> {
    private Set<V> vertices = new HashSet<>();
    private Map<V, Set<V>> edges = new HashMap<>();

    /**
     * Adds a vertex to the graph.
     * 
     * @param v the vertex to be added
     * @throws GraphException if the vertex already exists in the graph
     */
    public void addVertex(V v) throws GraphException {
    	if (!vertices.add(v)) { // In a Set it will return false if the element already exists
    		throw new GraphException("The vertex " + v.toString() + " already exists in the vertices set.\n");
    	}
    }

    /**
     * Adds an edge between two vertices in the graph.
     * 
     * @param v1 the first vertex
     * @param v2 the second vertex
     * @throws GraphException if either vertex does not exist or if the edge already exists
     */
    public void addEdge(V v1, V v2) throws GraphException {
        if (!vertices.contains(v1) || !vertices.contains(v2)) {
            throw new GraphException(v1.toString() + " or " + v2.toString() + " do not exist in vertices.\n");
        }
        
        edges.putIfAbsent(v1, new HashSet<>()); // Initialize the set for v1 if it does not exist
        edges.putIfAbsent(v2, new HashSet<>()); // Initialize the set for v2 if it does not exist
        
        // Add edge from v1 to v2
        if (!edges.get(v1).add(v2) || !edges.get(v2).add(v1)) {
            throw new GraphException("The edge from " + v1.toString() + " to " + v2.toString() + " already exists.\n");
        }
    }

    /**
     * Checks if there is an edge between two vertices.
     * 
     * @param v1 the first vertex
     * @param v2 the second vertex
     * @return {@code true} if there is an edge between v1 and v2, {@code false} otherwise
     */
    public boolean hasEdge(V v1, V v2) {
        return vertices.contains(v1) && vertices.contains(v2) && edges.get(v1) != null && edges.get(v1).contains(v2);
    }
    
    /**
     * Determines if there is a path between two vertices in the graph.
     * 
     * @param v1 the starting vertex
     * @param v2 the target vertex
     * @return {@code true} if there is a path from v1 to v2, {@code false} otherwise
     * @throws GraphException if either vertex does not exist in the graph
     */
    public boolean connected(V v1, V v2) throws GraphException {
        Set<V> visited = new HashSet<>();
        
        if (!vertices.contains(v1) || !vertices.contains(v2)) {
        	throw new GraphException("The graph does not contain the vertices " + v1.toString() + " or " + v2.toString());
        }
        
        return recursiveDFS(v1, v2, visited);
    }

    /**
     * Recursively performs depth-first search to determine if a path exists between two vertices.
     * 
     * @param v1 the starting vertex
     * @param v2 the target vertex
     * @param visited a set of visited vertices
     * @return {@code true} if a path from v1 to v2 is found, {@code false} otherwise
     * @throws GraphException if an unexpected condition occurs during the search
     */
    private boolean recursiveDFS(V v1, V v2, Set<V> visited) throws GraphException {
        if (v1.equals(v2)) {
            return true;
        }

        visited.add(v1);

        Set<V> neighbors = edges.get(v1);
        if (neighbors != null) {
            for (V neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    if (recursiveDFS(neighbor, v2, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}