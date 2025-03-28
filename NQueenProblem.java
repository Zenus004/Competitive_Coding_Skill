import java.util.Scanner;

public class NQueenProblem {
    private int N;
    private int[][] board;

    public NQueenProblem(int N) {
        this.N = N;
        this.board = new int[N][N];
    }

    // Function to check if a queen can be placed at board[row][col]
    private boolean isSafe(int row, int col) {
        // Check this column on the upper side
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the right side
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Recursive function to solve N-Queen problem
    private boolean solveNQueenUtil(int row) {
        if (row >= N) {
            return true;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;

                if (solveNQueenUtil(row + 1)) {
                    return true;
                }

                board[row][col] = 0; // Backtrack
            }
        }
        return false;
    }

    // Function to solve N-Queen and print the solution
    public void solveNQueen() {
        if (!solveNQueenUtil(0)) {
            System.out.println("No solution exists");
            return;
        }
        printBoard();
    }

    // Function to print the board
    private void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((board[i][j] == 1 ? "Q " : "- "));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();
        sc.close();

        NQueenProblem queenSolver = new NQueenProblem(N);
        queenSolver.solveNQueen();
    }
}
