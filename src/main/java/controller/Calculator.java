package controller;

import java.util.Stack;

import static controller.expression.Priorities.DIGITS_PRIORITY;
import static controller.expression.Priorities.SUM_SUBTR_PRIORITY;
import static controller.expression.PriorityDetector.getPriorityOfSign;

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

            if (getPriorityOfSign(rpn.charAt(i)) >= SUM_SUBTR_PRIORITY) {
                double a = cumulativeOperands.pop();
                double b = cumulativeOperands.pop();
                cumulativeOperands.push(executeOperation(rpn.charAt(i), a, b));
            }
        }
        return cumulativeOperands.pop();
    }

    private static double executeOperation(char operator, double a, double b) {
        switch (operator) {
            case '+' -> {
                return b + a;
            }
            case '-' -> {
                return b - a;
            }
            case '*' -> {
                return b * a;
            }
            case '/' -> {
                return b / a;
            }
            default -> throw new Error("Unknown math operation");
        }
    }
}
