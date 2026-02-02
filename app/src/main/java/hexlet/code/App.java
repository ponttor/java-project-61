package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        var scanner = new java.util.Scanner(System.in);
        var choice = scanner.nextLine().trim();
        switch (choice) {
            case "1" -> Cli.greetUser();
            case "2" -> Engine.run(
                hexlet.code.games.Even.getRules(),
                hexlet.code.games.Even.getRounds()
            );
            case "3" -> Engine.run(
                hexlet.code.games.Calc.getRules(),
                hexlet.code.games.Calc.getRounds()
            );
            case "4" -> Engine.run(
                hexlet.code.games.Gcd.getRules(),
                hexlet.code.games.Gcd.getRounds()
            );
            case "5" -> Engine.run(
                hexlet.code.games.Progression.getRules(),
                hexlet.code.games.Progression.getRounds()
            );
            case "6" -> Engine.run(
                hexlet.code.games.Prime.getRules(),
                hexlet.code.games.Prime.getRounds()
            );
            default -> {
            }
        }
    }
}
