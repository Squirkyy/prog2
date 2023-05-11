package task1.state;

import task1.Action;

/**
 * Implementation of the State for the Pirat's Island
 * 
 * @author Darius Vollmer
 * @version 11th May 2023
 */
public class PiratesIsland implements State {

    /**
     * {@inheritDoc}
     */
    public State transition(Action action) {
        if (action.str() == Action.A.str()) {
            return new ShipwreckBay();
        } else if (action.str() == Action.B.str()) {
            return new MusketHill();
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    public String str() {
        return ("Pirate's Island");
    }

    /**
     * {@inheritDoc}
     */
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("Action A -> Shipwreck Bay");
        // sb.append(A.str());
        sb.append(", Action B -> Musket Hill");
        // sb.append(B.str());
        return sb.toString();
    }
}
