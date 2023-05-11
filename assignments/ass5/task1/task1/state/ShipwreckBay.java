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
     * State that the automata can go to if the action is A
     */
    State A;
    /**
     * State that the automata can go to if the action is B
     */
    State B;

    public ShipwreckBay() {
        this.A = new MusketHill();
        this.B = new DeadMansIsland();
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
        return ("Shipwreck Bay");
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
