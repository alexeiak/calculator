package controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import controller.expression.ExpressionParser;
import static controller.Calculator.calculate;

public class ExpressionHandler {
    public static String getPreparedResult(String expression) {
        String preparedExpression = getPreparedExpression(expression);
        String parsedExpression = Stream.of(preparedExpression)
                      .map(ExpressionParser::parseExprWithNegativeNumbers)
                      .map(ExpressionParser::expressionToRpn)
                      .collect(Collectors.joining());
        double result = calculate(parsedExpression);

        return roundIntegeredDouble(result).toString();
    }


    private static String getPreparedExpression(String expression) {
        return Stream.of(expression)
                       .map(expr -> expression.replaceAll("\\s+", ""))
                       .map(expr -> expression.replaceAll(",", "."))
                       .collect(Collectors.joining());
    }

    private static Object roundIntegeredDouble(double result) {
        if (result % 1.0 == 0.0) {
            return (int) result;
        } else {
            return result;
        }
    }
}
