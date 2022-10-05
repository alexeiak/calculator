package controller;

import static controller.expression.ExpressionPostprocessor.roundIntegeredDouble;

public class InputHandler {
    public static final String HINT_MSG = "Неверная команда :( "
          + "Используйте цифры и знаки +, -, /, *.";
    public static final String RESULT_MSG = "Результат: ";

    public static String handle(String input) {
        if (input.matches(".*[a-zA-Zа-яА-я].*")
                    || input.isEmpty()
                    || input.startsWith(" ")) {
            // TODO for symbols like ":", "#" and other
            return HINT_MSG;
        } else {
            double result = ExpressionHandler.calculate(input);
            String output = roundIntegeredDouble(result).toString();
            return RESULT_MSG + output;
        }
    }
}
