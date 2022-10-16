package controller;

import controller.expression.Operation;
import controller.expression.OperationDetector;
import java.util.Stack;

import static controller.expression.OperationDetector.DIGITS_PRIORITY;
import static controller.expression.OperationDetector.OPEN_BRACKET_PRIORITY;
import static controller.expression.OperationDetector.getPriorityOfSign;

public class Calculator {
    static final char NUMBERS_SEPARATOR = ' ';

    public static double calculate(String rpn) {
        Stack<Double> cumulativeOperands = new Stack<>();

        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == NUMBERS_SEPARATOR) {
                continue;
            }

            if (getPriorityOfSign(rpn.charAt(i)) == DIGITS_PRIORITY) {
                StringBuilder operand = new StringBuilder();

                while (rpn.charAt(i) != NUMBERS_SEPARATOR && getPriorityOfSign(rpn.charAt(i)) == DIGITS_PRIORITY) {
                    operand.append(rpn.charAt(i++));
                }
                cumulativeOperands.push(Double.parseDouble(String.valueOf(operand)));
            }

            if (getPriorityOfSign(rpn.charAt(i)) > OPEN_BRACKET_PRIORITY) {
                double a = cumulativeOperands.pop();
                double b = cumulativeOperands.pop();
                cumulativeOperands.push(executeOperation(rpn.charAt(i), a, b));
            }
        }
        return cumulativeOperands.pop();
    }

    private static double executeOperation(char operator, double a, double b) {
        double result = 0;

        for (Operation operation : OperationDetector.getOperations()) {
            if (operator == operation.getSign()) {
                result = operation.execute(a, b);
            }
        }
        return result;
    }
}
