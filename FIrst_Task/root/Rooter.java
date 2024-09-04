package root;

/**
 * Summary:
 * Represents a class for calculating square roots with a specified precision.
 *
 * Fields:
 * precision - (double type): The precision used in the square root calculations.
 */
public class Rooter {
	private double precision;
	
	/**
	 * Summary:
	 * Constructs a Rooter object with a specified precision for square root calculations.
	 *
	 * Arguments:
	 * @param precision - (double type): The precision to be used in square root calculations.
	 */
	public Rooter(double precision)
	{
		this.precision = precision;
	}
	
	/**
	 * Summary:
	 * Sets the precision to be used in square root calculations.
	 *
	 * Arguments:
	 * @param precision - (double type): The precision to be set.
	 */
	public void setPrecision(double precision) {
		this.precision = precision;
	}
	
	/**
	 * Summary:
	 * Calculates the square root of a given number with the specified precision.
	 *
	 * Arguments:
	 * @param x - (double type): The number for which the square root is to be calculated.
	 *
	 * Returns:
	 * @return - (double type): The square root of the given number with the specified precision.
	 */
	public double sqrt(double x){
		double one = 1, two = x;
		while (true){
			one = (one+two)/2;
			two = x/one;
			if (one > two){
				if ((one - two) <= precision){
					return one;
				}
			}
			else{
				if((two - one) <= precision){
					return one;
				}
			}
		}
	}
}
