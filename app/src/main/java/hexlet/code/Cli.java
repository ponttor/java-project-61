package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String greetUser() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var scanner = new Scanner(System.in);
        var name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }
}
