package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS = 3;

    public static int getRoundsCount() {
        return ROUNDS;
    }

    public static void run(String rules, String[][] rounds) {
        var scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println(rules);

        for (var i = 0; i < ROUNDS; i++) {
            var question = rounds[i][0];
            var correctAnswer = rounds[i][1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            var answer = scanner.nextLine().trim();
            if (!answer.equals(correctAnswer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + name + "!");
    }
}
