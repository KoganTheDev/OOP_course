package graph;

/**
 * The {@code Place} class represents a specific location in a two-dimensional space.
 * It is defined by its x and y coordinates within a given boundary.
 * The class ensures that the coordinates are within valid bounds and provides
 * methods to access these coordinates as well as utility methods for object comparison and string representation.
 */
public class Place {
	private int x; /** The x-coordinate of the place. */
	private int y; /** The y-coordinate of the place. */

	/**
     * Constructs a new {@code Place} with the specified coordinates within the given boundary.
     * The coordinates must be within the range of 0 (inclusive) to bound (exclusive).
     *
     * @param x the x-coordinate of the place.
     * @param y the y-coordinate of the place.
     * @param bound the upper limit for the coordinates.
     * @throws IllegalArgumentException if the coordinates are out of bounds.
     */
	public Place(int x, int y, int bound) throws IllegalArgumentException{
		if (!(0 <= x && x < bound) || !(0 <= y && y < bound)){ // x and y must be in the range of 0 to bound-1.
			throw new IllegalArgumentException();
		}
		
		// Set x and y to their appropriate location.
		this.x = x;
		this.y = y;
	}
	
	/**
     * Returns the x-coordinate of this place.
     *
     * @return the x-coordinate.
     */
	public int getX() {
		return x;
	}
	
	/**
     * Returns the y-coordinate of this place.
     *
     * @return the y-coordinate.
     */
	public int getY() {
		return y;
	}
	
	/**
     * Returns a string representation of this place in the format (x, y).
     *
     * @return a string representation of the place.
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("(");
		sb.append(getX());
		sb.append(", ");
		sb.append(getY());
		sb.append(")");
		
		return sb.toString();
	}
	
	/**
     * Returns a hash code value for this place. The hash code is computed based on
     * the x and y coordinates.
     *
     * @return a hash code value for this place.
     */
	 @Override
	 public int hashCode() {
		 int result = 17;
		 result = 31 * result + x;
		 result = 31 * result + y;
		 return result;
	 }

	 /**
	     * Compares this place to the specified object. The result is {@code true} if and only if
	     * the argument is not {@code null} and is a {@code Place} object that has the same
	     * x and y coordinates as this object.
	     *
	     * @param obj the object to compare this place against.
	     * @return true if the given object represents a {@code Place} equivalent to this place, {@code false} otherwise.
	     */
	 @Override
	 public boolean equals(Object obj) {
		 if (this == obj) {
			 return true;
	     }
		 if (obj == null || getClass() != obj.getClass()) {
			 return false;
		 }

		 Place place = (Place) obj;
		 return x == place.x && y == place.y;
	 }
}
