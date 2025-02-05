import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            String[] numbers = input.split("\\+");

            Arrays.sort(numbers);

            System.out.println(String.join("+", numbers));
        }
    }
}
