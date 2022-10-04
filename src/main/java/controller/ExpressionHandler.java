package controller;

import controller.expression.ExpressionParser;
import controller.expression.ExpressionPreprocessor;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static controller.expression.ExpressionParser.expressionToRpn;

public class ExpressionHandler {
    public static double calculate(String expression) {
        String preparedExpression = Stream.of(expression)
            .map(ExpressionPreprocessor::prepareExprWithNegativeNumbers)
            .map(Utils::deleteAllSpaces)
            .collect(Collectors.joining());

        String rpn = expressionToRpn(preparedExpression);
        return ExpressionParser.rpnToResult(rpn);
    }
}
