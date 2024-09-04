package images;

/**
 * Summary:
 * Represents an image decorator that mixes two base images with a specified alpha value.
 * Extends BinaryImageDecorator.
 *
 * Constructors:
 * Mix - Constructs a Mix image decorator with two specified base Image objects and an alpha value.
 *
 * Methods:
 * get - Retrieves the mixed RGB color of a specified pixel from the two base images with the given alpha value.
 */
public class Mix extends BinaryImageDecorator{
	private double alpha;
	
	/**
     * Summary:
     * Constructs a Mix image decorator with two specified base Image objects and an alpha value.
     *
     * Arguments:
     * @param base1 - (Image type): The first base Image object to be mixed.
     * @param base2 - (Image type): The second base Image object to be mixed.
     * @param alpha - (double type): The mixing ratio (alpha) between the two images.
     */
	public Mix(Image base1, Image base2, double alpha) {
		super(base1, base2);
		this.alpha = alpha;
	}
	
	 /**
     * Summary:
     * Retrieves the mixed RGB color of a specified pixel from the two base images with the given alpha value.
     *
     * Arguments:
     * @param x - (int type): The x-coordinate of the pixel.
     * @param y - (int type): The y-coordinate of the pixel.
     *
     * Returns:
     * @return - (RGB type): The mixed RGB color of the specified pixel.
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
			return RGB.mix(base1Color, base2Color, alpha);
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
