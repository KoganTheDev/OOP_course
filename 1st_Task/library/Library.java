package library;

/**
 * Summary: 
 * Represents a library with a collection of books.
 *
 * Fields: 
 * arr - (Book array type): An array to store the books in the library.
 */
public class Library {
	private Book[] arr;

	/**
	 * Summary: 
	 * Constructs a Library object with the specified size.
	 *
	 * Arguments:
	 * @param size - (int type): The size of the library, indicating the maximum
	 * number of books it can hold.
	 */
	public Library(int size) {
		arr = new Book[size];
	}

	/**
	 * Summary:
	 * Adds a new book to the library at the specified index.
	 *
	 * Arguments:
	 * @param bookNum - (int type): The index at which to add the book.
	 * @param title   - (String type): The title of the book to be added.
	 * @param auth    - (Author type): The author of the book to be added.
	 */
	public void setBook(int bookNum, String title, Author auth) {
		Book newBook = new Book(title, auth);
		arr[bookNum] = newBook;
	}

	/**
	 * Summary: 
	 * Retrieves the book at the specified index from the library.
	 *
	 * Arguments:
	 * @param bookNum - (int type): The index of the book to be retrieved.
	 *
	 * Returns:
	 * @return - (Book type): The book at the specified index, or null if no book
	 * exists at that index.
	 */
	public Book getBook(int bookNum) {
		if (arr[bookNum] == null) {
			return null;
		}
		return (arr[bookNum]);
	}
}
