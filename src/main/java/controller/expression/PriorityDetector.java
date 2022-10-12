package controller.expression;

public class PriorityDetector {
    public static final int MULT_DIV_PRIORITY = 3;
    public static final int SUM_SUBTR_PRIORITY = 2;

    public static final int OPEN_BRACKET_PRIORITY = 1;
    public static final int CLOSE_BRACKET_PRIORITY = 0;
    public static final int DIGITS_PRIORITY = -1;

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
