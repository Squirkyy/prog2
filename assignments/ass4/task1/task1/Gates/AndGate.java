package task1.Gates;

/**
 * AND-Gate that extends the Gate to evaluate and print a logical expression
 * 
 * @author Darius Vollmer
 * @version 4th May 2023
 */
public class AndGate extends Gate {

    /**
     * Constructor that uses the Parent Constructor for setting the operator
     */
    public AndGate() {
        super("AND");
    }

    /**
     * {@inheritDoc}
     * Uses the AND operator on {@code a & b}
     */
    @Override
    public boolean evaluate(boolean a, boolean b) {
        return (a & b);
    }
}
