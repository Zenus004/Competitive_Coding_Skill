import java.util.Scanner;

public class SubsetSum {
    // Function to check if a subset with the given sum exists
    public static boolean isSubsetSum(int[] arr, int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        // If the last element is greater than sum, ignore it
        if (arr[n - 1] > sum) {
            return isSubsetSum(arr, n - 1, sum);
        }

        // Check if sum can be obtained by including or excluding the last element
        return isSubsetSum(arr, n - 1, sum) || isSubsetSum(arr, n - 1, sum - arr[n - 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int sum = sc.nextInt();

        if (isSubsetSum(arr, n, sum)) {
            System.out.println("A subset with the given sum exists.");
        } else {
            System.out.println("No subset with the given sum exists.");
        }

        sc.close();
    }
}
