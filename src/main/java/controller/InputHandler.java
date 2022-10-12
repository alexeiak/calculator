package controller;

import static controller.ExpressionHandler.getPreparedResult;

public class InputHandler {
    public static final String HINT_MSG = "Неверная команда :( "
          + "Используйте цифры и операции";
    public static final String RESULT_MSG = "Результат: ";

    public static String handle(String input) {
        if (input.matches("[0-9()+-/*]+")
                    && !input.matches("^\\D*[0-9]*$")
                    && !input.matches("^[0-9]+\\D+$")) {

            String preparedResultOfExpression = getPreparedResult(input);
            return RESULT_MSG + preparedResultOfExpression;
        } else {
            return HINT_MSG;
        }
    }

}
