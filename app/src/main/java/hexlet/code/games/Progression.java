package hexlet.code.games;

import java.util.Random;

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

    public static String getRules() {
        return RULES;
    }

    public static String[][] getRounds() {
        var roundsCount = hexlet.code.Engine.getRoundsCount();
        var rounds = new String[roundsCount][2];
        var random = new Random();
        for (var i = 0; i < roundsCount; i++) {
            var length = MIN_LENGTH
                + random.nextInt(MAX_LENGTH - MIN_LENGTH + 1);
            var start = random.nextInt(MAX_START) + 1;
            var step = random.nextInt(MAX_STEP) + 1;
            var hiddenIndex = random.nextInt(length);
            var progression = buildProgression(
                start,
                step,
                length,
                hiddenIndex
            );
            rounds[i][0] = progression.question;
            rounds[i][1] = String.valueOf(progression.hiddenValue);
        }
        return rounds;
    }

    private static ProgressionData buildProgression(
        int start,
        int step,
        int length,
        int hiddenIndex
    ) {
        var builder = new StringBuilder();
        var hiddenValue = 0;
        for (var i = 0; i < length; i++) {
            var current = start + i * step;
            if (i == hiddenIndex) {
                hiddenValue = current;
                builder.append("..");
            } else {
                builder.append(current);
            }
            if (i < length - 1) {
                builder.append(" ");
            }
        }
        return new ProgressionData(builder.toString(), hiddenValue);
    }

    private record ProgressionData(String question, int hiddenValue) {
    }
}
