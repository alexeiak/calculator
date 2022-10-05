package controller.expression;

import static controller.expression.Priorities.CLOSE_BRACKET_PRIORITY;
import static controller.expression.Priorities.DIGITS_PRIORITY;
import static controller.expression.Priorities.MULT_DIV_PRIORITY;
import static controller.expression.Priorities.OPEN_BRACKET_PRIORITY;
import static controller.expression.Priorities.SUM_SUBTR_PRIORITY;

public class PriorityDetector {
    public static int getPriorityOfSign(char sign) {
        if (sign == '*' || sign == '/') {
            return MULT_DIV_PRIORITY;
        }
        if (sign == '+' || sign == '-') {
            return SUM_SUBTR_PRIORITY;
        }
        if (sign == '(') {
            return OPEN_BRACKET_PRIORITY;
        }
        if (sign == ')') {
            return CLOSE_BRACKET_PRIORITY;
        } else {
            return DIGITS_PRIORITY;
        }
    }
}
