import java.util.Scanner;

public class MatrixChainMultiplication {

    // Function to find the minimum number of multiplications
    public static int matrixChainOrder(int[] p, int n) {
        int[][] dp = new int[n][n];

        // dp[i][j] = Minimum number of multiplications needed to multiply matrices from i to j

        // l is the chain length
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    // Cost = cost of multiplying left + right + cost of multiplying results
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < dp[i][j])
                        dp[i][j] = cost;
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of matrices
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        // For n matrices, we need n+1 dimensions
        int[] dimensions = new int[n + 1];

        System.out.println("Enter the dimensions array (length " + (n + 1) + "):");
        for (int i = 0; i <= n; i++) {
            dimensions[i] = sc.nextInt();
        }

        int minMultiplications = matrixChainOrder(dimensions, n + 1);
        System.out.println("Minimum number of multiplications: " + minMultiplications);
    }
}
