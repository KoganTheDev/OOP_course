package graph;

/**
 * Exception class representing errors that occur in the graph operations.
 * This class extends the standard {@link Exception} class and provides
 * additional functionality to handle graph-specific error messages.
 */
public class GraphException extends Exception {
	
	// To ensure compatibility during serialization
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a new GraphException with the specified detail message.
     *
     * @param message the detail message which provides more information about the error
     */
	public GraphException(String message) {
        super(message);
    }
}
