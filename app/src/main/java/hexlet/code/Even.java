package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {
    private static final int ROUNDS = 3;

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static String askName(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static void play() {
        var scanner = new Scanner(System.in);
        var name = askName(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        var random = new Random();
        for (var i = 0; i < ROUNDS; i++) {
            var number = random.nextInt(100) + 1;
            var correctAnswer = isEven(number) ? "yes" : "no";
            System.out.println("Question: " + number);
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
