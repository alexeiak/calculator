package model.expression;

import java.util.ArrayList;
import java.util.List;

public class OperationDetector {
    public static final int MULT_DIV_PRIORITY = 3;
    public static final int SUM_SUBTR_PRIORITY = 2;

    public static final int OPEN_BRACKET_PRIORITY = 1;
    public static final int CLOSE_BRACKET_PRIORITY = 0;
    public static final int DIGITS_PRIORITY = -1;

    private static final List<Operation> OPERATIONS = new ArrayList<>();

    public static void installOperations() {
        OPERATIONS.add(new Operation('+', SUM_SUBTR_PRIORITY) {
            @Override
            public double execute(Double a, Double b) {
                return b + a;
            }
        });
        OPERATIONS.add(new Operation('-', SUM_SUBTR_PRIORITY) {
            @Override
            public double execute(Double a, Double b) {
                return b - a;
            }
        });
        OPERATIONS.add(new Operation('*', MULT_DIV_PRIORITY) {
            @Override
            public double execute(Double a, Double b) {
                return b * a;
            }
        });
        OPERATIONS.add(new Operation('/', MULT_DIV_PRIORITY) {
            @Override
            public double execute(Double a, Double b) {
                return b / a;
            }
        });
    }

    public static int getPriorityOfSign(char sign) {
        int priority = DIGITS_PRIORITY;

        for (Operation operation : OperationDetector.getOperations()) {
            if (sign == operation.getSign()) {
                priority = operation.getPriority();
            }
            if (sign == '(') {
                priority = OPEN_BRACKET_PRIORITY;
            }
            if (sign == ')') {
                priority = CLOSE_BRACKET_PRIORITY;
            }
        }
        return priority;
    }

    public static List<Operation> getOperations() {
        return OPERATIONS;
    }
}
