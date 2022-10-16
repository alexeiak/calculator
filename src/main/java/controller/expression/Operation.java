package controller.expression;

public abstract class Operation {
    private final int priority;
    private final char operator;

    public Operation(char sign, int priority) {
        this.operator = sign;
        this.priority = priority;
    }

    public final int getPriority() {
        return priority;
    }

    public final char getSign() {
        return operator;
    }

    public abstract double execute(Double a, Double b);
}
