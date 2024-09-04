package images;

/**
 * Summary:
 * Abstract base class for image decorators that modify or enhance the behavior of an Image object.
 * Implements the Image interface.
 *
 * Fields:
 * base - (Image type): The base Image object being decorated.
 *
 * Constructors:
 * ImageDecorator - Constructs an image decorator with a specified base Image object.
 *
 * Methods:
 * getWidth - Returns the width of the decorated image.
 * getHeight - Returns the height of the decorated image.
 * get - Retrieves the RGB color of a specified pixel in the decorated image.
 */
public abstract class ImageDecorator implements Image {
	
	protected Image base;
	
	  /**
     * Summary:
     * Constructs an image decorator with a specified base Image object.
     *
     * Arguments:
     * @param base - (Image type): The base Image object to be decorated.
     */
	public ImageDecorator(Image base) {
		this.base = base;
	}
	
	   /**
     * Summary:
     * Returns the width of the decorated image.
     *
     * Returns:
     * @return - (int type): The width of the decorated image.
     */
	@Override
	public int getWidth() {
		return base.getWidth();
	}
	
	  /**
     * Summary:
     * Returns the height of the decorated image.
     *
     * Returns:
     * @return - (int type): The height of the decorated image.
     */
	@Override
	public int getHeight() {
		return base.getHeight();
	}
	
	/**
     * Summary:
     * Retrieves the RGB color of a specified pixel in the decorated image.
     * This method is abstract and should be implemented by subclasses.
     *
     * Arguments:
     * @param x - (int type): The x-coordinate of the pixel.
     * @param y - (int type): The y-coordinate of the pixel.
     *
     * Returns:
     * @return - (RGB type): The RGB color of the specified pixel in the decorated image.
     */
	@Override
	public abstract RGB get(int x, int y);
}
