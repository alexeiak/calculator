package controller;

import static controller.expression.ExpressionPostprocessor.roundIntegeredDouble;

public class InputHandler {
    public static final String HINT_MESSAGE = "Wrong command :( "
          + "Enter a math expression";

    public static String handle(String input) {
        if (input.matches(".*[a-zA-Z].*")
                    || input.isEmpty()
                    || input.startsWith(" ")) {
            // TODO for symbols like ":", "#" and other
            return HINT_MESSAGE;
        } else {
            double result = ExpressionHandler.calculate(input);
            return roundIntegeredDouble(result).toString();
        }
    }
}
