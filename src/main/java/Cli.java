import java.util.Scanner;

public class Cli {
    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the expression: ");
        return scanner.nextLine();
    }

    public static void executeOrPrint(String output) {
        System.out.println(output);
    }
}
