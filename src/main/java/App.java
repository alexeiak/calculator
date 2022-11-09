import static model.expression.OperationDetector.installOperations;

public class App {
    public static void main(String[] args) {
        installOperations();
        Cli.runCalculator();
    }
}
