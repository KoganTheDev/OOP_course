package cities;

/**
 * Summary:
 * Represents a city with a name and a list of roads connecting it to other cities.
 *
 * Fields:
 * name - (String type): The name of the city.
 * arr - (Road array type): An array to store the roads connected to the city.
 */
public class City {
	private String name;
	private Road[] arr;

	  /**
     * Summary:
     * Initializes an array to store the roads connected to the city.
     *
     * Returns:
     * @return - (Road array type): An array initialized to hold 10 Road objects.
     */
	private Road[] roads(){ 
		arr = new Road[10];
		return arr;
	}
	
	  /**
     * Summary:
     * Counts the number of roads connected to the city.
     *
     * Returns:
     * @return - (int type): The number of roads connected to the city.
     */
	private int numRoads() {
		int i;
		int counter = 0;
		for (i=0;i<arr.length;i++) {
			if (arr[i] != null) { 
				counter++;
			}
		}
		return counter;
	}
	
	/**
     * Summary:
     * Constructs a City object with the specified name.
     *
     * Arguments:
     * @param name - (String type): The name of the city.
     */
	public City(String name) {
		this.name = name;
		arr = this.roads();
	}
	
	 /**
     * Summary:
     * Connects a road to the city.
     *
     * Arguments:
     * @param r - (Road type): The road to be connected to the city.
     */
	public void connect(Road r) {
		int i;
		for (i=0;i<arr.length;i++) {
			if (arr[i] == null) {
				arr[i] = r;
			}
		}
	}
	
	/**
     * Summary:
     * Finds the nearest city connected by a road.
     *
     * Returns:
     * @return - (City type): The nearest city connected by a road, or null if no roads are connected.
     */
	public City nearestCity() { 
		int i, shortestLength = -1; 
		City nearestCity = null; 
		
		for (i=0;i<this.numRoads();i++)
			if (nearestCity == null && shortestLength == -1 && arr[i] != null) { // Once you encounter the first object in the array, enter the name of the city and the distance between the cities.
				if (arr[i].getCity1() == this) {
					nearestCity = arr[i].getCity2();
				}
				else {
					nearestCity = arr[i].getCity1();
				}
				shortestLength = arr[i].getLength();
			}
			else if (arr[i] != null){ // Check if there`s a city from which the distance is smaller.
				if (arr[i].getLength() < shortestLength) {
					if (arr[i].getCity1() == this) {
						nearestCity = arr[i].getCity2();
					}
					else {
						nearestCity = arr[i].getCity1();
					}
					shortestLength = arr[i].getLength();
				}
			}
		
		if (shortestLength > 0) {
			return nearestCity;
		}
		return null;
	}
	
	/**
	 * Summary:
	 * This functions returns the object`s name.
	 * 
	 * @return - (String type) - the name of the city.
	 */
	public String toString() {
		return name;
	}
}
