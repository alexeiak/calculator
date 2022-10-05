package controller.expression;

import java.util.Stack;

import static controller.expression.Priorities.CLOSE_BRACKET_PRIORITY;
import static controller.expression.Priorities.DIGITS_PRIORITY;
import static controller.expression.Priorities.OPEN_BRACKET_PRIORITY;
import static controller.expression.PriorityDetector.getPriorityOfSign;

/*
* Using Reverse Polish Notation (RPN)
* */
public class ExpressionParser {
    static final String NUMBERS_STRING_SEPARATOR = " ";
    static final char NUMBERS_CHAR_SEPARATOR = ' ';

    public static String expressionToRpn(String expression) {
        StringBuilder currentSign = new StringBuilder();
        Stack<Character> signs = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char sign = expression.charAt(i);
            int signPriority = getPriorityOfSign(sign);

            if (signPriority == DIGITS_PRIORITY) {
                currentSign.append(sign);
            }
            if (signPriority == OPEN_BRACKET_PRIORITY) {
                signs.push(sign);
            }
            //todo: refactor
            if (signPriority > OPEN_BRACKET_PRIORITY) {
                currentSign.append(NUMBERS_STRING_SEPARATOR);
                if (!signs.empty()) {
                    currentSign.append(getCharHavingHigherPriority(signPriority, signs));
                }
                signs.push(sign);
            }
            if (signPriority == CLOSE_BRACKET_PRIORITY) {
                currentSign.append(NUMBERS_STRING_SEPARATOR);
                while (getPriorityOfSign(signs.peek()) != OPEN_BRACKET_PRIORITY) {
                    currentSign.append(signs.pop());
                }
                signs.pop();
            }
        }

        while (!signs.empty()) {
            currentSign.append(signs.pop());
        }
        return currentSign.toString();
    }

    public static double rpnToResult(String rpn) {
        StringBuilder operand;
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == NUMBERS_CHAR_SEPARATOR) {
                continue;
            }

            //todo: refactor
            if (getPriorityOfSign(rpn.charAt(i)) == DIGITS_PRIORITY) {
                operand = new StringBuilder();

                while (rpn.charAt(i) != NUMBERS_CHAR_SEPARATOR && getPriorityOfSign(rpn.charAt(i)) == DIGITS_PRIORITY) {
                    operand.append(rpn.charAt(i++));
                    if (i == rpn.length()) {
                        break;
                    }
                }
                stack.push(Double.parseDouble(String.valueOf(operand)));
            }

            if (getPriorityOfSign(rpn.charAt(i)) > OPEN_BRACKET_PRIORITY) {
                double a = stack.pop();
                double b = stack.pop();

                switch (rpn.charAt(i)) {
                    case '+' -> stack.push(b + a);
                    case '-' -> stack.push(b - a);
                    case '*' -> stack.push(b * a);
                    case '/' -> stack.push(b / a);
                    default ->  throw new Error("Unknown math operation");
                }
            }
        }

        return stack.pop();
    }


    static char getCharHavingHigherPriority(int signPriority, Stack<Character> signs) {
        if (getPriorityOfSign(signs.peek()) >= signPriority) {
            return signs.pop();
        }
        return '\u0000'; // empty char
    }
}
