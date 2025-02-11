import java.util.Scanner;

public class Translation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String s = scanner.next();
            String t = scanner.next();

            System.out.println(isReverse(s, t) ? "YES" : "NO");
        }
    }

    private static boolean isReverse(String s, String t) {
        return new StringBuilder(s).reverse().toString().equals(t);
    }
}
