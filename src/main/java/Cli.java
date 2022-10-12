import controller.InputHandler;
import java.util.Scanner;

public class Cli {
    public static void runCalculator() {
        String input = getInput();

        while (!input.equals("выход")) {
            String output = InputHandler.handle(input);
            System.out.println(output);

            input = getInput();
        }
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите выражение: ");

        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
}
