package edu.cscc;
import java.util.*;

// Lab 7, 10/14/19
/**
 * Play Rock Paper Scissors Lizard Spock against the computer.
 * @author Zach Hertel
 */
public class Main {

    private static Scanner input = new Scanner(System.in);

    /**
     * Run the game of Rock Paper Scissors Lizard Spock.
     */
    public static void main(String[] args) {
        String h_pick;
        String c_pick;
        String answer;
        boolean isValid;

        /**
         * The game will restart if the user replies with "y" or "Y".
         */
        do {
            System.out.println("Let's play rock, paper, scissors, lizard, spock");

            /**
             * Continue to ask the user for a choice until they input "rock", "paper", "scissors", "lizard", or "spock".
             */
            do {
                System.out.print("Enter your choice: ");
                h_pick = input.nextLine();
                isValid = RPSLSpock.isValidPick(h_pick);
                if (!isValid) {
                    System.out.println(h_pick + " is not a valid choice");
                }
            } while (!isValid);

            c_pick = RPSLSpock.generatePick();
            System.out.print("Computer picked " + c_pick + "  ");

            /**
             * Output to the user whether their choice tied, lost, or won against the computer's choice.
             */
            if (c_pick.equalsIgnoreCase(h_pick)) {
                System.out.println("Tie!");
            } else if (RPSLSpock.isComputerWin(c_pick, h_pick)) {
                System.out.println("Computer wins!");
            } else {
                System.out.println("You win!");
            }

            System.out.print("Play again ('y' or 'n'): ");
            answer = input.nextLine();
        } while ("Y".equalsIgnoreCase(answer));
        System.out.println("Live long and prosper!");
    }
}