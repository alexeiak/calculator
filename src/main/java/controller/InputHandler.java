package controller;

import controller.expression.PriorityDetector;
import model.Operation;

import static controller.ExpressionHandler.getPreparedResult;

public class InputHandler {
    public static final String HINT_MSG = "Неверная команда :( "
          + "Используйте цифры и операции";
    public static final String RESULT_MSG = "Результат: ";

    public static String handle(String input) {
        if (hasAnyOperator(input)
                    && !input.matches("^\\D*[0-9]*$")
                    && !input.matches("^[0-9]+\\D+$")) {

            String preparedResultOfExpression = getPreparedResult(input);
            return RESULT_MSG + preparedResultOfExpression;
        } else {
            return HINT_MSG;
        }
    }

    private static boolean hasAnyOperator(String input) {
        int operationsSizeCounter = 0;
        int operatorMatching = 0;

        for (Operation operation : PriorityDetector.getOperations()) {
            if (input.contains(String.valueOf(operation.getSign()))) {
                operatorMatching++;
                break;
            }
            if (operationsSizeCounter == PriorityDetector.getOperations().size()) {
                break;
            }
            operationsSizeCounter++;
        }
        return operatorMatching > 0;
    }
}
