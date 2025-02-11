import java.util.Scanner;

public class AntonAndDanik {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String games = scanner.next();

            System.out.println(determineWinner(games));
        }
    }

    private static String determineWinner(String games) {
        int antonWins = 0, danikWins = 0;

        for (char c : games.toCharArray()) {
            if (c == 'A') {
                antonWins++;
            } else {
                danikWins++;
            }
        }

        if (antonWins > danikWins) {
            return "Anton";
        } else if (danikWins > antonWins) {
            return "Danik";
        } else {
            return "Friendship";
        }
    }
}
