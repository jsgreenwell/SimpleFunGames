import Games.ConnectFour;
import Games.RockPaperScissors;
import Games.TicTacToe;
import java.util.Scanner;

// Menu for Game Selection
public class Main {

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

            switch (choice) {
                case "1":
                    ConnectFour connectFour = new ConnectFour(scanner);
                    connectFour.play();

                    System.out.print("Want to Play Again? (y/n): ");
                    String again = scanner.nextLine().trim().toLowerCase();

                    if (again.equals("y")) {
                        connectFour = new ConnectFour(scanner); // reset game
                        connectFour.play();
                    }
                    break;

                case "2":
                    RockPaperScissors rps = new RockPaperScissors(scanner);
                    rps.play();
                    break;

                case "3":
                    TicTacToe ticTacToe = new TicTacToe(scanner);
                    ticTacToe.play();

                    System.out.print("Play Tic Tac Toe again? Press y to Continue Game.");
                    String again3 = scanner.nextLine().trim().toLowerCase();

                    if (again3.equals("y")) {
                        ticTacToe = new TicTacToe(scanner); // resets the game
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
