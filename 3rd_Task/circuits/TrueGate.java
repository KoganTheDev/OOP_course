package circuits;

/**
 * Summary:
 * Represents a true gate in a circuit that always evaluates to true.
 * This class is a singleton and inherits from the Gate class.
 *
 * Fields:
 * gateName - (String type): The name of the gate.
 * instance - (Gate type): The singleton instance of TrueGate.
 *
 * Constructors:
 * TrueGate - Private constructor to enforce singleton pattern.
 *
 * Methods:
 * func - Evaluates the gate's function, always returning true.
 * getName - Returns the name of the gate.
 * simplify - Returns the singleton instance of TrueGate.
 * instance - Returns the singleton instance of TrueGate, creating it if necessary.
 */
public class TrueGate extends Gate {
	private String gateName;

	 /**
     * Summary:
     * Private constructor to enforce singleton pattern.
     */
	private TrueGate() {
		super(null);
		gateName = "T";
	}

	 /**
     * Summary:
     * Evaluates the gate's function, always returning true.
     *
     * Arguments:
     * @param inValues - (boolean[] type): The input values for the gate.
     *
     * Returns:
     * @return - (boolean type): Always returns true.
     *
     * Throws:
     * @throws CircuitException - This method does not throw any exceptions.
     */
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return true;
	}

	/**
     * Summary:
     * Returns the name of the gate.
     *
     * Returns:
     * @return - (String type): The name of the gate.
     */
	@Override
	public String getName() {
		return (gateName);
	}

	/**
     * Summary:
     * Returns the singleton instance of TrueGate.
     *
     * Returns:
     * @return - (Gate type): The singleton instance of TrueGate.
     */
	@Override
	public Gate simplify() {
		return instance;
	}
	/**
	 * Summary:
	 * Returns the singleton instance of TrueGate, creating it if necessary.
	 *
	 * Returns:
	 * @return - (Gate type): The singleton instance of TrueGate.
	 */
	private static Gate instance = null;

	public static Gate instance() {
		if (instance == null) {
			instance = new TrueGate();
		}
		return instance;
	}
}
