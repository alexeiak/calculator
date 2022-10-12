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

    public static String parseExprWithNegativeNumbers(String expression) {
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
            rpnExpression.append(NUMBERS_SEPARATOR);
            rpnExpression.append(operators.pop());
        }
        return rpnExpression.toString();
    }


    private static StringBuilder getOperand(int signPriority, Stack<Character> signs) {
        StringBuilder operand = new StringBuilder();
        while (!signs.empty() && getPriorityOfSign(signs.peek()) >= signPriority) {
            operand.append(signs.pop());
            operand.append(NUMBERS_SEPARATOR);
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
}
