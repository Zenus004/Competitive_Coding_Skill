import java.util.HashSet;
import java.util.Scanner;

public class BoyOrGirl {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String username = scanner.nextLine();
            System.out.println(determineGender(username));
        }
    }

    private static String determineGender(String username) {
        HashSet<Character> uniqueChars = new HashSet<>();

        for (char c : username.toCharArray()) {
            uniqueChars.add(c);
        }

        return (uniqueChars.size() % 2 == 0) ? "CHAT WITH HER!" : "IGNORE HIM!";
    }
}
