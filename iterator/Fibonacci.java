package iterator;

/**
 * Summary:
 * Implements the MyIterator interface for iterating over a Fibonacci sequence up to a specified upper bound.
 *
 * Fields:
 * upperBound - (int type): The upper limit for the Fibonacci sequence.
 * previousNumberInSequence - (int type): The previous number in the Fibonacci sequence.
 * currentNumberInSequence - (int type): The current number in the Fibonacci sequence.
 * sequenceIteration - (int type): The current iteration count in the sequence.
 *
 * Constructor:
 * Fibonacci - Constructs a Fibonacci sequence iterator with the specified upper bound.
 *
 * Methods:
 * hasNext - Checks if there are more elements in the Fibonacci sequence within the upper bound.
 * next - Retrieves the next element in the Fibonacci sequence.
 */
public class Fibonacci implements MyIterator {
	private int upperBound;
	private int previousNumberInSequence; 
	private int currentNumberInSequence;
	private int sequenceIteration;

	/**
	 * Summary:
	 * Constructs a Fibonacci sequence iterator with the specified upper bound.
	 *
	 * Arguments:
	 * @param upperBound - (int type): The upper limit for the Fibonacci sequence.
	 */
	public Fibonacci(int upperBound) {
		this.upperBound = upperBound;
		previousNumberInSequence = 1;
		currentNumberInSequence = 1;
		sequenceIteration = 0;
	}

	/**
	 * Summary:
	 * Checks if there are more elements in the Fibonacci sequence within the upper bound.
	 *
	 * Returns:
	 * @return - (boolean type): True if there are more elements, false otherwise.
	 */
	@Override
	public boolean hasNext() {
		return (previousNumberInSequence + currentNumberInSequence) <= upperBound;
	}

	/**
	 * Summary:
	 * Retrieves the next element in the Fibonacci sequence.
	 *
	 * Returns:
	 * @return - (int type): The next element in the Fibonacci sequence.
	 */
	@Override
	public int next() {
		int nextNumberInSequence = previousNumberInSequence + currentNumberInSequence;
		
		if (hasNext()) {
			if (sequenceIteration == 0 || sequenceIteration == 1) { // Special case for the first and second numbers.
				sequenceIteration++;
				return currentNumberInSequence; // Both are 1.
			} else {
				previousNumberInSequence = currentNumberInSequence;
				currentNumberInSequence = nextNumberInSequence;
				return currentNumberInSequence;
			}
		} else {
			return currentNumberInSequence;
		}
	}
}
