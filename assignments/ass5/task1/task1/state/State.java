package task1.state;

import task1.Action;

/**
 * Interface of the State for the automata
 * 
 * @author Darius Vollmer
 * @version 11th May 2023
 */
public interface State {

    /**
     * Implements the transition from this state to the next according to a given
     * action
     * 
     * @param action that says where to go
     * @return new state
     */
    public State transition(Action action);

    /**
     * Identifier of the current state
     * 
     * @return a stringified version of the current state
     */
    public String str();

    /**
     * Provides information about the states that can be reached from this state
     * 
     * @return stringified version of which states can be reached
     */
    public String info();
}
