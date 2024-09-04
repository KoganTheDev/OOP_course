package circuits;

/**
 * Summary:
 * Represents a 2-input OR gate in a circuit that performs a logical OR operation on its two input gates.
 * This class inherits from the OrGate class.
 *
 * Constructors:
 * Or2Gate - Constructs a 2-input OR gate with specified input gates.
 */
public class Or2Gate extends OrGate {

    /**
     * Summary:
     * Constructs a 2-input OR gate with specified input gates.
     *
     * Arguments:
     * @param g1 - (Gate type): The first input gate for the OR gate.
     * @param g2 - (Gate type): The second input gate for the OR gate.
     */
    public Or2Gate(Gate g1, Gate g2) {
        super(new Gate[] {g1, g2});
    }
}
