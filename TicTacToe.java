import java.util.Scanner;

public class TicTacToe {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("\nLet's play tic tac toe");

        char[][] board = {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
        };

        int result = 0;

        printBoard(board);

        for (int i = 0; i < 9; i++) {
            int[] pos;
            if (i % 2 == 0) {
                System.out.println("Turn: X");
                pos = askUser(board);
                board[pos[0]][pos[1]] = 'X';
                printBoard(board);
            } else {
                System.out.println("Turn: O");
                pos = askUser(board);
                board[pos[0]][pos[1]] = 'O';
                printBoard(board);
            }

            result = checkWin(board);
            if (result == 3) {
                System.out.println("X wins!");
                break;
            } else if (result == -3) {
                System.out.println("O wins!");
                break;
            }
        }

        if(result == 0) {
            System.out.println("It's a tie!");
        }

        scan.close();
    }

    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static int[] askUser(char[][] board) {
        System.out.print("Pick a row and column number (1 - 3): ");
        int row = scan.nextInt() - 1;
        int column = scan.nextInt() - 1;

        while(true) {
            if (row > 2 || column > 2) {
                System.out.println("Enter a proper row and column number: ");
                row = scan.nextInt() - 1;
                column = scan.nextInt() - 1;
                continue;
            }

            if (board[row][column] != '_') {
                System.out.println("Pick a different row and column: ");
                row = scan.nextInt() - 1;
                column = scan.nextInt() - 1;
            } else {
                break;
            }
        }

        return new int[] {row, column};
    }

    public static int checkWin(char[][] board) {
        int count = 0;

        //Check every row
        for (int i = 0; i < board.length; i++) {
            if ((board[i][0] == 'X') && (board[i][1] == 'X') && (board[i][2] == 'X')) {
                count = 3;
            } else if ((board[i][0] == 'O') && (board[i][1] == 'O') && (board[i][2] == 'O')) {
                count = -3;
            }
        }

        //Check every column
        for (int i = 0; i < board.length; i++) {
            if ((board[0][i] == 'X') && (board[1][i] == 'X') && (board[2][i] == 'X')) {
                count = 3;
            } else if ((board[0][i] == 'O') && (board[1][i] == 'O') && (board[2][i] == 'O')) {
                count = -3;
            }
        }

        //Check left diagonal
        if ((board[0][0] == 'X') && (board[1][1] == 'X') && (board[2][2] == 'X')) {
            count = 3;
        } else if ((board[0][0] == 'O') && (board[1][1] == 'O') && (board[2][2] == 'O')) {
            count = -3;
        }

        //Check right diagonal
        if ((board[0][2] == 'X') && (board[1][1] == 'X') && (board[2][0] == 'X')) {
            count = 3;
        } else if ((board[0][2] == 'O') && (board[1][1] == 'O') && (board[2][0] == 'O')) {
            count = -3;
        }

        return count;
    }
}
