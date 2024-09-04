package iterator;

/**
 * Summary:
 * Utility class for converting a MyIterator instance to a string representation.
 *
 * Methods:
 * toString - Converts a MyIterator instance to a string representation.
 */
public class IteratorToString {

    /**
     * Summary:
     * Converts a MyIterator instance to a string representation.
     *
     * Arguments:
     * @param it - (MyIterator type): The iterator instance to convert.
     *
     * Returns:
     * @return - (String type): The string representation of the iterator.
     */
    public static String toString(MyIterator it) {
        StringBuilder resultString = new StringBuilder();
        resultString.append("[");

        while (it.hasNext()) {
            resultString.append(it.next()).append(" ");
        }
        resultString.delete(resultString.length() - 1, resultString.length()); // Deletes trailing space.
        resultString.append("]");

        return resultString.toString();
    }
}
