import java.util.Scanner;

public class SecondLargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int largest = -1;
        int secondlarge = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondlarge = largest;
                largest = arr[i];
            } else if (arr[i] > secondlarge && arr[i] != largest) {
                secondlarge = arr[i];
            }
        }
        System.out.println("The second largest element in the array is: " + secondlarge);
    }
}
