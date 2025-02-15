import java.util.Scanner;

public class LoveStory {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            scanner.nextLine();
            String target = "codeforces";

            for (int i = 0; i < t; i++) {
                String s = scanner.nextLine();
                int differences = 0;

                for (int j = 0; j < 10; j++) {
                    if (s.charAt(j) != target.charAt(j)) {
                        differences++;
                    }
                }

                System.out.println(differences);
            }
        }
    }
}
