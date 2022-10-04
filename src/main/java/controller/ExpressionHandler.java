package controller;

import controller.expression.ExpressionParser;

import static controller.expression.ExpressionParser.expressionToRpn;
import static controller.expression.ExpressionPreprocessor.prepareExprWithNegativeNumbers;

public class ExpressionHandler {
    public static double calculate(String expression) {
        String preparedExpression = prepareExprWithNegativeNumbers(expression);
        String rpn = expressionToRpn(preparedExpression);
        return ExpressionParser.rpnToResult(rpn);
    }
}
