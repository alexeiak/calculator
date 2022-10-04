package controller.expression;

public class ExpressionPostprocessor {
    public static Object roundIntegeredDouble(double result) {
        if (String.valueOf(result).matches(".*.0$")) {
            return (int) result;
        } else {
            return result;
        }
    }
}
