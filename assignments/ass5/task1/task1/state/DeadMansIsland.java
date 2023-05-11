package task1.state;

import task1.Action;

/**
 * Implementation of the State for the Dead Man's Island
 * 
 * @author Darius Vollmer
 * @version 11th May 2023
 */
public class DeadMansIsland implements State {

    /**
     * {@inheritDoc}
     */
    public State transition(Action action) {
        if (action.str() == Action.A.str()) {
            return new MusketHill();
        } else if (action.str() == Action.B.str()) {
            return new ShipwreckBay();
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    public String str() {
        return ("Dead Man's Island");
    }

    /**
     * {@inheritDoc}
     */
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("Action A -> Musket Hill");
        // sb.append(A.str());
        sb.append(", Action B -> Shipwreck Bay");
        // sb.append(B.str());
        return sb.toString();
    }

}
