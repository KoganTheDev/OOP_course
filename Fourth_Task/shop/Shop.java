package shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a music shop that manages instruments.
 */
public class Shop {
    private ArrayList<Instrument> instruments = new ArrayList<>();

    /**
     * Adds an instrument to the shop.
     *
     * @param i The instrument to add.
     */
    public void add(Instrument i) {
        instruments.add(i);
    }

    /**
     * Retrieves an instrument from the shop based on its serial number.
     *
     * @param serial The serial number of the instrument to retrieve.
     * @return The instrument with the specified serial number, or null if not found.
     */
    public Instrument get(int serial) {
    	for (Instrument instrument : instruments) {
    		if (instrument.getSerial() == serial) {
    			return instrument;
    		}
    	}
    	
    	// No instrument with the same serial number was found.
    	return null;
    }
    
    /**
     * Retrieves a list of all serial numbers of instruments in the shop.
     *
     * @return A list containing all serial numbers of instruments in the shop.
     */
    public List<Integer> allSerials(){
    	List<Integer> serials = new ArrayList<>();
    	
    	// Grabs all of serial numbers and add them to the serials List.
    	for (Instrument instrument : instruments) {
    		serials.add(instrument.getSerial());
    	}
    	
    	return (serials);
    }
    
    /**
     * Retrieves a list of serial numbers of guitars in the shop that match a specified type.
     *
     * @param t The type of guitars to filter by.
     * @return A list of serial numbers of guitars that match the specified type.
     */
    public List<Integer> guitarsOfType(Type t){
    	List<Integer> guitarSerialNumbersWithSameType = new ArrayList<>();
    	
    	// Grab all of the serial numbers of guitars that are made of the same type.
    	for (Instrument instrument : instruments) {
    		if (instrument instanceof Guitar) {
    			Guitar guitar = (Guitar) instrument;
    			if (guitar.getType().equals(t)) {
    				guitarSerialNumbersWithSameType.add(guitar.getSerial()); // Insert the serial number of the relevant guitar of the same type
    			}
    		}
    	}
    	
    	return guitarSerialNumbersWithSameType;
	}
    
    /**
     * Sells an instrument from the shop based on its serial number.
     *
     * @param serial The serial number of the instrument to sell.
     * @throws MusicShopException If the instrument cannot be sold (e.g., sentimental value, not in stock).
     */
    public void sell(int serial) throws MusicShopException {
    	int currentAmountOfGuitars = 0;
    	
    	// Used to check how many guitars are in the shop currently.
    	for (Instrument instrument : instruments) {
    		if (instrument instanceof Guitar) {
    			currentAmountOfGuitars++;
    		}
    	}
    	
    	for (Instrument instrument : instruments) {
    		if (instrument.getSerial() == serial) {
    			if ((instrument instanceof Guitar)) { 
    				if (currentAmountOfGuitars <= 1) { // Check if there`re enough guitars to sale.
    					throw new MusicShopException("Sorry dude, this guitar is not for sale.\nIt has sentiment value for me.\n");
    				}
   					else {
        				instruments.remove(instrument);
        				currentAmountOfGuitars--; // Update the amount of guitars currently in the shop.
        			}
    			}
    			else {
    				instruments.remove(instrument);
    			}
    			return;
    		}
    	}
    	
    	// If instrument with the specified serial number is not found, throw an exception.
    	throw new MusicShopException("This intrument doesn`t exist in the store.\n");
    }
    
    /**
     * Sells multiple instruments from the shop based on their serial numbers.
     *
     * @param serials An array of serial numbers of instruments to sell.
     * @return The number of instruments that could not be sold.
     */
    public int sellAll(int[] serials) {
    	int unsoldItems = 0; // Used to store the price in case the instrument can be sold.
    	
    	
    	for (int serialnumber : serials) {
    		try {
    			sell(serialnumber);
    		}
    		catch (MusicShopException e) {
    			unsoldItems++;
    		}
    	}
    	
    	return unsoldItems;
    }
}

