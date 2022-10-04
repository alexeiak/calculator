import controller.InputHandler;

public class App {
    public static void main(String[] args) {
        String input = Cli.getInput();
        String command = InputHandler.handle(input);
        Cli.executeOrPrint(command);
    }
}
