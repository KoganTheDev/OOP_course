 package library;

/**
 * Summary:
 * Represents a book with a title and author.
 *
 * Fields:
 * title - (String type): The title of the book.
 * auth - (Author type): The author of the book.
 */
public class Book {
	private String title;
	private Author auth;
	
    /**
     * Summary:
     * Constructs a Book object with the specified title and author.
     *
     * Arguments:
     * @param title - (String type): The title of the book.
     * @param auth - (Author type): The author of the book.
     */
	public Book(String title, Author auth) {
		this.title = title;
		this.auth = auth;
	}
	
	 /**
     * Summary:
     * Returns the title of the book.
     *
     * Returns:
     * @return - (String type): The title of the book.
     */
	public String getTitle() {
		return title;
	}
	
	  /**
     * Summary:
     * Returns the name of the author of the book.
     *
     * Returns:
     * @return - (String type): The name of the author.
     */
	public String getAuthorName() {
		return auth.getName();
	}
	
	 /**
     * Summary:
     * Returns the birth year of the author of the book.
     *
     * Returns:
     * @return - (int type): The birth year of the author.
     */
	public int getAuthorBirthYear() {
		return auth.getBirthYear();
	}

	 /**
     * Summary:
     * Returns a string representation of the book.
     *
     * Returns:
     * @return - (String type): A string representation of the book in the format "title written by authorName(birthYear)".
     */
	public String toString() {
		return (title + " written by " + auth.toString());
	}
}
