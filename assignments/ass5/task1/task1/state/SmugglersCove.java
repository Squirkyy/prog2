package task1.state;

import task1.Action;

/**
 * Implementation of the State for the Smuggler's Cove
 * 
 * @author Darius Vollmer
 * @version 11th May 2023
 */
public class SmugglersCove implements State {
    /**
     * State that the automata can go to if the action is A
     */
    State A;
    /**
     * State that the automata can go to if the action is B
     */
    State B;

    public SmugglersCove() {
        this.A = new PiratesIsland();
        this.B = new TreasureIsland();
    }

    /**
     * {@inheritDoc}
     */
    public State transition(Action action) {
        if (action.str() == Action.A.str()) {
            return A;
        } else if (action.str() == Action.B.str()) {
            return B;
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    public String str() {
        return ("Smuggler's Cove");
    }

    /**
     * {@inheritDoc}
     */
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("Action A -> ");
        sb.append(A.str());
        sb.append(", Action B -> ");
        sb.append(B.str());
        return sb.toString();
    }

}
