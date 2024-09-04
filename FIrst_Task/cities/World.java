package cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a world containing a map of countries.
 */
public class World {
	private Map<String, Country> countries = new HashMap<>();
	
	/**
     * Adds a new country to the world.
     * 
     * @param name the name of the country to add
     */
	public void addCountry(String name) {
		Country country = new Country(name);
		countries.put(name, country);
	}
	
	/**
     * Adds a new city to an existing country in the world.
     * 
     * @param name the name of the city to add
     * @param countryName the name of the country the city belongs to
     * @param population the population of the city
     * @throws IllegalArgumentException if the country does not exist in the world
     */
	public void addCity(String name, String countryName, int population) throws IllegalArgumentException{
		Country country = countries.get(countryName); // find the country the city belongs to if it exists.0
		
		if (country == null) {
			throw new IllegalArgumentException();
		}
		
		City city = new City(name, country, population);
		country.addCity(city);
	}
	
	/**
     * Returns the total population of all countries in the world.
     * 
     * @return the total population of the world
     */
	public int population() {
		int totalPopulation = 0;
		
		for (Country country : countries.values()) {
			totalPopulation += country.population();
		}
		
		return totalPopulation;
	}
	
	/**
     * Returns a list of cities with a population less than the specified value from all countries.
     * 
     * @param under the population threshold
     * @return a list of cities with population less than the specified value
     */
	public List<City> smallCities(int under){
		List <City> sortedCities = new ArrayList<>();
	
		for (Country country : countries.values()) {
			List <City> citiesFromCountry = country.smallCities(under);
			for (City city : citiesFromCountry) {
				sortedCities.add(city);
			}
		}
		
		return sortedCities;
	}
	
	/**
     * Returns a detailed report of the world, including each country's report and the total population.
     * 
     * @return a detailed report of the world
     */
	public String report() {
		StringBuilder sb = new StringBuilder();
		int countryCount = 0;
		int totalCountries = countries.size();
		
		
		for (Country country : countries.values()) {
			sb.append(country.report());
			
			countryCount++;
			if (countryCount < totalCountries) {
				sb.append("\n");
			}
		}
		
		sb.append("\nTotal population is ");
		sb.append(population());
		sb.append("\n");
		
		return (sb.toString());
	}
}
