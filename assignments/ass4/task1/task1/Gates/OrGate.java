package task1.Gates;

/**
 * OR-Gate that extends the Gate to evaluate and print a logical expression
 * 
 * @author Darius Vollmer
 * @version 4th May 2023
 */
public class OrGate extends Gate {

    /**
     * Constructor that uses the Parent Constructor for setting the operator
     */
    public OrGate() {
        super("OR");
    }

    /**
     * {@inheritDoc}
     * Uses the OR operator on {@code a | b}
     */
    @Override
    public boolean evaluate(boolean a, boolean b) {
        return (a | b);
    }
}
