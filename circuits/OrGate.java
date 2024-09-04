package circuits;

/**
 * Summary:
 * Represents an OR gate in a circuit that performs a logical OR operation on its input gates.
 * This class inherits from the Gate class.
 *
 * Fields:
 * gateName - (String type): The name of the gate.
 *
 * Constructors:
 * OrGate - Constructs an OR gate with specified input gates.
 *
 * Methods:
 * func - Evaluates the OR gate's function by applying a logical OR on all input values.
 * getName - Returns the name of the gate.
 * simplify - Simplifies the OR gate by reducing its input gates.
 */
public class OrGate extends Gate {
	private String gateName;
	
	/**
     * Summary:
     * Constructs an OR gate with specified input gates.
     *
     * Arguments:
     * @param inGates - (Gate[] type): The input gates for the OR gate.
     */
	public OrGate(Gate[] inGates) {
		super(inGates);
		gateName = "OR";
	}
	
    /**
     * Summary:
     * Evaluates the OR gate's function by applying a logical OR on all input values.
     *
     * Arguments:
     * @param inValues - (boolean[] type): The input values for the gate.
     *
     * Returns:
     * @return - (boolean type): The result of the logical OR operation on all input values.
     *
     * Throws:
     * @throws CircuitException - If there is an error in the circuit.
     */
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		boolean result = false;
		// Applies logical "OR" on all of the in values.
		for (int value = 0; value < inValues.length; value++) {
			result = result || inValues[value];
		}
		
		return result;
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
     * Simplifies the OR gate by reducing its input gates.
     *
     * Returns:
     * @return - (Gate type): The simplified gate.
     */
	@Override
	public Gate simplify() {
		Gate[] simplified;
		Gate[] temp = new Gate[inGates.length];
		int falseGatesCounter = 0;
		int i;
		
		// Simplify the gates.
		for(i = 0; i < inGates.length; i++) {
			temp[i] = inGates[i].simplify();
			if(temp[i].equals(TrueGate.instance())) {
				return TrueGate.instance();
			}
			if(temp[i].equals(FalseGate.instance())) {
				falseGatesCounter++;
			}
		}
		// Remove all of the false gates from the array.
		simplified = new Gate[inGates.length - falseGatesCounter];
		int gateIndex = 0;
		
		for (i = 0; i < inGates.length; i++) {
			if(!temp[i].equals(FalseGate.instance())) {
				simplified[gateIndex] = temp[i];
				gateIndex++;
			}
		}
		
		if (simplified.length == 1) {
			return simplified[0].simplify();
		}
		if (simplified.length == 0) {
			return FalseGate.instance();
		}
		
		return new OrGate(simplified);
	}
}

