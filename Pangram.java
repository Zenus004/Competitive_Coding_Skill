import java.util.Scanner;
import java.util.HashSet;

public class Pangram {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String str = scanner.nextLine().toLowerCase();

            System.out.println(isPangram(str, n) ? "YES" : "NO");
        }
    }

    private static boolean isPangram(String str, int n) {
        if (n < 26) return false;

        HashSet<Character> letters = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.add(ch);
            }
            if (letters.size() == 26) return true;
        }
        return false;
    }
}
