package task1.state;

import task1.Action;

/**
 * Implementation of the State for the Muskethill
 * 
 * @author Darius Vollmer
 * @version 11th May 2023
 */
public class MusketHill implements State {

    /**
     * State that the automata can go to if the action is A
     */
    State A;
    /**
     * State that the automata can go to if the action is B
     */
    State B;

    public MusketHill() {
        this.A = new PiratesIsland();
        this.B = new MutineersIsland();
    }

    /**
     * {@inheritDoc}
     */
    public State transition(Action action) {
        if (action.str() == Action.A.str()) {
            return new PiratesIsland();
        } else if (action.str() == Action.B.str()) {
            return new MutineersIsland();
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    public String str() {
        return ("Musket Hill");
    }

    /**
     * {@inheritDoc}
     */
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("Action A -> Pirates Island");
        // sb.append(A.str());
        sb.append(", Action B -> Mutineers Island");
        // sb.append(B.str());
        return sb.toString();
    }

}
