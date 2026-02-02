package hexlet.code.games;

import java.util.Random;

public class Calc {
    /** Maximum value for random numbers. */
    private static final int MAX_RANDOM = 100;
    /** Supported operators. */
    private static final char[] OPERATORS = {'+', '-', '*'};
    /** Game rules. */
    private static final String RULES = "What is the result of the "
        + "expression?";

    public static String getRules() {
        return RULES;
    }

    public static String[][] getRounds() {
        var roundsCount = hexlet.code.Engine.getRoundsCount();
        var rounds = new String[roundsCount][2];
        var random = new Random();
        for (var i = 0; i < roundsCount; i++) {
            var left = random.nextInt(MAX_RANDOM) + 1;
            var right = random.nextInt(MAX_RANDOM) + 1;
            var op = OPERATORS[random.nextInt(OPERATORS.length)];
            var result = calculate(left, right, op);
            rounds[i][0] = left + " " + op + " " + right;
            rounds[i][1] = String.valueOf(result);
        }
        return rounds;
    }

    private static int calculate(int left, int right, char op) {
        return switch (op) {
            case '+' -> left + right;
            case '-' -> left - right;
            default -> left * right;
        };
    }
}
