package images;

/**
 * Summary:
 * Represents a circular gradient image that transitions smoothly from a center RGB color to an outside RGB color based on distance from the center.
 * Inherits from BaseImage.
 *
 * Constructors:
 * Circle - Constructs a circular gradient image with specified width, height, center coordinates, radius, center RGB color, and outside RGB color.
 * Circle - Constructs a square-shaped circular gradient image with specified size, radius, center RGB color, and outside RGB color.
 *
 * Methods:
 * get - Retrieves the RGB color of a specified pixel in the circular gradient image based on its distance from the center.
 */
public class Circle extends BaseImage {
	private int centerX;
	private int centerY;
	private int radius;
	

	  /**
     * Summary:
     * Constructs a circular gradient image with specified width, height, center coordinates, radius, center RGB color, and outside RGB color.
     *
     * Arguments:
     * @param width - (int type): The width of the circular gradient image.
     * @param height - (int type): The height of the circular gradient image.
     * @param centerX - (int type): The x-coordinate of the center of the circle.
     * @param centerY - (int type): The y-coordinate of the center of the circle.
     * @param radius - (int type): The radius of the circle.
     * @param center - (RGB type): The RGB color at the center of the circle.
     * @param outside - (RGB type): The RGB color outside the circle.
     */
	public Circle(int width, int height, int centerX, int centerY, int radius,
			RGB center, RGB outside) {
		super(width, height, center, outside);
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
	}
	

    /**
     * Summary:
     * Constructs a square-shaped circular gradient image with specified size, radius, center RGB color, and outside RGB color.
     * The center of the circle is automatically set to the middle of the image.
     *
     * Arguments:
     * @param size - (int type): The size (width and height) of the square-shaped circular gradient image.
     * @param radius - (int type): The radius of the circle.
     * @param center - (RGB type): The RGB color at the center of the circle.
     * @param outside - (RGB type): The RGB color outside the circle.
     */
	public Circle(int size, int radius, RGB center, RGB outside) {
		super(size, size, center, outside);
		centerX = size / 2;
		centerY = size / 2;
		this.radius = radius;
	}
	
    /**
     * Summary:
     * Retrieves the RGB color of a specified pixel in the circular gradient image based on its distance from the center.
     *
     * Arguments:
     * @param x - (int type): The x-coordinate of the pixel.
     * @param y - (int type): The y-coordinate of the pixel.
     *
     * Returns:
     * @return - (RGB type): The RGB color of the specified pixel in the circular gradient image.
     *                      Returns the outside RGB color if the pixel is outside the circle.
     *                      Returns a mix of center and outside RGB colors based on the pixel's distance from the center.
     */
	@Override
	public RGB get(int x, int y) {
		if (0 > x || x >= getWidth() || 0 > y || y >= getHeight()) {
			return null;
		}
		
		// The equation calculates the distance from the circle
		double distance = Math.pow(Math.pow((double)(x-centerX),2) + Math.pow((double)(y-centerY), 2), 0.5);
		
		if (distance > radius) {
			return end;
		}
		double alpha = distance / radius;
		
		return RGB.mix(end, start, alpha);
	}
}
