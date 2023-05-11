package task1.state;

import task1.Action;

/**
 * Implementation of the State for the Shipwreck Bay
 * 
 * @author Darius Vollmer
 * @version 11th May 2023
 */
public class ShipwreckBay implements State {

    /**
     * {@inheritDoc}
     */
    public State transition(Action action) {
        if (action.str() == Action.A.str()) {
            return new MusketHill();
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
        return ("Shipwreck Bay");
    }

    /**
     * {@inheritDoc}
     */
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("Action A -> Musket Hill");
        // sb.append(A.str());
        sb.append(", Action B -> Deadmans Island");
        // sb.append(B.str());
        return sb.toString();
    }

}
