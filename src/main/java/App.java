import static controller.expression.OperationDetector.installOperations;

public class App {
    public static void main(String[] args) {
        installOperations();
        Cli.runCalculator();
    }
}
