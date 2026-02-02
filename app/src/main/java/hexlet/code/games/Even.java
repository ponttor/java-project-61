package hexlet.code.games;

import java.util.Random;

public class Even {

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public static String[][] getRounds() {
        var roundsCount = hexlet.code.Engine.getRoundsCount();
        var rounds = new String[roundsCount][2];
        var random = new Random();
        for (var i = 0; i < roundsCount; i++) {
            var number = random.nextInt(100) + 1;
            var correctAnswer = isEven(number) ? "yes" : "no";
            rounds[i][0] = String.valueOf(number);
            rounds[i][1] = correctAnswer;
        }
        return rounds;
    }
}
