package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The Combined class implements an Iterable of elements, 
 * which combines two Iterable instances and iterates over them in sequence.
 * 
 * @param <E> The type of elements to iterate over.
 */
public class Combined<E> implements Iterable<E> {
    private Iterable<E> first;
    private Iterable<E> second;

    /**
     * Constructs a Combined object with two Iterable instances.
     *
     * @param first The first Iterable instance.
     * @param second The second Iterable instance.
     */
    public Combined(Iterable<E> first, Iterable<E> second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Returns an iterator that iterates over the combined elements of the two Iterables.
     *
     * @return A CombinedIterator to iterate over the combined elements.
     */
    @Override
    public Iterator<E> iterator() {
        return new CombinedIterator();
    }
    
    /**
     * The CombinedIterator class implements an Iterator for the Combined class.
     * It iterates over two Iterable instances in sequence.
     */
    private class CombinedIterator implements Iterator<E> {
        private Iterator<E> firstIterator;
        private Iterator<E> secondIterator;
        private boolean takeFromFirst;
        private E currentElement;

        /**
         * Constructs a CombinedIterator object to iterate over the two Iterable instances.
         */
        public CombinedIterator() {
            firstIterator = first.iterator();
            secondIterator = second.iterator();
            takeFromFirst = true;
            currentElement = null;
        }
        
        /**
         * Checks if there are more elements to iterate over.
         *
         * @return {@code true} if there are more elements to iterate over; {@code false} otherwise.
         */
        @Override
        public boolean hasNext() {
            if (takeFromFirst) {
            	return firstIterator.hasNext();
            }
            return secondIterator.hasNext();
        }
        
        /**
         * Returns the next element in the iteration.
         *
         * @return The next element from the current Iterable.
         * @throws NoSuchElementException if there are no more elements to return.
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the Iterables.");
            }
            
            if (takeFromFirst) {
                currentElement = firstIterator.next();
            } else {
                currentElement = secondIterator.next();
            }
            
            // Toggle the flag for the next iteration if the current array is exhausted
            if (!firstIterator.hasNext()) { // No more items in the first array.
            	takeFromFirst = false; // grab only from the second one.
            }
            else if (!secondIterator.hasNext()) { // No more items in the second array.
            	takeFromFirst = true; // Grab only from the first one.
            }
            else if (takeFromFirst && firstIterator.hasNext()) {
            	takeFromFirst = false;
            }
            else if (!takeFromFirst && secondIterator.hasNext()) {
                takeFromFirst = true;
            }
        	
            return currentElement;
        }
    }
}
