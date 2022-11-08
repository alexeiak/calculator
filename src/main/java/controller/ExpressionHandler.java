package controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import controller.expression.ExpressionParser;
import controller.expression.RpnExpressionParser;

import static controller.Calculator.calculate;

public class ExpressionHandler {
    public static String getPreparedResult(String expression) {
        String parsedExpression = Stream.of(expression)
                      .map(ExpressionParser::parseExprWithNegativeNumbers)
                      .map(RpnExpressionParser::expressionToRpn)
                      .collect(Collectors.joining());

        double result = calculate(parsedExpression);
        return roundIntegeredDouble(result).toString();
    }

    public static String getPreparedExpression(String expression) {
	    return Stream.of(expression)
		                .map(expr -> clearSpaces(expression))
		                .map(expr -> expression.replaceAll(",", "."))
		                .collect(Collectors.joining());
    }

	public static String clearSpaces(String expression) {
		return expression.replaceAll("\\s+", "");
	}

    private static Object roundIntegeredDouble(double result) {
        if (result % 1.0 == 0.0) {
            return (int) result;
        } else {
            return result;
        }
    }
}
