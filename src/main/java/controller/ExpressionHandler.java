package controller;

import controller.expression.ExpressionParser;
import static controller.expression.ExpressionParser.expressionToRpn;

public class ExpressionHandler {
    public static double calculate(String expression) {
        String rpn = expressionToRpn(expression);
        return ExpressionParser.rpnToResult(rpn);
    }
}
