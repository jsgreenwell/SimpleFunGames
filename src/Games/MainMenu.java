package Games;

import java.util.Scanner;

// Menu for Game Selection
public class MainMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("=== Pick Any Game ===");
            System.out.println("1. Connect Four");
            System.out.println("2. Rock Paper Scissors");
            System.out.println("3. Tic-Tac-Toe");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            GameTemplate connectFour = new ConnectFour(scanner);
            GameTemplate rps = new RockPaperScissors(scanner);
            GameTemplate ticTacToe = new TicTacToe(scanner);

            switch (choice) {
                case "1":
                    connectFour.play();

                    System.out.print("Want to Play Again? (y/n): ");
                    String again = scanner.nextLine().trim().toLowerCase();

                    if (again.equals("y")) {
                        connectFour = new ConnectFour(scanner); // reset game
                        connectFour.play();
                    }
                    break;

                case "2":
                    rps.play();
                    break;

                case "3":
                    ticTacToe.play();

                    System.out.print("Play Tic Tac Toe again? (y/n): ");
                    String again3 = scanner.nextLine().trim().toLowerCase();

                    if (again3.equals("y")) {
                        ticTacToe = new TicTacToe(scanner); // reset the game
                        ticTacToe.play();
                    }
                    break;

                case "4":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

            System.out.println();
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}
