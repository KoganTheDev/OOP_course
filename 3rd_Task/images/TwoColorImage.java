package images;

/**
 * Summary:
 * Represents an image that maps a two-dimensional function to RGB colors between two specified colors.
 * Extends BaseImage.
 *
 * Fields:
 * func - (TwoDFunc type): The two-dimensional function used to map coordinates to a value in [0, 1].
 *
 * Constructors:
 * TwoColorImage - Constructs a TwoColorImage with specified width, height, two RGB colors, and a two-dimensional function.
 *
 * Methods:
 * get - Retrieves the RGB color mapped by evaluating the two-dimensional function at the specified coordinates.
 */
public class TwoColorImage extends BaseImage{
	private TwoDFunc func;
	
    /**
     * Summary:
     * Constructs a TwoColorImage with specified width, height, two RGB colors, and a two-dimensional function.
     *
     * Arguments:
     * @param width - (int type): The width of the image.
     * @param height - (int type): The height of the image.
     * @param zero - (RGB type): The RGB color mapped to function values less than or equal to 0.
     * @param one - (RGB type): The RGB color mapped to function values greater than or equal to 1.
     * @param func - (TwoDFunc type): The two-dimensional function used to map coordinates to a value in [0, 1].
     */
	public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {
		super(width, height, zero, one);
		this.func = func;
	}
	
	 /**
     * Summary:
     * Retrieves the RGB color mapped by evaluating the two-dimensional function at the specified coordinates.
     *
     * Arguments:
     * @param x - (int type): The x-coordinate of the pixel.
     * @param y - (int type): The y-coordinate of the pixel.
     *
     * Returns:
     * @return - (RGB type): The RGB color mapped by the function at the specified pixel.
     */
	@Override
	public RGB get(int x, int y) {
		double normalizedX = (double) x / width;
		double normalizedY = (double) y / height;
		double res = func.f(normalizedX, normalizedY);
		
		if (res <= 0) {
			return start;
		}
		else if (res >= 1) {
			return end;
		}
		else {
			return RGB.mix(end, start, res);
		}
	}
}
