package Games;

import java.util.Scanner;

/**
 * TicTacToe Game
 */
public class TicTacToe {

    private final int SIZE = 3;
    private char[][] board = new char[SIZE][SIZE];

    private void initializeBoard() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                board[r][c] = '.';
            }
        }
    }

    private void printBoard() {
        System.out.println("\n  1 2 3"); // column labels

        for (int r = 0; r < SIZE; r++) {
            System.out.print((r + 1) + " "); // row label
            for (int c = 0; c < SIZE; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    private char getPieceForPlayer(char player) {
        return (player == '1') ? 'X' : 'O';
    }

    private boolean placeMove(int row, int col, char player) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return false;
        }
        if (board[row][col] != '.') {
            return false;
        }

        board[row][col] = getPieceForPlayer(player);
        return true;
    }

    private boolean checkWin(char piece) {
        // Rows
        for (int r = 0; r < SIZE; r++) {
            if (board[r][0] == piece && board[r][1] == piece && board[r][2] == piece)
                return true;
        }

        // Columns
        for (int c = 0; c < SIZE; c++) {
            if (board[0][c] == piece && board[1][c] == piece && board[2][c] == piece)
                return true;
        }

        // Diagonal top-left to bottom-right
        if (board[0][0] == piece && board[1][1] == piece && board[2][2] == piece)
            return true;

        // Diagonal top-right to bottom-left
        if (board[0][2] == piece && board[1][1] == piece && board[2][0] == piece)
            return true;

        return false;
    }

    private boolean isBoardFull() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    private final Scanner scanner;

    /**
     * TicTacToe Constructor
     * @param scanner Text Scanner
     */
    public TicTacToe(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Enter Game Loop
     */
    public void play() {
        initializeBoard();

        System.out.println(" ");
        System.out.println("===================");
        System.out.println("    TIC TAC TOE    ");
        System.out.println("===================");

        char currentPlayer = '1';
        boolean playing = true;

        while (playing) {
            printBoard();

            System.out.print("Player " + currentPlayer + ", enter row (1-3): ");
            int row = scanner.nextInt() - 1;

            System.out.print("Player " + currentPlayer + ", enter column (1-3): ");
            int col = scanner.nextInt() - 1;
            scanner.nextLine(); // clear newline

            boolean success = placeMove(row, col, currentPlayer);

            if (!success) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            char piece = getPieceForPlayer(currentPlayer);

            if (checkWin(piece)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                return;
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a tie!");
                return;
            }

            currentPlayer = (currentPlayer == '1') ? '2' : '1';
        }
    }
}
