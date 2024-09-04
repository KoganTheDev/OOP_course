package iterator;

import java.util.NoSuchElementException;

/**
 * Summary:
 * Implements the MyIterator interface for iterating over an array of integers.
 *
 * Fields:
 * arrayOfNumbers - (int[] type): The array of integers to iterate over.
 * currentIndex - (int type): The current index in the iteration.
 *
 * Constructor:
 * MyArray - Constructs a MyArray object with the specified array of integers.
 *
 * Methods:
 * hasNext - Checks if there are more elements to iterate over.
 * next - Retrieves the next element in the iteration.
 */
public class MyArray implements MyIterator {
	private int[] arrayOfNumbers;
	private int currentIndex;
	
	/**
	 * Summary:
	 * Constructs a MyArray object with the specified array of integers.
	 *
	 * Arguments:
	 * @param arrayOfNumbers - (int[] type): The array of integers to iterate over.
	 */
	public MyArray(int[] arrayOfNumbers) {
		this.arrayOfNumbers = arrayOfNumbers;
		currentIndex = 0;
	}
	
	/**
	 * Summary:
	 * Checks if there are more elements to iterate over.
	 *
	 * Returns:
	 * @return - (boolean type): True if there are more elements, false otherwise.
	 */
	@Override
	public boolean hasNext() {
		return (currentIndex < arrayOfNumbers.length);
	}

	/**
	 * Summary:
	 * Retrieves the next element in the iteration.
	 *
	 * Returns:
	 * @return - (int type): The next element in the iteration.
	 *
	 * Throws:
	 * @throws NoSuchElementException - If there are no more elements to iterate over.
	 */
	@Override
	public int next() {
		if (!hasNext()) {
			throw new NoSuchElementException("No such element in index " + currentIndex);
		} else {
			currentIndex += 1;
			return arrayOfNumbers[currentIndex - 1];
		}
	}
}
