package task1.Gates;

/**
 * NOT-Gate that extends the Gate to evaluate and print a logical expression
 * @author Darius Vollmer
 * @version 4th May 2023
 */
public class NotGate extends Gate {

    /**
     * Constructor that uses the Parent Constructor for setting the operator
     */
    public NotGate() {
        super("NOT");
    }

    /**
     * {@inheritDoc}
     * Uses the NOT operator on {@code a}
     */
    @Override
    public boolean evaluate(boolean a, boolean b) {
        return !a;
    }
}
