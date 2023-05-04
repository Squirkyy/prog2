package task1.Gates;

/**
 * SuperClass of a generic Gate
 * 
 * @version 4th May 2023
 * @author Darius Vollmer
 */
public class Gate {
    /**
     * Symbol of the logic operator that the Gate is supposed to be
     */
    String symbol;
    /**
     * bit possibilities which are helpers for a for-each loop
     */
    int[] bits = { 0, 1 };

    /**
     * Constructur for a generic Gate
     * 
     * @param operator of the child gate
     */
    protected Gate(String operator) {
        this.symbol = operator;
    }

    /**
     * Getter for the Symbol
     * 
     * @return the Symbol of the Gate
     */
    public String getSymbol() {
        return this.symbol;
    }

    /**
     * Evaluates a logical expression
     * 
     * @param a first operand
     * @param b second operand
     * @return the operand a and b connected with the symbol of the class
     */
    public boolean evaluate(boolean a, boolean b) {
        return false;
    }

    /**
     * Prints a truth table based on the symbol to the command line
     */
    public void table() {
        StringBuilder sb = new StringBuilder();
        sb.append("|A|");
        sb.append("");
        sb.append("|B|");
        sb.append("");
        sb.append("|A ");
        sb.append(symbol);
        sb.append(" B|");
        sb.append("\n");
        int width = sb.length() - 1;
        for (int i = 0; i < width; i++) {
            sb.append("-");
        }
        sb.append("\n");
        for (int a : bits) {
            for (int b : bits) {
                sb.append("|" + a + "|");
                sb.append("|" + b + "|");
                sb.append("|  " + (evaluate((a != 0), b != 0) ? 1 : 0) + "   |");
                sb.append("\n");
            }
        }
        for (int i = 0; i < width; i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }
}