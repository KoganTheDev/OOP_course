package library;

/**
 * Summary:
 * Represents an author with a name and birth year.
 *
 * Fields:
 * name - (String type): The name of the author.
 * birthYear - (int type): The birth year of the author.
 */
public class Author {
	private String name;
	private int birthYear;

	   /**
     * Summary:
     * Constructs an Author object with the specified name and birth year.
     *
     * Arguments:
     * @param name - (String type): The name of the author.
     * @param birthYear - (int type): The birth year of the author.
     */
	public Author(String name, int birthYear) { 
		this.name = name;
		this.birthYear = birthYear;
	}
	
	 /**
     * Summary:
     * Returns the name of the author.
     *
     * Returns:
     * @return - (String type): The name of the author.
     */
	public String getName() {
		return name;
	}
	
	/**
     * Summary:
     * Returns the birth year of the author.
     *
     * Returns:
     * @return - (int type): The birth year of the author.
     */
	public int getBirthYear() {
		return birthYear;
	}
	
	  /**
     * Summary:
     * Calculates the age of the author based on the specified current year.
     *
     * Arguments:
     * @param thisYear - (int type): The current year.
     *
     * Returns:
     * @return - (int type): The age of the author.
     */
	public int getAge(int thisYear) {
		int authorAge = thisYear - birthYear;
		return authorAge;
	}
	
	 /**
     * Summary:
     * Returns a string representation of the author.
     *
     * Returns:
     * @return - (String type): A string representation of the author in the format "name(birthYear)".
     */
	public String toString() {
		return (name + '(' + birthYear + ')');
	}
}