package images;

/**
 * Summary:
 * Abstract class representing a binary image decorator that operates on two base images.
 * Implements the Image interface.
 *
 * Fields:
 * base1 - (Image type): The first base Image object being decorated.
 * base2 - (Image type): The second base Image object being decorated.
 *
 * Constructors:
 * BinaryImageDecorator - Constructs a binary image decorator with two specified base Image objects.
 *
 * Methods:
 * getWidth - Returns the maximum width between the two base images.
 * getHeight - Returns the maximum height between the two base images.
 * get - Abstract method to be implemented by subclasses to retrieve the RGB color of a specified pixel.
 */
public abstract class BinaryImageDecorator implements Image {
	protected Image base1;
	protected Image base2;
	
    /**
     * Summary:
     * Constructs a binary image decorator with two specified base Image objects.
     *
     * Arguments:
     * @param base1 - (Image type): The first base Image object to be decorated.
     * @param base2 - (Image type): The second base Image object to be decorated.
     */
	public BinaryImageDecorator(Image base1, Image base2) {
		this.base1 = base1;
		this.base2 = base2;
	}
	
    /**
     * Summary:
     * Returns the maximum width between the two base images.
     *
     * Returns:
     * @return - (int type): The maximum width of the two base images.
     */
	@Override
	public int getWidth() {
		if (base1.getWidth() > base2.getWidth()) {
			return base1.getWidth();
		}
		else {
			return base2.getWidth();
		}
	}
	
    /**
     * Summary:
     * Returns the maximum height between the two base images.
     *
     * Returns:
     * @return - (int type): The maximum height of the two base images.
     */
	@Override
	public int getHeight() {
		if (base1.getHeight() > base2.getHeight()) {
			return base1.getHeight();
		}
		else {
			return base2.getHeight();
		}
	}
	
    /**
     * Summary:
     * Abstract method to be implemented by subclasses to retrieve the RGB color of a specified pixel.
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
