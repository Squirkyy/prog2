package task1;

import task1.Gates.*;

/**
 * Half-Adder provider that uses a XOR Gate and an AND Gate
 * 
 * @version 4th May 2023
 * @author Darius Vollmer
 */
public class HalfAdder {
    /**
     * Gate array that gets allocated for the 2 gates that it holds
     */
    Gate[] gates = new Gate[2];

    /**
     * Constructor for the Half-Adder.
     * Allocates a XOR Gate to the first place and AND Gate to the second place in
     * the gates array
     */
    public HalfAdder() {
        this.gates[0] = new XORGate();
        this.gates[1] = new AndGate();
    }

    /**
     * Addes two binary digits.
     * If a or b is 0, then it returns both zero.
     * If a Xor b is 1 then it returns the sum as 1 and carry as 0
     * If both are 1 then it returns sum as 0 and carry as 1
     * 
     * @param a first binary digit
     * @param b second binary digit
     * @return a boolean array with [0] being the sum and [1] being the carry
     */
    public boolean[] add(boolean a, boolean b) {
        boolean[] output = new boolean[2];
        output[0] = this.gates[0].evaluate(a, b);
        output[1] = this.gates[1].evaluate(a, b);
        return output;
    }

    /**
     * Prints all the gates in the Gate Array with the truth tables in the standard
     * output
     */
    public void info() {
        for (Gate gate : gates) {
            System.out.println("Truth table for " + gate.getSymbol());
            gate.table();
            System.out.println();
        }
    }
}
