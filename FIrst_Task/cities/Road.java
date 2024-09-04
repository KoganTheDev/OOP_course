package cities;

/**
 * Summary:
 * Represents a road connecting two cities with a specified length.
 *
 * Fields:
 * city1 - (City type): The first city connected by the road.
 * city2 - (City type): The second city connected by the road.
 * length - (int type): The length of the road.
 */
public class Road {
	private City city1, city2;
	private int length;
	
	  /**
     * Summary:
     * Constructs a Road object connecting two cities with the specified length.
     * Also connects the road to both cities.
     *
     * Arguments:
     * @param city1 - (City type): The first city connected by the road.
     * @param city2 - (City type): The second city connected by the road.
     * @param length - (int type): The length of the road.
     */
	public Road(City city1, City city2,int length) {
		this.city1 = city1;
		this.city2 = city2;
		this.length = length;
		
		city1.connect(this); 
		city2.connect(this);
	}
	
	/**
     * Summary:
     * Returns the first city connected by the road.
     *
     * Returns:
     * @return - (City type): The first city connected by the road.
     */
	public City getCity1(){
		return city1;
	}
	
	/**
     * Summary:
     * Returns the second city connected by the road.
     *
     * Returns:
     * @return - (City type): The second city connected by the road.
     */
	public City getCity2() {
		return city2;
	}
	
	  /**
     * Summary:
     * Returns the length of the road.
     *
     * Returns:
     * @return - (int type): The length of the road.
     */
	public int getLength() {
		return length;
	}
}


