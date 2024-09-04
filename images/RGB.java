package images;

/**
 * Summary:
 * Represents an RGB color with red, green, and blue components.
 *
 * Fields:
 * red - (double type): The red component of the color.
 * green - (double type): The green component of the color.
 * blue - (double type): The blue component of the color.
 * BLACK - (RGB type): A constant for the color black (0, 0, 0).
 * WHITE - (RGB type): A constant for the color white (1, 1, 1).
 * RED - (RGB type): A constant for the color red (1, 0, 0).
 * GREEN - (RGB type): A constant for the color green (0, 1, 0).
 * BLUE - (RGB type): A constant for the color blue (0, 0, 1).
 *
 * Constructors:
 * RGB - Constructs an RGB color with specified red, green, and blue components.
 * RGB - Constructs an RGB color with the same value for red, green, and blue components (grey).
 *
 * Methods:
 * getRed - Returns the red component of the color.
 * getGreen - Returns the green component of the color.
 * getBlue - Returns the blue component of the color.
 * invert - Returns a new RGB color that is the inverse of the current color.
 * filter - Returns a new RGB color filtered by another RGB color.
 * superpose - Returns a new RGB color that is the superposition of two RGB colors.
 * mix - Returns a new RGB color that is a mix of two RGB colors with a specified alpha.
 * toString - Returns a string representation of the RGB color.
 */
public class RGB {
	private double red;
	private double green;
	private double blue;
	
	public static final RGB BLACK = new RGB(0);
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1,0,0);
	public static final RGB GREEN = new RGB(0,1,0);
	public static final RGB BLUE = new RGB(0,0,1);

	 /**
     * Summary:
     * Constructs an RGB color with specified red, green, and blue components.
     *
     * Arguments:
     * @param red - (double type): The red component of the color.
     * @param green - (double type): The green component of the color.
     * @param blue - (double type): The blue component of the color.
     */
	public RGB(double red, double green, double blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	/**
     * Summary:
     * Constructs an RGB color with the same value for red, green, and blue components (grey).
     *
     * Arguments:
     * @param grey - (double type): The value for the red, green, and blue components.
     */
	public RGB(double grey) {
		red = grey;
		green = grey;
		blue = grey;
	}
	
	/**
     * Summary:
     * Returns the red component of the color.
     *
     * Returns:
     * @return - (double type): The red component of the color.
     */
	public double getRed() {
		return red;
	}
	
	/**
     * Summary:
     * Returns the green component of the color.
     *
     * Returns:
     * @return - (double type): The green component of the color.
     */
    public double getGreen() {
        return green;
    }
    
    /**
     * Summary:
     * Returns the blue component of the color.
     *
     * Returns:
     * @return - (double type): The blue component of the color.
     */
    public double getBlue() {
        return blue;
    }
	
    /**
     * Summary:
     * Returns a new RGB color that is the inverse of the current color.
     *
     * Returns:
     * @return - (RGB type): The inverted RGB color.
     */
	public RGB invert() {
		double invertedRed, invertedBlue, invertedGreen;
		
		invertedRed = 1 - red;
		invertedBlue = 1 - blue;
		invertedGreen = 1 - green;
		RGB invertedColor = new RGB(invertedRed, invertedGreen, invertedBlue);
		
		return invertedColor;
	}
	
	 /**
     * Summary:
     * Returns a new RGB color filtered by another RGB color.
     *
     * Arguments:
     * @param filter - (RGB type): The RGB color used to filter the current color.
     *
     * Returns:
     * @return - (RGB type): The filtered RGB color.
     */
	public RGB filter(RGB filter) {
		double filteredRed, filteredGreen,filteredBlue;
		
		filteredRed = red * filter.red;
		filteredGreen = green * filter.green;
		filteredBlue = blue * filter.blue;
		RGB filteredColor = new RGB(filteredRed, filteredGreen, filteredBlue);
		
		return filteredColor; 
	}
	
	/**
     * Summary:
     * Returns a new RGB color that is the superposition of two RGB colors.
     *
     * Arguments:
     * @param rgb1 - (RGB type): The first RGB color.
     * @param rgb2 - (RGB type): The second RGB color.
     *
     * Returns:
     * @return - (RGB type): The superposed RGB color.
     */
	public static RGB superpose(RGB rgb1, RGB rgb2) {
		double newRed, newGreen, newBlue;
		
		newRed = Math.min(1, rgb1.red + rgb2.red);
		newGreen = Math.min(1, rgb1.green + rgb2.green);
		newBlue = Math.min(1, rgb1.blue + rgb2.blue);
		RGB newColor = new RGB(newRed, newGreen, newBlue);
		
		return newColor;
	}
	
	 /**
     * Summary:
     * Returns a new RGB color that is a mix of two RGB colors with a specified alpha.
     *
     * Arguments:
     * @param rgb1 - (RGB type): The first RGB color.
     * @param rgb2 - (RGB type): The second RGB color.
     * @param alpha - (double type): The mixing ratio.
     *
     * Returns:
     * @return - (RGB type): The mixed RGB color.
     */
	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
		double mixedRed, mixedGreen, mixedBlue;
		
		mixedRed = alpha * rgb1.red + (1 - alpha) * rgb2.red;
		mixedGreen = alpha * rgb1.green + (1 - alpha) * rgb2.green;
		mixedBlue = alpha * rgb1.blue + (1 - alpha) * rgb2.blue; 
		RGB mixedColor = new RGB(mixedRed, mixedGreen, mixedBlue);
		
		return mixedColor;
	}
	
	 /**
     * Summary:
     * Returns a string representation of the RGB color.
     *
     * Returns:
     * @return - (String type): The string representation of the RGB color.
     */
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(String.format("<%.4f, %.4f, %.4f>", red, green, blue));
	    return sb.toString();
	}
}
