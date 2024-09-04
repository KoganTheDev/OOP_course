package images;

/**
 * Summary:
 * Provides a base implementation for an image with width, height, and initial and final RGB colors.
 * This class is abstract and implements the Image interface.
 *
 * Fields:
 * width - (int type): The width of the image.
 * height - (int type): The height of the image.
 * start - (RGB type): The starting RGB color of the image.
 * end - (RGB type): The ending RGB color of the image.
 *
 * Constructors:
 * BaseImage - Constructs a base image with specified width, height, start RGB color, and end RGB color.
 *
 * Methods:
 * getWidth - Returns the width of the image.
 * getHeight - Returns the height of the image.
 * get - Retrieves the RGB color of a specified pixel.
 */
public abstract class BaseImage implements Image {
	protected int width;
	protected int height;
	protected RGB start;
	protected RGB end;
	
    /**
     * Summary:
     * Constructs a base image with specified width, height, start RGB color, and end RGB color.
     *
     * Arguments:
     * @param width - (int type): The width of the image.
     * @param height - (int type): The height of the image.
     * @param start - (RGB type): The starting RGB color of the image.
     * @param end - (RGB type): The ending RGB color of the image.
     */
	public BaseImage(int width, int height, RGB start, RGB end) {
		this.width = width;
		this.height = height;
		this.start = start;
		this.end = end;
	}
	
	/**
     * Summary:
     * Returns the width of the image.
     *
     * Returns:
     * @return - (int type): The width of the image.
     */
	@Override
	public int getWidth() {
		return width;
	}
	
	/**
     * Summary:
     * Returns the height of the image.
     *
     * Returns:
     * @return - (int type): The height of the image.
     */
	@Override
	public int getHeight() {
		return height;
	}
	
	 /**
     * Summary:
     * Retrieves the RGB color of a specified pixel.
     *
     * Arguments:
     * @param x - (int type): The x-coordinate of the pixel.
     * @param y - (int type): The y-coordinate of the pixel.
     *
     * Returns:
     * @return - (RGB type): The RGB color of the specified pixel.
     */
	@Override
	public abstract RGB get(int x, int y);
}
