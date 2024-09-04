package shop;

/**
 * Represents a Piano, which is a type of musical instrument.
 * Extends the abstract class Instrument.
 */
public class Piano extends Instrument {
	private int octaves; // The number of octaves the piano has.
	
	/**
     * Constructor for creating a Piano object with specified attributes.
     *
     * @param company The company or brand of the piano.
     * @param price The price of the piano.
     * @param octaves The number of octaves the piano has.
     */
	public Piano(String company, int price, int octaves) {
		super(company, price);
		this.octaves = octaves;
	}
	
	/**
     * Retrieves the number of octaves of the piano.
     *
     * @return The number of octaves of the piano.
     */
	public int getOctaves() {
		return octaves;
	}
	
	 /**
     * Returns a string representation of the Piano object.
     *
     * @return A string representation of the Piano object.
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		// This block of code creates a string in this format:
		// i.e "Piano(7 octaves) Yamaha(1), price = 5000
		sb.append("Piano(");
		sb.append(octaves);
		sb.append(" octaves) ");
		sb.append(getCompany());
		sb.append("(");
		sb.append(getSerial()); 
		sb.append("), price = ");
		sb.append(getPrice());
		
		return (sb.toString());
	}
}
