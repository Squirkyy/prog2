package task2.model;


/**
 * This interface provides methods for controlling and displaying a game on the
 * command line.<br><br><br>
 * 
 * 
 * This interface provides methods for pressing virtual "buttons" on the game and
 * retrieving the current game state.<br><br>
 * 
 * This interface offers four directional buttons, and two action buttons.<br>
 * They are internally called "up", "down", "left", "right", "a", and "b", but 
 * they can be labeled with any other names. These labels are dependent on the
 * implementing class.<br>
 * The Methods {@link #pressUpButton()}, {@link #pressDownButton()},
 * {@link #pressLeftButton()}, {@link #pressRightButton()},
 * {@link #pressAButton()}, and {@link #pressBButton()} are called to indicate
 * the pressing of the buttons, while the methods {@link #getUpLabel()},
 * {@link #getDownLabel()}, {@link #getLeftLabel()}, {@link #getRightLabel()},
 * {@link #getALabel()}, and {@link #getBLabel()} are called to retrieve the
 * labels of the buttons.<br>
 * Not all buttons need to do something. The labels cannot change during a game
 * and need to be unique among each other.<br><br><br>
 * 
 * 
 * The following conditions are to be met by any class that implements this interface:<br><br>
 * 
 * A game has to be ready to play when an object implementing this interface is
 * created. No additional initialization is allowed to be required by an implementing
 * class.<br>
 * A game has to have some sort of ending condition which the player has to be able to
 * trigger, causing the {@link #isRunning()} method to return false from that point on.
 * A game that has once been ended cannot be restarted.<br>
 * The {@link #getGameState()} method should return a string that represents the current
 * state of the game. That string cannot be longer than 40 lines, each line not exceeding
 * 80 characters. <br>
 * @author Patric Plattner
 */
public interface GameInterface {
    /**
     * Indicates pressing up button.
     * 
     * Doesn't do anything if {@link #isRunning()} is returning false.
     */
    void pressUpButton();
    /**
     * Indicates pressing down button.
     * 
     * Doesn't do anything if {@link #isRunning()} is returning false.
     */
    void pressDownButton();
    /**
     * Indicates pressing left button.
     * 
     * Doesn't do anything if {@link #isRunning()} is returning false.
     */
    void pressLeftButton();
    /**
     * Indicates pressing right button.
     * 
     * Doesn't do anything if {@link #isRunning()} is returning false.
     */
    void pressRightButton();
    /**
     * Indicates pressing a button.
     * 
     * Doesn't do anything if {@link #isRunning()} is returning false.
     */
    void pressAButton();
    /**
     * Indicates pressing b button.
     * 
     * Doesn't do anything if {@link #isRunning()} is returning false.
     */
    void pressBButton();
    /**
     * Returns the label of the up button.
     * @return the label of the up button
     */
    String getUpLabel();
    /**
     * Returns the label of the down button.
     * @return the label of the down button
     */
    String getDownLabel();
    /**
     * Returns the label of the left button.
     * @return the label of the left button
     */
    String getLeftLabel();
    /**
     * Returns the label of the right button.
     * @return the label of the right button
     */
    String getRightLabel();
    /**
     * Returns the label of the a button.
     * @return the label of the a button
     */
    String getALabel();
    /**
     * Returns the label of the b button.
     * @return the label of the b button
     */
    String getBLabel();
    /**
     * Returns a string that represents the current state of the game.
     * 
     * Contains no more than 40 lines, each line not exceeding 80 characters.
     * 
     * Commonly includes the state of the game playing field if applicable to the game.model
     * This method returns the <b>entire</b> game state, not just the playing field.
     * 
     * @return a string that represents the current state of the game
     */
    String getGameState();
    /**
     * Returns true if the game is still running.
     * @return true if the game is still running
     */
    boolean isRunning();
}
