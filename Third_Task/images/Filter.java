package images;

/**
 * Summary:
 * Image decorator that applies a filter to modify the RGB color of each pixel in the base image.
 * Extends ImageDecorator.
 *
 * Fields:
 * filter - (RGB type): The RGB color used as a filter to modify the base image pixels.
 * base - (Image type): The base Image object being decorated.
 *
 * Constructors:
 * Filter - Constructs a filter decorator with a specified base Image object and RGB filter.
 *
 * Methods:
 * get - Retrieves the RGB color of a specified pixel in the decorated image after applying the filter.
 */
public class Filter extends ImageDecorator {
	
	private RGB filter;
	
    /**
     * Summary:
     * Constructs a filter decorator with a specified base Image object and RGB filter.
     *
     * Arguments:
     * @param base - (Image type): The base Image object to be decorated.
     * @param filter - (RGB type): The RGB color used as a filter to modify the base image pixels.
     */
	public Filter(Image base, RGB filter) {
		super(base);
		this.filter = filter;
	}
	
    /**
     * Summary:
     * Retrieves the RGB color of a specified pixel in the decorated image after applying the filter.
     *
     * Arguments:
     * @param x - (int type): The x-coordinate of the pixel.
     * @param y - (int type): The y-coordinate of the pixel.
     *
     * Returns:
     * @return - (RGB type): The RGB color of the specified pixel in the decorated image after applying the filter.
     */
	@Override
	public RGB get(int x, int y) {
		return base.get(x, y).filter(filter);
	}
}
