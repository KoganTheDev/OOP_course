package circuits;

/**
 * Summary:
 * Represents a variable gate in a circuit with a name, value, and value setting flag.
 * Inherits from the Gate class.
 *
 * Fields:
 * gateName - (String type): The name of the gate.
 * value - (boolean type): The value of the gate.
 * valueSettingFlag - (int type): Flag indicating if the value has been set.
 *
 * Constructors:
 * VarGate - Constructs a variable gate with a specified name.
 *
 * Methods:
 * func - Evaluates the gate's function based on input values.
 * getName - Returns the name of the gate.
 * setVal - Sets the value of the gate and updates the value setting flag.
 * simplify - Simplifies the gate if the value has been set, returning TrueGate or FalseGate as appropriate.
 */
public class VarGate extends Gate{
	private String gateName; 
	private boolean value; 
	private int valueSettingFlag;
	
	  /**
     * Summary:
     * Constructs a variable gate with a specified name.
     *
     * Arguments:
     * @param name - (String type): The name of the gate.
     */
	public VarGate(String name) {
		super(null);
		gateName = name;
	}
	
	/**
     * Summary:
     * Evaluates the gate's function based on input values.
     *
     * Arguments:
     * @param inValues - (boolean[] type): The input values for the gate.
     *
     * Returns:
     * @return - (boolean type): The evaluated result of the gate.
     *
     * Throws:
     * @throws CircuitException - If the value setting flag is not set.
     */
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException{
		if (valueSettingFlag == 0) {
			throw new CircuitException("Circuit exception in VarGate: no value inserted."); 
		}
		else {
			return value;
		}
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
		return "V" + gateName;
	}
	
	  /**
     * Summary:
     * Sets the value of the gate and updates the value setting flag.
     *
     * Arguments:
     * @param value - (boolean type): The value to set for the gate.
     */
	public void setVal(boolean value) {
		valueSettingFlag = 1;
		this.value = value;
	}
	
	 /**
     * Summary:
     * Simplifies the gate if the value has been set, returning TrueGate or FalseGate as appropriate.
     *
     * Returns:
     * @return - (Gate type): The simplified gate.
     */
	@Override
	public Gate simplify() {
		if (valueSettingFlag == 1) { 
			if (value == true) {
				return TrueGate.instance();
			}
			else {
				return FalseGate.instance();
			}
		}
		
		return this;
	}
}
