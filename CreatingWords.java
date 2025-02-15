import java.util.Scanner;

public class CreatingWords {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < t; i++) {
                String[] words = scanner.nextLine().split(" ");
                String a = words[0];
                String b = words[1];

                String newA = b.charAt(0) + a.substring(1);
                String newB = a.charAt(0) + b.substring(1);

                System.out.println(newA + " " + newB);
            }
        }
    }
}
