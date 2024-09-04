package images;

/**
 * Summary:
 * Represents an image decorator that superposes two base images.
 * Extends BinaryImageDecorator.
 *
 * Constructors:
 * Superpose - Constructs a Superpose image decorator with two specified base Image objects.
 *
 * Methods:
 * get - Retrieves the superposed RGB color of a specified pixel from the two base images.
 */
public class Superpose extends BinaryImageDecorator {
	
	  /**
     * Summary:
     * Constructs a Superpose image decorator with two specified base Image objects.
     *
     * Arguments:
     * @param base1 - (Image type): The first base Image object to be superposed.
     * @param base2 - (Image type): The second base Image object to be superposed.
     */
	public Superpose(Image base1, Image base2) {
		super(base1, base2);
	}
	
	/**
     * Summary:
     * Retrieves the superposed RGB color of a specified pixel from the two base images.
     *
     * Arguments:
     * @param x - (int type): The x-coordinate of the pixel.
     * @param y - (int type): The y-coordinate of the pixel.
     *
     * Returns:
     * @return - (RGB type): The superposed RGB color of the specified pixel.
     */
	@Override
	public RGB get(int x, int y) {
		RGB base1Color = base1.get(x, y);
		RGB base2Color = base2.get(x, y);
		int base1Height = base1.getHeight();
		int base2Height = base2.getHeight();
		int base1Width = base1.getWidth();
		int base2Width = base2.getWidth();
		
		if (x <= base1Width && x <= base2Width && y <= base1Height && y <= base2Height) {
			return RGB.superpose(base1Color, base2Color);
		}
		else if (x <= base1Width && x <= base2Width) {
			if (base1Height == getHeight()) {
				return base1Color;
			}
			else {
				return base2Color;
			}
		}
		else if (y <= base1Height && y <= base2Height) {
			if (base1Width == getWidth()) {
				return base1Color;
			}
			else {
				return base2Color;
			}
		}
		return RGB.BLACK;
	}
}
