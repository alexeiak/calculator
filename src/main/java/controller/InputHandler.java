package controller;

import static controller.ExpressionHandler.calculate;

public class InputHandler {
    public static String handle(String command) {
        double result = calculate(command);
        return Double.toString(result);
    }
}
