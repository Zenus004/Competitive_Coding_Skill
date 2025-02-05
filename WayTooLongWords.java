import java.util.Scanner;

public class WayTooLongWords {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < n; i++) {
                String word = scanner.nextLine();
                System.out.println(abbreviate(word));
            }
        }
    }

    private static String abbreviate(String word) {
        if (word.length() > 10) {
            return String.format("%c%d%c", word.charAt(0), word.length() - 2, word.charAt(word.length() - 1));
        }
        return word;
    }
}
