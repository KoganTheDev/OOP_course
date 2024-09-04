package shop;

/**
 * Represents a Guitar, which is a type of musical instrument.
 * Extends the Instrument class.
 */
public class Guitar extends Instrument {
	private Type type;
	
	 /**
     * Constructor for creating a Guitar object with specified attributes.
     *
     * @param company The company of the guitar.
     * @param price The price of the guitar.
     * @param type The type of the guitar (e.g., ACOUSTIC, ELECTRIC, CLASSICAL).
     */
	public Guitar(String company, int price, Type type) {
		super(company, price); // Call to superclass constructor to initialize company and price.
		this.type = type;
	}
	
	 /**
     * Retrieves the type of the guitar.
     *
     * @return The type of the guitar (e.g., ACOUSTIC, ELECTRIC, CLASSICAL).
     */
	public Type getType() {
		return type;
	}
	
	 /**
     * Returns a string representation of the Guitar object.
     *
     * @return A string representation of the Guitar object.
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		// This block of code creates a string in this format:
		// i.e "Guitar(Acoustic) Fender(4), price = 3000.
		sb.append("Guitar(");
		sb.append(type);
		sb.append(") ");
		sb.append(getCompany());
		sb.append("(");
		sb.append(getSerial()); // create a serial number getter
		sb.append("), price = ");
		sb.append(getPrice());
		
		return (sb.toString());
	}
}
