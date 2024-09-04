package images;

/**
 * Summary:
 * Image decorator that inverts the RGB colors of each pixel in the base image.
 * Extends ImageDecorator.
 *
 * Fields:
 * base - (Image type): The base Image object being decorated.
 *
 * Constructors:
 * Invert - Constructs an invert decorator with a specified base Image object.
 *
 * Methods:
 * get - Retrieves the RGB color of a specified pixel in the decorated image after inverting the colors.
 */
public class Invert extends ImageDecorator {
	
    /**
     * Summary:
     * Constructs an invert decorator with a specified base Image object.
     *
     * Arguments:
     * @param base - (Image type): The base Image object to be decorated.
     */
	public Invert(Image base) {
		super(base);
	}
	
    /**
     * Summary:
     * Retrieves the RGB color of a specified pixel in the decorated image after inverting the colors.
     *
     * Arguments:
     * @param x - (int type): The x-coordinate of the pixel.
     * @param y - (int type): The y-coordinate of the pixel.
     *
     * Returns:
     * @return - (RGB type): The RGB color of the specified pixel in the decorated image after inverting the colors.
     */
	@Override
	public RGB get(int x, int y) {
		return base.get(x, y).invert();
	}
}
