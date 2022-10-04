package controller.expression;

public class PriorityDetector {
    public static int getPriorityOfSymbol(char symbol) {
        if (symbol == '*' || symbol == '/') {
            return Priorities.MULT_DIV_PRIORITY;
        }
        if (symbol == '+' || symbol == '-') {
            return Priorities.SUM_SUBTR_PRIORITY;
        }
        if (symbol == '(') {
            return Priorities.OPEN_BRACKET_PRIORITY;
        }
        if (symbol == ')') {
            return Priorities.CLOSE_BRACKET_PRIORITY;
        } else {
//            if (symbol.matches("[0-9]+"))
            return Priorities.DIGITS_PRIORITY;
        }
    }
}
