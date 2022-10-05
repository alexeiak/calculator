import controller.InputHandler;

public class App {
    public static void main(String[] args) {
        String input = Cli.getInput();

        while (!input.equals("выход")) {
            String command = InputHandler.handle(input);
            Cli.executeOrPrint(command);

            input = Cli.getInput();
        }
    }
}
