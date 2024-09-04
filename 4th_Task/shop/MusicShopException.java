package shop;

/**
 * Custom exception class for Music Shop operations.
 * Extends the Exception class.
 */
public class MusicShopException extends Exception {
	
	private static final long serialVersionUID = 1L; // Unique identifier for serialization 

	 /**
     * Constructs a new MusicShopException with the specified detail message.
     *
     * @param message The detail message which provides information about the exception.
     */
	public MusicShopException(String message) {
        super(message);
    }
}
