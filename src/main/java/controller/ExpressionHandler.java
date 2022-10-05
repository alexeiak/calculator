package controller;

import controller.expression.ExpressionParser;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import static controller.expression.ExpressionParser.expressionToRpn;

public class ExpressionHandler {
    public static double calculate(String expression) {
        String preparedExpression = Stream.of(expression)
            .map(ExpressionHandler::prepareExprWithNegativeNumbers)
            .map(exprsn -> exprsn.replaceAll("\\s+", ""))
            .collect(Collectors.joining());

        String rpn = expressionToRpn(preparedExpression);
        return ExpressionParser.rpnToResult(rpn);
    }

    private static String prepareExprWithNegativeNumbers(String expression) {
        StringBuilder preparedExpression = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char currentSign = expression.charAt(i);

            if (currentSign == '-' && i == 0) {
                preparedExpression.append("0");
            } else if (currentSign == '-' && expression.charAt(i - 1) == '(') {
                preparedExpression.append("0");
            }
            preparedExpression.append(currentSign);
        }

        return preparedExpression.toString();
    }

    public static Object roundIntegeredDouble(double result) {
        if (String.valueOf(result).matches(".*.0$")) {
            return (int) result;
        } else {
            return result;
        }
    }
}
