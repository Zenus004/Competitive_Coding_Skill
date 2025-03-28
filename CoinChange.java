import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    // Function to find the minimum number of coins needed
    public static int minCoins(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of coin denominations: ");
        int n = sc.nextInt();
        int[] coins = new int[n];

        System.out.println("Enter the coin denominations: ");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.print("Enter the amount: ");
        int amount = sc.nextInt();

        int result = minCoins(coins, amount);
        System.out.println("Minimum number of coins needed: " + result);

        sc.close();
    }
}
