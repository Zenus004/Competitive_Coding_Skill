import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String word = scanner.nextLine();
            System.out.println(correctCase(word));
        }
    }

    private static String correctCase(String word) {
        int upperCount = 0, lowerCount = 0;

        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            } else {
                lowerCount++;
            }
        }

        return (upperCount > lowerCount) ? word.toUpperCase() : word.toLowerCase();
    }
}
