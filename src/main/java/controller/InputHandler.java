package controller;


import model.expression.OperationDetector;
import model.expression.Operation;

import static controller.ExpressionHandler.clearSpaces;
import static controller.ExpressionHandler.getPreparedExpression;
import static controller.ExpressionHandler.getPreparedResult;
import static model.expression.ExpressionParser.parseExprWithRomanNumerals;
import static model.expression.RomanNumeralParser.arabicNumeralToRoman;

public class InputHandler {
    public static final String HINT_MSG = "Неверная команда :( "
          + "Используйте римские или арабские цифры";
    public static final String RESULT_MSG = "Результат: ";

    public static String handle(String input) {
		if (hasAnyOperatorFromOperationDetector(input)
		                && hasOnlyRomanNumerals(input)) {
		    String preparedExpression = clearSpaces(input);

		    String expressionWithArabicNumerals = parseExprWithRomanNumerals(preparedExpression);
		    String resultOfExpression = getPreparedResult(expressionWithArabicNumerals);
		    String resultOfExprInRomanNumerals = arabicNumeralToRoman(resultOfExpression);

		    return RESULT_MSG + resultOfExprInRomanNumerals;
	    } else if (hasAnyOperatorFromOperationDetector(input)
			            && !input.matches("^\\D*[0-9]*$")
			            && !input.matches("^[0-9]+\\D+$")) {
		    String preparedExpression = getPreparedExpression(input);
			String resultOfExpression = getPreparedResult(preparedExpression);

            return RESULT_MSG + resultOfExpression;
        } else {
            return HINT_MSG;
        }
    }


	private static boolean hasOnlyRomanNumerals(String input) {
		String preparedExpression = clearSpaces(input);
		return preparedExpression.matches("[IVXLCDM]+.{1}[IVXLCDM]+");
	}

	private static boolean hasAnyOperatorFromOperationDetector(String input) {
        int operatorMatching = 0;

        for (Operation operation : OperationDetector.getOperations()) {
            if (input.contains(String.valueOf(operation.getSign()))) {
                operatorMatching++;
                break;
            }
        }
        return operatorMatching > 0;
    }
}
