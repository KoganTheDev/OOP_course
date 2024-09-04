package circuits;

/**
 * Summary:
 * Represents an abstract base class for all gate types in a circuit.
 * This class provides a common structure and behavior for all gates, including input gates, 
 * calculation, and simplification.
 *
 * Fields:
 * inGates - (Gate[] type): An array of input gates for this gate.
 *
 * Constructors:
 * Gate - Constructs a gate with the specified array of input gates.
 *
 * Methods:
 * calc - Calculates the output of the gate based on its input gates.
 * func - Abstract method that performs the gate-specific logic.
 * getName - Abstract method that returns the name of the gate.
 * simplify - Abstract method that simplifies the gate.
 * toString - Returns a string representation of the gate and its input gates.
 */
public abstract class Gate {
	protected Gate[] inGates;
	
	/**
     * Summary:
     * Constructs a gate with the specified array of input gates.
     *
     * Arguments:
     * @param inGates - (Gate[] type): The array of input gates.
     */
	public Gate(Gate[] inGates) {
		this.inGates = inGates;
	}
	
	/**
     * Summary:
     * Calculates the output of the gate based on its input gates.
     *
     * Returns:
     * @return - (boolean type): The output of the gate.
     *
     * Throws:
     * @throws CircuitException - If an error occurs during the calculation.
     */
	public boolean calc() throws CircuitException{
		if (inGates == null) {
			return this.func(null);
		}
		
		boolean[] values = new boolean[inGates.length];
		
		for (int i = 0; i < inGates.length; i++) {
			values[i] = inGates[i].calc();
		}
		
		return func(values);
	}
	
	  /**
     * Summary:
     * Abstract method that performs the gate-specific logic.
     *
     * Arguments:
     * @param inValues - (boolean[] type): The input values to the gate.
     *
     * Returns:
     * @return - (boolean type): The result of the gate-specific logic.
     *
     * Throws:
     * @throws CircuitException - If an error occurs during the operation.
     */
	protected abstract boolean func(boolean[] inValues) throws CircuitException;
	
	/**
     * Summary:
     * Abstract method that returns the name of the gate.
     *
     * Returns:
     * @return - (String type): The name of the gate.
     */
	public abstract String getName();
	
	/**
     * Summary:
     * Abstract method that simplifies the gate.
     *
     * Returns:
     * @return - (Gate type): The simplified gate.
     */
	public abstract Gate simplify();
	
	/**
     * Summary:
     * Returns a string representation of the gate and its input gates.
     *
     * Returns:
     * @return - (String type): The string representation of the gate.
     */
	public String toString() {
		StringBuilder sb = new StringBuilder(getName());
		
		if (inGates == null) {
			return getName();
		}
		
		for (int i = 0; i < inGates.length; i++) {
			if (i == 0) {
				sb.append("[");
			}
			
			if (inGates[i] != null) {
				sb.append(inGates[i].toString());
			}
			
			if (i < (inGates.length - 1)) {
				sb.append(", ");
			}
			
			if (i == (inGates.length - 1)) {
				sb.append("]");
			}
		}
		
		return sb.toString();
	}
}
