package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The TwoArrays class implements an Iterable of Integer values,
 * which iterates over two integer arrays in an alternating fashion.
 */
public class TwoArrays implements Iterable<Integer> {
    private int[] firstIntegerArray;
    private int[] secondIntegerArray;

    /**
     * Constructs a TwoArrays object with two integer arrays.
     *
     * @param a1 The first integer array.
     * @param a2 The second integer array.
     */
    public TwoArrays(int[] a1, int[] a2) {
        firstIntegerArray = a1;
        secondIntegerArray = a2;
    }

    /**
     * Returns an iterator over the integer arrays.
     *
     * @return A TwoArraysIterator to iterate over the integer arrays.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new TwoArraysIterator();
    }

    /**
     * The TwoArraysIterator class implements an Iterator for the TwoArrays class.
     * It iterates over two integer arrays in an alternating fashion.
     */
    private class TwoArraysIterator implements Iterator<Integer> {
        private boolean takeFromFirst;
        private int firstIndex;
        private int secondIndex;

        /**
         * Constructs a TwoArraysIterator object to iterate over the integer arrays.
         */
        public TwoArraysIterator() {
            takeFromFirst = true;
            firstIndex = 0;
            secondIndex = 0;
        }

        /**
         * Checks if there are more elements to iterate over.
         *
         * @return {@code true} if there are more elements to iterate over; {@code false} otherwise.
         */
        @Override
        public boolean hasNext() {
            if (takeFromFirst) {
                if (firstIndex < firstIntegerArray.length) {
                    return true;
                }
                // Switch to the second array if the first array is exhausted
                takeFromFirst = false;
            }
            return secondIndex < secondIntegerArray.length;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return The next integer element from the current array.
         * @throws NoSuchElementException if there are no more elements to return.
         */
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the arrays.\n");
            }

            Integer nextElement;

            if (takeFromFirst) {
                nextElement = firstIntegerArray[firstIndex++];
            } else {
                nextElement = secondIntegerArray[secondIndex++];
            }

            // Toggle the flag for the next iteration if the current array is exhausted
            if (!takeFromFirst && secondIndex >= secondIntegerArray.length) {
                takeFromFirst = true;
            } else if (takeFromFirst && firstIndex >= firstIntegerArray.length) {
                takeFromFirst = false;
            } else {
                takeFromFirst = !takeFromFirst;
            }

            return nextElement;
        }
    }
}
