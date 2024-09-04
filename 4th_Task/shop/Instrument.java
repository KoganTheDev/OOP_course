package shop;

/**
 * Abstract class representing a musical instrument.
 * This class serves as a blueprint for specific types of instruments.
 */
public abstract class Instrument {
	private static int LastserialNumber = 0; 
	
	protected String company;
	protected int price;
	protected int serialNumber;
	
	/**
     * Constructor for creating an Instrument object with specified attributes.
     *
     * @param company The company or brand of the instrument.
     * @param price The price of the instrument.
     */
	public Instrument(String company, int price) {
		this.company = company;
		this.price = price;
		serialNumber = LastserialNumber++; // Gives a unique value for each instance of an object. 
	}
	
	/**
     * Retrieves the price of the instrument.
     *
     * @return The price of the instrument.
     */
	public int getPrice() {
		return price;
	}

	/**
     * Retrieves the serial number of the instrument.
     *
     * @return The serial number of the instrument.
     */
	public int getSerial() {
		return serialNumber;
	}
	
	/**
     * Retrieves the company of the instrument.
     *
     * @return The company or brand of the instrument.
     */
	public String getCompany() {
		return company;
	}
	
	 /**
     * Abstract method that subclasses must implement to provide a string representation of the instrument.
     *
     * @return A string representation of the instrument.
     */
	public abstract String toString();
}
