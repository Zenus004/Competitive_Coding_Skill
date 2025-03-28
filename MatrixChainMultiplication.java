import java.util.Scanner;

public class MatrixChainMultiplication {
    // Function to find the minimum number of multiplications needed
    public static int matrixChainOrder(int[] p, int n) {
        int[][] dp = new int[n][n];

        // Initializing the main diagonal to 0 as a single matrix needs no multiplication
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // L is the chain length
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of matrices: ");
        int n = scanner.nextInt();
        int[] p = new int[n + 1];

        System.out.println("Enter the dimensions array (size " + (n + 1) + "): ");
        for (int i = 0; i <= n; i++) {
            p[i] = scanner.nextInt();
        }

        int minCost = matrixChainOrder(p, n + 1);
        System.out.println("Minimum number of multiplications needed: " + minCost);

        scanner.close();
    }
}
