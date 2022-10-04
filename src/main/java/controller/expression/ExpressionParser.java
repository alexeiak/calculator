package controller.expression;

import java.util.Stack;

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
            int priority = PriorityDetector.getPriorityOfSymbol(symbol);

            if (priority == Priorities.DIGITS_PRIORITY) {
                currentSymbol.append(symbol);
            }
            if (priority == Priorities.OPEN_BRACKET_PRIORITY) {
                stack.push(symbol);
            }
            if (priority > Priorities.OPEN_BRACKET_PRIORITY) {
                currentSymbol.append(NUMBERS_SEPARATOR);
                while (!stack.empty()) {
                    if (PriorityDetector.getPriorityOfSymbol(stack.peek()) >= priority) {
                        currentSymbol.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(symbol);
            }

            if (priority == Priorities.CLOSE_BRACKET_PRIORITY) {
                currentSymbol.append(NUMBERS_SEPARATOR);
                while (PriorityDetector.getPriorityOfSymbol(stack.peek()) != Priorities.OPEN_BRACKET_PRIORITY) {
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
            if (PriorityDetector.getPriorityOfSymbol(rpn.charAt(i)) == Priorities.DIGITS_PRIORITY) {
                operand = new StringBuilder();

                while (!String.valueOf(rpn.charAt(i)).equals(" ")
                               && PriorityDetector.getPriorityOfSymbol(rpn.charAt(i)) == Priorities.DIGITS_PRIORITY) {
                    operand.append(rpn.charAt(i++));

                    if (i == rpn.length()) {
                        break;
                    }
                }
                stack.push(Double.parseDouble(String.valueOf(operand)));
            }

            if (PriorityDetector.getPriorityOfSymbol(rpn.charAt(i)) > Priorities.OPEN_BRACKET_PRIORITY) {
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
