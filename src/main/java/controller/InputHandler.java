package controller;

import static controller.ExpressionHandler.roundIntegeredDouble;

public class InputHandler {
    public static final String HINT_MSG = "Неверная команда :( "
          + "Используйте цифры и знаки +, -, /, *.";
    public static final String RESULT_MSG = "Результат: ";

    public static String handle(String input) {
        if (input.matches("[0-9()+-/*]+")
                    && !input.matches("^\\D*[0-9]*$")
                    && !input.matches("^[0-9]+\\D+$")) {

            double result = ExpressionHandler.calculate(input);
            String output = roundIntegeredDouble(result).toString();
            return RESULT_MSG + output;
        } else {
            return HINT_MSG;
        }

    }
}
