package task1.view;

import java.util.Arrays;

import task1.logic.GameObject;
import task1.logic.NPC;

/**
 * GameView that actually renders the Jump'n'Crouch
 * 
 * @author Darius Vollmer
 * @version 2nd May 2023
 */
public class GameView {
    /**
     * Playing field
     */
    GameObject[][] game;
    /**
     * Player on field
     */
    NPC player;

    /**
     * Constructor as per instructions
     */
    public GameView() {
        this.game = new GameObject[20][3];
        this.player = new NPC();
        for (GameObject[] g : this.game) {
            Arrays.fill(g, GameObject.AIR);
        }
        for (int i = 0; i < 20; i++) {
            this.game[i][2] = GameObject.GROUND;
        }
        player.setXCoordinate(0);
        player.setYCoordinate(1);
        this.game[0][1] = GameObject.PLAYER;
        this.game[0][0] = GameObject.PLAYER;
        this.game[4][2] = GameObject.LAVA;
        this.game[10][2] = GameObject.LAVA;
        this.game[12][2] = GameObject.LAVA;
        this.game[17][2] = GameObject.LAVA;
        this.game[6][0] = GameObject.AIROBSTACLE;
        this.game[8][0] = GameObject.AIROBSTACLE;
        this.game[15][0] = GameObject.AIROBSTACLE;
    }

    /**
     * Visualizes the playingfield
     * 
     * @return a strig formated version of the field
     */
    public String str() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.game.length; i++) {
            sb.append(this.game[i][0].getSymbol());
        }
        sb.append("\n");
        for (int i = 0; i < this.game.length; i++) {
            sb.append(this.game[i][1].getSymbol());
        }
        sb.append("\n");
        for (int i = 0; i < this.game.length; i++) {
            sb.append(this.game[i][2].getSymbol());
        }
        sb.append("\n");

        /*
         * for (int i = 0; i < this.game.length; i++) {
         * for (int j = 0; j < this.game[i].length; j++) {
         * sb.append(this.game[i][j].getSymbol());
         * }
         * sb.append("\n");
         * }
         */
        return sb.toString();
    }

    /**
     * Helper to keep track of the Postion of the player on field
     * 
     * @param x that is to be added to the position
     * @param y that is to be added to the position
     */
    private void movePlayer(int x, int y) {
        if (player.isCrouching()) {
            this.game[player.getXCoordinate()][player.getYCoordinate()] = GameObject.AIR;
        } else {
            this.game[player.getXCoordinate()][player.getYCoordinate()] = GameObject.AIR;
            this.game[player.getXCoordinate()][player.getYCoordinate() - 1] = GameObject.AIR;
        }
        player.setXCoordinate(player.getXCoordinate() + x);
        player.setYCoordinate(player.getYCoordinate() + y);
        if (player.isCrouching()) {
            this.game[player.getXCoordinate()][player.getYCoordinate()] = GameObject.PLAYER;
        } else {
            this.game[player.getXCoordinate()][player.getYCoordinate()] = GameObject.PLAYER;
            this.game[player.getXCoordinate()][player.getYCoordinate() - 1] = GameObject.PLAYER;
        }
    }

    /**
     * Helper to show if the crouch state is switching
     */
    private void showCrouching() {
        if (player.isCrouching()) {
            this.game[player.getXCoordinate()][player.getYCoordinate() - 1] = GameObject.PLAYER;
        } else {
            this.game[player.getXCoordinate()][player.getYCoordinate() - 1] = GameObject.AIR;

        }
    }

    /**
     * The actual game loop that runs until either on lava or succeeded
     */
    public void play() {
        boolean state = true;
        while (state) {
            System.out.println(str());
            if (this.game[this.player.getXCoordinate()][2] == GameObject.GOAL
                    || this.game[this.player.getXCoordinate()][2] == GameObject.LAVA
                    || this.player.getXCoordinate() == 19) {
                state = false;
                continue;
            } else if (this.game[this.player.getXCoordinate() + 1][0] == GameObject.AIROBSTACLE) {
                showCrouching();
                this.player.toggleCrouch();
                movePlayer(1, 0);
                this.player.toggleCrouch();
                continue;
            } else if (this.game[this.player.getXCoordinate() + 1][2] == GameObject.LAVA) {
                if (this.player.isCrouching()) {
                    showCrouching();
                    this.player.toggleCrouch();
                }
                movePlayer(2, 0);
                continue;
            } else {
                movePlayer(1, 0);
                continue;
            }
        }
    }
}
