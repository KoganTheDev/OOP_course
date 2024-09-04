package cities;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * Represents a country with a name and a set of cities.
 * Implements Comparable to allow comparison by country name.
 */
public class Country implements Comparable<Country> {
	private String name;
	private Set<City> cities;
	
	/**
     * Constructs a Country with the specified name.
     * Initializes the cities set.
     * 
     * @param name the name of the country
     */
	public Country(String name) {
		this.name = name;
		this.cities = new TreeSet<>();
	}
	
	/**
     * Adds a city to the country's set of cities.
     * 
     * @param city the city to add
     * @throws IllegalArgumentException if the city's country does not match this country
     */
	public void addCity(City city) {
		if (!city.getCountry().toString().equals(this.toString())) { // Check if the name of the city`s country is the same
			throw new IllegalArgumentException();
		}
		// Check if the city is already in the set, if so, don`t add it.
		for (City cityInCities : cities) {
			if (cityInCities.compareTo(city) == 0) {
				return; // We found a city that has the same name so there`s no need to add it.
			}
		}
		cities.add(city);
	}
	
	/**
     * Returns the total population of the country.
     * 
     * @return the total population of the country
     */
	public int population() {
		int totalPopulation = 0;
		
		for (City city : cities) {
			totalPopulation += city.getPopulation();
		}
		
		return totalPopulation;
	}
	
	/**
     * Returns a string representation of the country.
     * 
     * @return the name of the country
     */
	@Override
	public String toString() {
		return name;
	}
	
	/**
     * Returns a list of cities in the country with a population less than the specified value.
     * The list is sorted by city name.
     * 
     * @param under the population threshold
     * @return a sorted list of cities with population less than the specified value
     */
	public List<City> smallCities(int under){
		List <City> sortedCities = new ArrayList<>();
		
		for (City city : cities) {
			if (city.getPopulation() < under) {
				sortedCities.add(city);
			}
		}
			
		// Sort the cities by name.
		Collections.sort(sortedCities);
		
		return sortedCities;
	}
	
	/**
     * Returns a detailed report of the country, including its name, total population, and a sorted list of cities.
     * 
     * @return a detailed report of the country
     */
	public String report() {
	    StringBuilder sb = new StringBuilder();
	    
	    // Create a list from the city`s set
	    // Create a list from the cities set
        List<City> sortedCities = new ArrayList<>(cities);
	    
	    // Sort the cities by name.
	    Collections.sort(sortedCities);
	    
	    // Country's clause.
	    sb.append(toString());
	    sb.append("(");
	    sb.append(population());
	    sb.append(") : ");

	    // Cities clause - add the different cities to the string.
	    int cityCount = 0;
	    int totalCities = cities.size();

	    for (City city : sortedCities) {
	        sb.append(city.getName());
	        sb.append("(");
	        sb.append(city.getPopulation());
	        sb.append(")");

	        // Add comma if not the last city
	        cityCount++;
	        if (cityCount < totalCities) {
	            sb.append(", ");
	        }
	    }

	    return sb.toString();
	}	
	
	/**
     * Indicates whether some other object is "equal to" this one.
     * Two countries are considered equal if they have the same name.
     * 
     * @param o the reference object with which to compare
     * @return true if this object is the same as the o argument, false otherwise
     */
	 @Override
	 public boolean equals(Object o) {
		 if (this == o) {
			 return true;
	     }
	     if (o == null || getClass() != o.getClass()) {
	    	 return false;
	     }
	     Country country = (Country) o;
	     return name.equals(country.name);
	 }
	 
	 /**
	 * Compares this country with the specified country for order.
     * Returns a negative integer, zero, or a positive integer as this country's
	 * name is less than, equal to, or greater than the specified country's name.
	 * 
	 * @param other the country to be compared
	 * @return a negative integer, zero, or a positive integer as this country's
	 *         name is less than, equal to, or greater than the specified country's name
	 */
	 @Override
	 public int compareTo(Country other) {
		 return this.name.compareTo(other.name);
	 }
}
 