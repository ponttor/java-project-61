package hexlet.code.games;

import java.util.Random;

public class Prime {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static String getRules() {
        return RULES;
    }

    public static String[][] getRounds() {
        var roundsCount = hexlet.code.Engine.getRoundsCount();
        var rounds = new String[roundsCount][2];
        var random = new Random();
        for (var i = 0; i < roundsCount; i++) {
            var number = random.nextInt(100) + 1;
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
        for (var i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
