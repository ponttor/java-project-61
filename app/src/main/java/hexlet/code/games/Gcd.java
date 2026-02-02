package hexlet.code.games;

import java.security.SecureRandom;

public class Gcd {
    /** Maximum value for random numbers. */
    private static final int MAX_RANDOM = 100;
    /** Game rules. */
    private static final String RULES = "Find the greatest common divisor "
        + "of given numbers.";
    /** RNG for game data. */
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String getRules() {
        return RULES;
    }

    public static String[][] getRounds() {
        var roundsCount = hexlet.code.Engine.getRoundsCount();
        var rounds = new String[roundsCount][2];
        for (var i = 0; i < roundsCount; i++) {
            var first = RANDOM.nextInt(1, MAX_RANDOM + 1);
            var second = RANDOM.nextInt(1, MAX_RANDOM + 1);
            rounds[i][0] = first + " " + second;
            rounds[i][1] = String.valueOf(gcd(first, second));
        }
        return rounds;
    }

    private static int gcd(int a, int b) {
        var x = a;
        var y = b;
        while (y != 0) {
            var temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}
