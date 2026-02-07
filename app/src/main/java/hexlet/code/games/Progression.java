package hexlet.code.games;

import java.security.SecureRandom;

public class Progression {
    /** Minimum progression length. */
    private static final int MIN_LENGTH = 5;
    /** Maximum progression length. */
    private static final int MAX_LENGTH = 10;
    /** Maximum start value for the progression. */
    private static final int MAX_START = 20;
    /** Maximum step value for the progression. */
    private static final int MAX_STEP = 10;
    /** Game rules. */
    private static final String RULES = "What number is missing in "
        + "the progression?";
    /** RNG for game data. */
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String getRules() {
        return RULES;
    }

    public static String[][] getRounds() {
        var roundsCount = hexlet.code.Engine.getRoundsCount();
        var rounds = new String[roundsCount][2];
        for (var i = 0; i < roundsCount; i++) {
            var length = RANDOM.nextInt(MIN_LENGTH, MAX_LENGTH + 1);
            var start = RANDOM.nextInt(1, MAX_START + 1);
            var step = RANDOM.nextInt(1, MAX_STEP + 1);
            var hiddenIndex = RANDOM.nextInt(length);
            var progression = buildProgression(
                start,
                step,
                length
            );
            var hiddenValue = progression[hiddenIndex];

            rounds[i][0] = buildQuestion(progression, hiddenIndex);
            rounds[i][1] = String.valueOf(hiddenValue);
        }
        return rounds;
    }

    private static String buildQuestion(int[] progression, int hiddenIndex) {
        var parts = new String[progression.length];
        for (var i = 0; i < progression.length; i++) {
            parts[i] = (i == hiddenIndex) ? ".." : String.valueOf(progression[i]);
        }
        return String.join(" ", parts);
    }

    private static int[] buildProgression(
        int start,
        int step,
        int length
    ) {
        var progression = new int[length];
        for (var i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }
        return progression;
    }

}
