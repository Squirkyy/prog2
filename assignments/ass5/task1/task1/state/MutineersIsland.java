package task1.state;

import task1.Action;

/**
 * Implementation of the State for the Mutineer's Island
 * 
 * @author Darius Vollmer
 * @version 11th May 2023
 */
public class MutineersIsland implements State {
    /**
     * {@inheritDoc}
     */
    public State transition(Action action) {
        if (action.str() == Action.A.str()) {
            return new SmugglersCove();
        } else if (action.str() == Action.B.str()) {
            return new DeadMansIsland();
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    public String str() {
        return ("Mutineer's Island");
    }

    /**
     * {@inheritDoc}
     */
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("Action A -> Smugglers Cove");
        // sb.append(A.str());
        sb.append(", Action B -> Deadmans Island");
        // sb.append(B.str());
        return sb.toString();
    }
}
