package controller.expression;

public class ExpressionPreprocessor {

    public static String prepareExprWithNegativeNumbers(String expression) {
        StringBuilder preparedExpression = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char currentSymbol = expression.charAt(i);
            if (currentSymbol == '-') {
                /*
                * When '-' is first. Example: -2+2
                * When '-' is right after '('. Example: 3*(-2)
                * */
                if (i == 0) {
                    preparedExpression.append("0");
                } else if (expression.charAt(i - 1) == '(') {
                    preparedExpression.append("0");
                }
            }
            preparedExpression.append(currentSymbol);
        }

        return preparedExpression.toString();
    }

}
