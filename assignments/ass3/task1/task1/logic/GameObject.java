package task1.logic;

/**
 * GameObjects used in the Jump'n'Crouch
 * 
 * @author Darius Vollmer
 * @version 2nd May 2023
 */
public enum GameObject {
    GROUND, LAVA, AIROBSTACLE, AIR, GOAL, PLAYER;

    /**
     * Gives the Symbol for a given GameObject
     * 
     * @return symbol corresponding to the GameObject
     */
    public char getSymbol() {
        switch (this) {
            case GROUND:
                return 'G';
            case LAVA:
                return 'L';
            case AIROBSTACLE:
                return 'O';
            case AIR:
                return ' ';
            case GOAL:
                return 'Z';
            case PLAYER:
                return 'P';
        }
        return 0;
    }
}