import java.util.Arrays;
import java.util.Scanner;

public class MinimumPlatforms {
    // Function to find the minimum number of platforms required
    public static int findMinPlatforms(int[] arrival, int[] departure, int n) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platforms = 1, maxPlatforms = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of trains: ");
        int n = sc.nextInt();
        int[] arrival = new int[n];
        int[] departure = new int[n];

        System.out.println("Enter arrival times: ");
        for (int i = 0; i < n; i++) {
            arrival[i] = sc.nextInt();
        }

        System.out.println("Enter departure times: ");
        for (int i = 0; i < n; i++) {
            departure[i] = sc.nextInt();
        }

        int result = findMinPlatforms(arrival, departure, n);
        System.out.println("Minimum number of platforms required: " + result);

        sc.close();
    }
}
