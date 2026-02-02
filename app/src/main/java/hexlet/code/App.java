package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        var scanner = new java.util.Scanner(System.in);
        var choice = scanner.nextLine().trim();
        if ("1".equals(choice)) {
            Cli.greetUser();
        } else if ("2".equals(choice)) {
            Even.play();
        }
    }
}
