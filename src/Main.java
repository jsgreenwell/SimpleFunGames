import Games.ConnectFour;
import Games.RockPaperScissors;
import Games.TicTacToe;
import java.util.Scanner;
import java.util.logging.FileHandler;


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
            System.out.println("4. War CardGame"); // Second set of games here
            System.out.println("5. Word Scramble");
            System.out.println("6. View High Scores");
            System.out.println("7. Quit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine().trim());

            try {
              switch (choice) {
                  case 1:
                      ConnectFour connectFour = new ConnectFour(scanner);
                      connectFour.play();

                      System.out.print("Want to Play Again? (y/n): ");
                      String again = scanner.nextLine().trim().toLowerCase();

                      if (again.equals("y")) {
                          connectFour = new ConnectFour(scanner); // reset game
                          connectFour.play();
                      }
                      break;

                  case 2:
                      RockPaperScissors rps = new RockPaperScissors(scanner);
                      rps.play();
                      break;

                  case 3:
                      TicTacToe ticTacToe = new TicTacToe(scanner);
                      ticTacToe.play();

                      System.out.print("Play Tic Tac Toe again? Press y to Continue Game.");
                      String again3 = scanner.nextLine().trim().toLowerCase();

                      if (again3.equals("y")) {
                          ticTacToe = new TicTacToe(scanner); // resets the game
                          ticTacToe.play();
                      }
                      break;

                    case 4:
                       new WarGame().play();
                       break;

                    case 5:
                        scramble.play();
                        break;

                    case 6:
                        ScoreFileHandler.readScores();
                        break;

                    case 7:
                        System.out.println("Goodbye!");
                        running = false;
                        return;

                    default:
                        System.out.println("Invalid choice.");
              }
           } catch (Exception e) {
                System.out.println("Please enter a number.");
                // Nice call here
            }

            System.out.println();
            System.out.println("Goodbye!");
            scanner.close();
    }
}


