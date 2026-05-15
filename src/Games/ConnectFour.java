package Games;

import java.util.Scanner;

/**
 * Connect 4 Game
 */
public class ConnectFour {

    private final int ROWS = 6;
    private final int COLS = 7;
    private char[][] board = new char[ROWS][COLS];

    private final Scanner scanner;

    /**
     * Connect 4 Constructor
     * @param scanner Text Scanner
     */
    public ConnectFour(Scanner scanner) {
        this.scanner = scanner;
    }

    private void initializeBoard() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                board[r][c] = '.';
            }
        }
    }

    private void printBoard() {
        System.out.println("\nCurrent Board:");
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6");
    }

    private boolean dropPiece(int column, char player) {
        char piece = getPieceForPlayer(player);

        for (int r = ROWS - 1; r >= 0; r--) {
            if (board[r][column] == '.') {
                board[r][column] = piece;
                return true;
            }
        }
        return false;
    }

    private boolean checkWin(char piece) {
        // 1. Horizontal check
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS - 3; c++) {
                if (board[r][c] == piece &&
                        board[r][c+1] == piece &&
                        board[r][c+2] == piece &&
                        board[r][c+3] == piece) {
                    return true;
                }
            }
        }

        // 2. Vertical check
        for (int c = 0; c < COLS; c++) {
            for (int r = 0; r < ROWS - 3; r++) {
                if (board[r][c] == piece &&
                        board[r+1][c] == piece &&
                        board[r+2][c] == piece &&
                        board[r+3][c] == piece) {
                    return true;
                }
            }
        }

        // 3. Diagonal down-right
        for (int r = 0; r < ROWS - 3; r++) {
            for (int c = 0; c < COLS - 3; c++) {
                if (board[r][c] == piece &&
                        board[r+1][c+1] == piece &&
                        board[r+2][c+2] == piece &&
                        board[r+3][c+3] == piece) {
                    return true;
                }
            }
        }

        // 4. Diagonal up-right
        for (int r = 3; r < ROWS; r++) {
            for (int c = 0; c < COLS - 3; c++) {
                if (board[r][c] == piece &&
                        board[r-1][c+1] == piece &&
                        board[r-2][c+2] == piece &&
                        board[r-3][c+3] == piece) {
                    return true;
                }
            }
        }

        return false;
    }

    private char getPieceForPlayer(char player) {
        return (player == '1') ? 'X' : 'O';
    }

    private boolean isBoardFull() {
        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == '.') {
                return false; // top row has space
            }
        }
        return true;
    }

    /**
     * Enter the Game Loop
     */
    public void play() {
        initializeBoard();

        System.out.println(" ");
        System.out.println("====================");
        System.out.println("    Connect Four    ");
        System.out.println("====================");

        boolean playing = true;
        char currentPlayer = '1';

        while (playing) {
            printBoard();

            System.out.print("Player " + currentPlayer + ", choose a column (0-6): ");
            int column = scanner.nextInt();
            scanner.nextLine(); // clear leftover newline

            if (column < 0 || column > 6) {
                System.out.println("Invalid column. Try again.");
                continue;
            }

            boolean success = dropPiece(column, currentPlayer);

            if (!success) {
                System.out.println("Column full. Try again.");
                continue;
            }

            if (checkWin(getPieceForPlayer(currentPlayer))) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                return; // end the game and go back to menu
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("Tie!");
                return;
            }

            // Switch between Player 1 and Player 2
            currentPlayer = (currentPlayer == '1') ? '2' : '1';
        }
    }
}
