package task1;

import java.util.Scanner;

import task1.state.*;

public class StateMachine {
    State current;
    State acceptState;

    public StateMachine() {
        this.current = new PiratesIsland();
        this.acceptState = new TreasureIsland();
    }

    void treasureHunt() {
        Scanner input = new Scanner(System.in);
        while (!current.str().equals(acceptState.str())) {
            System.out.println("You are currently @: " + current.str());
            System.out.println("These are your choices: " + current.info());
            System.out.println("Where do you want to go?");
            String choice = input.next().trim().toUpperCase();
            this.current = current.transition(Action.valueOf(choice));
        }
        input.close();
        System.out.println("Good job, you made it to the Treasure Island!");
    }

    public static void main(String[] args) {
        StateMachine sm = new StateMachine();
        sm.treasureHunt();
    }
}
