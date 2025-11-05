//Design n-Queens matrix having first Queen placed. Use backtracking to place remaining Queens to
//generate the final n- queen‘s matrix.

import java.util.*;

public class daa4 {

    // Function to print the board
    static void printBoard(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    // Check if placing a queen at (row, col) is safe
    static boolean isSafe(int[][] board, int row, int col, int N) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    // Backtracking to place queens
    static boolean solveNQueens(int[][] board, int row, int N) {
        if (row >= N) return true;

        // Skip row if queen already placed
        for (int col = 0; col < N; col++) {
            if (board[row][col] == 1) {
                return solveNQueens(board, row + 1, N);
            }
        }

        for (int col = 0; col < N; col++) {
            if (board[row][col] == 0 && isSafe(board, row, col, N)) {
                board[row][col] = 1; // Place queen
                if (solveNQueens(board, row + 1, N))
                    return true;
                board[row][col] = 0; // Backtrack
            }
        }

        return false;
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of board (N): ");
        int N = sc.nextInt();

        int[][] board = new int[N][N];

        System.out.print("Enter position of first queen (row and column, 0-based index): ");
        int firstRow = sc.nextInt();
        int firstCol = sc.nextInt();

        if (firstRow < 0 || firstRow >= N || firstCol < 0 || firstCol >= N) {
            System.out.println("Invalid position!");
            return;
        }

        board[firstRow][firstCol] = 1; // Place the initial queen

        if (solveNQueens(board, 0, N)) {
            System.out.println("\nN-Queens solution:");
            printBoard(board, N);
        } else {
            System.out.println("No solution exists with the given starting queen position.");
        }
    }
}