package controller;

public class InputHandler {
    public static final String HINT_MESSAGE = "Enter digits and math symbols.";

    public static String handle(String input) {
        if (input.matches(".*[a-zA-Z].*")
                    || input.isEmpty()
                    || input.startsWith(" ")) {
            // TODO for symbols like ":", "#" and other
            return HINT_MESSAGE;
        } else {
            double result = ExpressionHandler.calculate(input);
            return Double.toString(result);
        }
    }
}
