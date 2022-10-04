package expression;

import java.util.Stack;
import static expression.Priorities.CLOSE_BRACKET_PRIORITY;
import static expression.Priorities.DIGITS_PRIORITY;
import static expression.Priorities.OPEN_BRACKET_PRIORITY;
import static expression.PriorityDetector.getPriorityOfSymbol;

/*
* Using Reverse Polish Notation (RPN)
* */
public class ExpressionParser {
    private static final String NUMBERS_SEPARATOR = " ";

    public static String expressionToRpn(String expression) {
        StringBuilder currentSymbol = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            int priority = getPriorityOfSymbol(symbol);

            if (priority == DIGITS_PRIORITY) {
                currentSymbol.append(symbol);
            }
            if (priority == OPEN_BRACKET_PRIORITY) {
                stack.push(symbol);
            }
            if (priority > OPEN_BRACKET_PRIORITY) {
                currentSymbol.append(NUMBERS_SEPARATOR);
                while (!stack.empty()) {
                    if (getPriorityOfSymbol(stack.peek()) >= priority) {
                        currentSymbol.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(symbol);
            }

            if (priority == CLOSE_BRACKET_PRIORITY) {
                currentSymbol.append(NUMBERS_SEPARATOR);
                while (getPriorityOfSymbol(stack.peek()) != OPEN_BRACKET_PRIORITY) {
                    currentSymbol.append(stack.pop());
                }
                stack.pop();
            }
        }

        while (!stack.empty()) {
            currentSymbol.append(stack.pop());
        }

        return currentSymbol.toString();
    }


    public static double rpnToResult(String rpn) {
        StringBuilder operand;
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') {
                continue;
            }
            if (getPriorityOfSymbol(rpn.charAt(i)) == DIGITS_PRIORITY) {
                operand = new StringBuilder();

                while (!String.valueOf(rpn.charAt(i)).equals(" ")
                               && getPriorityOfSymbol(rpn.charAt(i)) == DIGITS_PRIORITY) {
                    operand.append(rpn.charAt(i++));

                    if (i == rpn.length()) {
                        break;
                    }
                }
                stack.push(Double.parseDouble(String.valueOf(operand)));
            }

            if (getPriorityOfSymbol(rpn.charAt(i)) > OPEN_BRACKET_PRIORITY) {
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

}
