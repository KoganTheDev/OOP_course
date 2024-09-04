package circuits;

/**
 * Summary:
 * Represents a NOT gate in a circuit, which inverts the input value.
 * This class extends the Gate class and provides the NOT functionality.
 *
 * Fields:
 * gateName - (String type): The name of the gate.
 *
 * Constructors:
 * NotGate - Constructs a NotGate with the specified input gate.
 *
 * Methods:
 * func - Applies the NOT operation on the input value.
 * getName - Returns the name of the gate.
 * simplify - Simplifies the NOT gate based on its input.
 */
public class NotGate extends Gate{
	private String gateName;
	
	 /**
     * Summary:
     * Constructs a NotGate with the specified input gate.
     *
     * Arguments:
     * @param in - (Gate type): The input gate for the NOT gate.
     */
	public NotGate(Gate in) {
		super(new Gate[] {in});
		gateName = "NOT";
	}
	
	  /**
     * Summary:
     * Applies the NOT operation on the input value.
     *
     * Arguments:
     * @param inValues - (boolean[] type): The input values to the gate.
     *
     * Returns:
     * @return - (boolean type): The result of the NOT operation.
     *
     * Throws:
     * @throws CircuitException - If an error occurs during the operation.
     */
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return !inValues[0];
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
		return gateName;
	}
	
	 /**
     * Summary:
     * Simplifies the NOT gate based on its input.
     *
     * Returns:
     * @return - (Gate type): The simplified gate.
     */
	@Override
	public Gate simplify() {
		Gate simplifiedSon = inGates[0].simplify();
		
		if (simplifiedSon.equals(TrueGate.instance())) {
			return FalseGate.instance();
		}
		else if (simplifiedSon.equals(FalseGate.instance())) {
			return TrueGate.instance();
		}
		else {
			return this;
		}
	}
}

