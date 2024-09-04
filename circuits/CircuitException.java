package circuits;

/**
 * Summary:
 * Represents an exception that is thrown when a circuit-related error occurs.
 * This class extends the Exception class to provide detailed error messages.
 *
 * Constructors:
 * CircuitException - Constructs a CircuitException with a specified error message.
 */
public class CircuitException extends Exception {

    /**
     * Summary:
     * Constructs a CircuitException with a specified error message.
     *
     * Arguments:
     * @param message - (String type): The error message describing the exception.
     */
    public CircuitException(String message) {
        super(message);
    }
}
