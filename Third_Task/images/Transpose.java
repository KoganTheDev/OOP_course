package images;

/**
 * Summary:
 * Image decorator that transposes the coordinates of each pixel in the base image.
 * Extends ImageDecorator.
 *
 * Fields:
 * base - (Image type): The base Image object being decorated.
 *
 * Constructors:
 * Transpose - Constructs a transpose decorator with a specified base Image object.
 *
 * Methods:
 * get - Retrieves the RGB color of a specified pixel in the decorated image after transposing the coordinates.
 * getWidth - Returns the height of the base image as the width of the transposed image.
 * getHeight - Returns the width of the base image as the height of the transposed image.
 */
public class Transpose extends ImageDecorator {

    /**
     * Summary:
     * Constructs a transpose decorator with a specified base Image object.
     *
     * Arguments:
     * @param base - (Image type): The base Image object to be decorated.
     */
	public Transpose(Image base) {
		super(base);
	}
	
    /**
     * Summary:
     * Retrieves the RGB color of a specified pixel in the decorated image after transposing the coordinates.
     *
     * Arguments:
     * @param x - (int type): The x-coordinate of the pixel in the transposed image.
     * @param y - (int type): The y-coordinate of the pixel in the transposed image.
     *
     * Returns:
     * @return - (RGB type): The RGB color of the specified pixel in the transposed image.
     */
	@Override
	public RGB get(int x, int y) {
		return base.get(y, x); 
	}
	
    /**
     * Summary:
     * Returns the height of the base image as the width of the transposed image.
     *
     * Returns:
     * @return - (int type): The width of the transposed image.
     */
	@Override
	public int getWidth() {
		return base.getHeight();
	}
	
    /**
     * Summary:
     * Returns the width of the base image as the height of the transposed image.
     *
     * Returns:
     * @return - (int type): The height of the transposed image.
     */
	@Override
	public int getHeight() {
		return base.getWidth();
	}
}
