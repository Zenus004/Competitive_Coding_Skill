import java.util.Scanner;

public class NQueenProblem {

    // Function to print the board
    public static void printBoard(int[][] board, int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print((board[i][j] == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to check if queen can be placed
    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check column
        for(int i=0; i<row; i++) {
            if(board[i][col] == 1)
                return false;
        }

        // Check left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 1)
                return false;
        }

        // Check right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++) {
            if(board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Backtracking Function to solve N-Queen
    public static boolean solveNQueen(int[][] board, int row, int n) {
        if(row == n) {
            printBoard(board, n);
            return true;
        }

        boolean res = false;
        for(int col=0; col<n; col++) {
            if(isSafe(board, row, col, n)) {
                board[row][col] = 1;
                if(solveNQueen(board, row+1, n))   // Direct return if solution found
                    return true;
                board[row][col] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N (number of Queens): ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];

        if(!solveNQueen(board, 0, n)) {
            System.out.println("Solution doesn't exist");
        }
    }
}
