package controller.expression;

public class PriorityDetector {
    public static int getPriorityOfSign(char sign) {
        if (sign == '*' || sign == '/') {
            return Priorities.MULT_DIV_PRIORITY;
        }
        if (sign == '+' || sign == '-') {
            return Priorities.SUM_SUBTR_PRIORITY;
        }
        if (sign == '(') {
            return Priorities.OPEN_BRACKET_PRIORITY;
        }
        if (sign == ')') {
            return Priorities.CLOSE_BRACKET_PRIORITY;
        } else {
            return Priorities.DIGITS_PRIORITY;
        }
    }
}
