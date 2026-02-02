package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public class Even {
    /** Maximum value for random numbers. */
    private static final int MAX_RANDOM = 100;
    /** Game rules. */
    private static final String RULES = "Answer 'yes' if the number is even, "
        + "otherwise answer 'no'.";

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static String getRules() {
        return RULES;
    }

    public static String[][] getRounds() {
        var roundsCount = hexlet.code.Engine.getRoundsCount();
        var rounds = new String[roundsCount][2];
        var random = ThreadLocalRandom.current();
        for (var i = 0; i < roundsCount; i++) {
            var number = random.nextInt(1, MAX_RANDOM + 1);
            var correctAnswer = isEven(number) ? "yes" : "no";
            rounds[i][0] = String.valueOf(number);
            rounds[i][1] = correctAnswer;
        }
        return rounds;
    }
}
