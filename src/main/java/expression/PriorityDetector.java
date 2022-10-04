package expression;

import static expression.Priorities.CLOSE_BRACKET_PRIORITY;
import static expression.Priorities.DIGITS_PRIORITY;
import static expression.Priorities.MULT_DIV_PRIORITY;
import static expression.Priorities.OPEN_BRACKET_PRIORITY;
import static expression.Priorities.SUM_SUBTR_PRIORITY;

public class PriorityDetector {
    public static int getPriorityOfSymbol(char symbol) {
        if (symbol == '*' || symbol == '/') {
            return MULT_DIV_PRIORITY;
        }
        if (symbol == '+' || symbol == '-') {
            return SUM_SUBTR_PRIORITY;
        }
        if (symbol == '(') {
            return OPEN_BRACKET_PRIORITY;
        }
        if (symbol == ')') {
            return CLOSE_BRACKET_PRIORITY;
        } else {
//            if (symbol.matches("[0-9]+"))
            return DIGITS_PRIORITY;
        }
    }
}
