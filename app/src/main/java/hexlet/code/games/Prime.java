package hexlet.code.games;

import java.security.SecureRandom;

public class Prime {
    /** Maximum value for random numbers. */
    private static final int MAX_RANDOM = 100;
    /** First odd divisor to check. */
    private static final int FIRST_ODD_DIVISOR = 3;
    /** Game rules. */
    private static final String RULES = "Answer 'yes' if given number is "
        + "prime. Otherwise answer 'no'.";

    public static String getRules() {
        return RULES;
    }

    public static String[][] getRounds() {
        var roundsCount = hexlet.code.Engine.getRoundsCount();
        var rounds = new String[roundsCount][2];
        var random = new SecureRandom();
        for (var i = 0; i < roundsCount; i++) {
            var number = random.nextInt(1, MAX_RANDOM + 1);
            var correctAnswer = isPrime(number) ? "yes" : "no";
            rounds[i][0] = String.valueOf(number);
            rounds[i][1] = correctAnswer;
        }
        return rounds;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (var i = FIRST_ODD_DIVISOR; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
