package shop;

/**
 * Enum representing different types of instruments.
 */
public enum Type {
    ACOUSTIC, ELECTRIC, CLASSICAL;

    /**
     * Returns the string representation of the enum constant with the first letter capitalized.
     *
     * @return The formatted string representation of the enum constant.
     */
    @Override
    public String toString() {
        // Get the name of the enum constant
        String name = name().toLowerCase();
        
        // Capitalize the first letter and return the formatted string
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}