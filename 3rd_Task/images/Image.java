package images;

/**
 * Summary:
 * Represents a generic image with width, height, and the ability to get the color of a specific pixel.
 *
 * Methods:
 * getWidth - Returns the width of the image.
 * getHeight - Returns the height of the image.
 * get - Returns the RGB color of a specified pixel.
 */
public interface Image {
    /**
     * Summary:
     * Returns the width of the image.
     *
     * Returns:
     * @return - (int type): The width of the image.
     */
    public int getWidth();

    /**
     * Summary:
     * Returns the height of the image.
     *
     * Returns:
     * @return - (int type): The height of the image.
     */
    public int getHeight();

    /**
     * Summary:
     * Returns the RGB color of a specified pixel.
     *
     * Arguments:
     * @param x - (int type): The x-coordinate of the pixel.
     * @param y - (int type): The y-coordinate of the pixel.
     *
     * Returns:
     * @return - (RGB type): The RGB color of the specified pixel.
     */
    public RGB get(int x, int y);
}