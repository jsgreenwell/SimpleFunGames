package Games;

import java.util.Scanner;

/**
 * RockPaperScissors Game
 */
public class RockPaperScissors {

    private final Scanner scanner;

    /**
     * RockPaperScissors Constructor
     * @param scanner Text Scanner
     */
    public RockPaperScissors(Scanner scanner) {
        this.scanner = scanner;
    }

    private String getChoiceName(int choice) {
        switch (choice) {
            case 1: return "Rock";
            case 2: return "Paper";
            case 3: return "Scissors";
            default: return "Invalid";
        }
    }

    private int determineWinner(int p1, int p2) {
        if (p1 == p2) return 0; // tie

        if ((p1 == 1 && p2 == 3) ||
                (p1 == 2 && p2 == 1) ||
                (p1 == 3 && p2 == 2)) {
            return 1; // Player 1 wins
        }

        return 2; // Player 2 wins
    }

    /**
     * Enter Game Loop
     */
    public void play() {
        boolean playing = true;

        System.out.println(" ");
        System.out.println("===========================");
        System.out.println("    Rock Paper Scissors    ");
        System.out.println("===========================");

        while (playing) {
            System.out.println("\n=== Rock Paper Scissors ===");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");

            System.out.print("Player 1, choose (1-3): ");
            int p1 = scanner.nextInt();

            System.out.print("Player 2, choose (1-3): ");
            int p2 = scanner.nextInt();
            scanner.nextLine(); // clear leftover newline

            String p1Name = getChoiceName(p1);
            String p2Name = getChoiceName(p2);

            System.out.println("\nPlayer 1 chose: " + p1Name);
            System.out.println("Player 2 chose: " + p2Name);

            int winner = determineWinner(p1, p2);

            if (winner == 0) {
                System.out.println("It's a tie!");
            } else {
                System.out.println("Player " + winner + " wins!");
            }

            System.out.print("\nPlay again? Press y to Continue Game: ");
            String again = scanner.nextLine().trim().toLowerCase();

            if (!again.equals("y")) {
                playing = false;
            }
        }
    }
}
