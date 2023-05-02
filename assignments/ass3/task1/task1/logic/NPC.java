package task1.logic;

/**
 * Provides the NPC that is doing the parcour
 * 
 * @author Darius Vollmer
 * @version 2nd May 2023
 */
public class NPC {
    /**
     * Indicates whether the npc is crouching
     */
    boolean isCrouching;
    /**
     * Coords of the x-coordinate
     */
    int xCoordinate;
    /**
     * Coords of the y-coordinate
     */
    int yCoordinate;

    /**
     * Constructor that sets the NPC to be on 0 | 1 and non-crouching
     */
    public NPC() {
        this.isCrouching = false;
        this.xCoordinate = 0;
        this.yCoordinate = 1;
    }

    /**
     * Getter for the x-coordinate
     * 
     * @return x-coordinate
     */
    public int getXCoordinate() {
        return this.xCoordinate;
    }

    /**
     * Setter for the x-coordinate
     * 
     * @param xCoordinate the new coordinate
     */
    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Getter for the y-coordinate
     * 
     * @return y-coordinate
     */
    public int getYCoordinate() {
        return this.yCoordinate;
    }

    /**
     * Setter for the y-coordinate
     * 
     * @param yCoordinate the new coordinate
     */
    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Getter for the crouching
     * 
     * @return isCrouching
     */
    public boolean isCrouching() {
        return this.isCrouching;
    }

    /**
     * Toggles the crouch state
     */
    public void toggleCrouch() {
        this.isCrouching = !this.isCrouching;
    }

    /**
     * Makes the NPC walk 1 block to the right
     */
    public void walkRight() {
        this.xCoordinate += 1;
    }

    /**
     * Makes the NPC walk 2 block to the right if he's not crouching
     */
    public void dashRight() {
        if (!isCrouching) {
            this.xCoordinate += 2;
        }
    }
}
