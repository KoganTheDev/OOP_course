package iterator;

/**
 * Summary:
 * Represents a custom iterator interface with methods to check for the next element and to retrieve it.
 *
 * Methods:
 * hasNext - Checks if there are more elements to iterate over.
 * next - Retrieves the next element in the iteration.
 */
public interface MyIterator {

    /**
     * Summary:
     * Checks if there are more elements to iterate over.
     *
     * Returns:
     * @return - (boolean type): True if there are more elements, false otherwise.
     */
    boolean hasNext();

    /**
     * Summary:
     * Retrieves the next element in the iteration.
     *
     * Returns:
     * @return - (int type): The next element in the iteration.
     */
    int next();
}
