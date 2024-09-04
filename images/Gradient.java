package images;

/**
 * Summary:
 * Represents a gradient image that transitions smoothly from a start RGB color to an end RGB color horizontally.
 * Inherits from BaseImage.
 *
 * Constructors:
 * Gradient - Constructs a gradient image with specified width, height, start RGB color, and end RGB color.
 *
 * Methods:
 * get - Retrieves the RGB color of a specified pixel in the gradient image.
 */
public class Gradient extends BaseImage{
	
	 /**
     * Summary:
     * Constructs a gradient image with specified width, height, start RGB color, and end RGB color.
     *
     * Arguments:
     * @param width - (int type): The width of the gradient image.
     * @param height - (int type): The height of the gradient image.
     * @param start - (RGB type): The starting RGB color of the gradient.
     * @param end - (RGB type): The ending RGB color of the gradient.
     */
	public Gradient(int width, int height, RGB start, RGB end) {
		super(width, height, start, end);
	}
	
	 /**
     * Summary:
     * Retrieves the RGB color of a specified pixel in the gradient image.
     *
     * Arguments:
     * @param x - (int type): The x-coordinate of the pixel.
     * @param y - (int type): The y-coordinate of the pixel.
     *
     * Returns:
     * @return - (RGB type): The RGB color of the specified pixel in the gradient image.
     *                      Returns null if the coordinates are outside the image boundaries.
     */
	@Override
	public RGB get(int x, int y) {
		if (0 > x || x >= getWidth() || 0 > y || y >= getHeight()) {
			return null;
		}
		
		double red = start.getRed() + x*(end.getRed() - start.getRed()) / width;
		double green = start.getGreen() + x*(end.getGreen() - start.getGreen()) / width;
		double blue = start.getBlue() + x*(end.getBlue() - start.getBlue()) / width;
		RGB currentColor = new RGB(red, green, blue);
		
		return currentColor;
	}
}
