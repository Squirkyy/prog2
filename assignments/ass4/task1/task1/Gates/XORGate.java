package task1.Gates;

/**
 * XOR-Gate that extends the Gate to evaluate and print a logical expression
 * 
 * @author Darius Vollmer
 * @version 4th May 2023
 */
public class XORGate extends Gate {

    /**
     * Constructor that uses the Parent Constructor for setting the operator
     */
    public XORGate() {
        super("XOR");
    }

    /**
     * {@inheritDoc}
     * Uses the XOR operator on {@code a & b}
     */
    @Override
    public boolean evaluate(boolean a, boolean b) {
        OrGate or = new OrGate();
        AndGate and = new AndGate();
        NotGate not = new NotGate();
        boolean AandNotB = and.evaluate(a, not.evaluate(b, a));
        boolean NotAandB = and.evaluate(not.evaluate(a, b), b);
        return (or.evaluate(AandNotB, NotAandB));
    }
}
