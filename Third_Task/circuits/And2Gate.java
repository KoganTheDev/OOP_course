package circuits;

/**
 * Summary:
 * Represents a 2-input AND gate in a circuit that performs a logical AND operation on its two input gates.
 * This class inherits from the AndGate class.
 *
 * Constructors:
 * And2Gate - Constructs a 2-input AND gate with specified input gates.
 */
public class And2Gate extends AndGate {

    /**
     * Summary:
     * Constructs a 2-input AND gate with specified input gates.
     *
     * Arguments:
     * @param g1 - (Gate type): The first input gate for the AND gate.
     * @param g2 - (Gate type): The second input gate for the AND gate.
     */
    public And2Gate(Gate g1, Gate g2) {
        super(new Gate[] {g1, g2});
    }
}
