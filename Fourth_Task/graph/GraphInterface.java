package graph;

import java.util.Collection;

/**
 * The {@code GraphInterface} interface represents a generic graph structure.
 * It provides a method to obtain neighboring vertices for a given vertex.
 *
 * @param <V> the type of vertices in the graph.
 */
public interface GraphInterface<V> {
	/**
     * Returns a collection of neighboring vertices for the specified vertex.
     *
     * @param v the vertex for which to find neighbors.
     * @return a collection of neighboring vertices.
     */
	public Collection<V> neighbours(V v);
}

