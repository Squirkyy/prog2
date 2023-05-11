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
     * {@inheritDoc}
     */
    public State transition(Action action) {
        if (action.str() == Action.A.str()) {
            return new PiratesIsland();
        } else if (action.str() == Action.B.str()) {
            return new TreasureIsland();
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
        sb.append("Action A -> Pirates Island");
        // sb.append(A.str());
        sb.append(", Action B -> Treasure Island");
        // sb.append(B.str());
        return sb.toString();
    }

}
