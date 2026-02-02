package hexlet.code.games;

import java.security.SecureRandom;

public class Even {
    /** Maximum value for random numbers. */
    private static final int MAX_RANDOM = 100;
    /** Game rules. */
    private static final String RULES = "Answer 'yes' if the number is even, "
        + "otherwise answer 'no'.";
    /** RNG for game data. */
    private static final SecureRandom RANDOM = new SecureRandom();

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static String getRules() {
        return RULES;
    }

    public static String[][] getRounds() {
        var roundsCount = hexlet.code.Engine.getRoundsCount();
        var rounds = new String[roundsCount][2];
        for (var i = 0; i < roundsCount; i++) {
            var number = RANDOM.nextInt(1, MAX_RANDOM + 1);
            var correctAnswer = isEven(number) ? "yes" : "no";
            rounds[i][0] = String.valueOf(number);
            rounds[i][1] = correctAnswer;
        }
        return rounds;
    }
}
