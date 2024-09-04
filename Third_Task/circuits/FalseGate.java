package circuits;

/**
 * Summary:
 * Represents a False gate that always returns false.
 * Extends the Gate class and implements the specific functionality for a False gate.
 *
 * Fields:
 * gateName - (String type): The name of the False gate.
 *
 * Constructors:
 * FalseGate - Constructs a False gate instance.
 *
 * Methods:
 * func - Overrides the method in Gate to return false unconditionally.
 * getName - Returns the name of the False gate.
 * simplify - Returns the singleton instance of FalseGate to optimize circuit simplification.
 * instance - Static method that provides access to the singleton instance of FalseGate.
 */
public class FalseGate extends Gate {
	private String gateName;

	/**
     * Summary:
     * Constructs a False gate instance.
     */
	private FalseGate() {
		super(null);
		gateName = "F";
	}

	/**
     * Summary:
     * Overrides the method in Gate to return false unconditionally.
     *
     * Arguments:
     * @param inValues - (boolean[] type): The input values (not used in False gate).
     *
     * Returns:
     * @return - (boolean type): Always returns false.
     *
     * Throws:
     * @throws CircuitException - (Not thrown in this implementation).
     */
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException{
		return false;
	}
	
	/**
     * Summary:
     * Returns the name of the False gate.
     *
     * Returns:
     * @return - (String type): The name of the False gate ("F").
     */
	@Override
	public String getName() {
		return gateName;
	}

	/**
     * Summary:
     * Returns the singleton instance of FalseGate to optimize circuit simplification.
     *
     * Returns:
     * @return - (Gate type): The singleton instance of FalseGate.
     */
	@Override
	public Gate simplify() {
		return instance;
	}

	 /**
     * Summary:
     * Static method that provides access to the singleton instance of FalseGate.
     *
     * Returns:
     * @return - (Gate type): The singleton instance of FalseGate.
     */
	private static Gate instance = null;

	public static Gate instance() {
		if (instance == null) {
			instance = new FalseGate();
		}
		return instance;
	}
}
