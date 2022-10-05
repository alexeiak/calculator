package controller.expression;

import java.util.Stack;

import static controller.expression.Priorities.CLOSE_BRACKET_PRIORITY;
import static controller.expression.Priorities.DIGITS_PRIORITY;
import static controller.expression.Priorities.OPEN_BRACKET_PRIORITY;
import static controller.expression.Priorities.SUM_SUBTR_PRIORITY;
import static controller.expression.PriorityDetector.getPriorityOfSign;

// Using Reverse Polish Notation (RPN)
public class ExpressionParser {
    static final char NUMBERS_SEPARATOR = ' ';

    public static String expressionToRpn(String expression) {
        StringBuilder rpnExpression = new StringBuilder();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char sign = expression.charAt(i);
            int signPriority = getPriorityOfSign(sign);

            if (signPriority == DIGITS_PRIORITY) {
                rpnExpression.append(sign);
            }
            if (signPriority == OPEN_BRACKET_PRIORITY) {
                operators.push(sign);
            }
            if (signPriority == CLOSE_BRACKET_PRIORITY) {
                rpnExpression.append(NUMBERS_SEPARATOR);
                rpnExpression.append(getOperator(operators));
                operators.pop();
            }
            if (signPriority >= SUM_SUBTR_PRIORITY) {
                rpnExpression.append(NUMBERS_SEPARATOR);
                rpnExpression.append(getOperand(signPriority, operators));
                operators.push(sign);
            }
        }

        while (!operators.empty()) {
            rpnExpression.append(operators.pop());
        }
        return rpnExpression.toString();
    }


    public static double rpnToResult(String rpn) {
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


    private static StringBuilder getOperand(int signPriority, Stack<Character> signs) {
        StringBuilder operand = new StringBuilder();
        while (!signs.empty() && getPriorityOfSign(signs.peek()) >= signPriority) {
            operand.append(signs.pop());
        }
        return operand;
    }

    private static StringBuilder getOperator(Stack<Character> operators) {
        StringBuilder operator = new StringBuilder();
        while (getPriorityOfSign(operators.peek()) != OPEN_BRACKET_PRIORITY) {
            operator.append(operators.pop());
        }
        return operator;
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
