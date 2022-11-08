package controller.expression;

import static controller.expression.NumeralParser.romanNumeralToArabic;

public class ExpressionParser {
    public static String parseExprWithNegativeNumbers(String expression) {
        StringBuilder preparedExpression = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char currentSign = expression.charAt(i);

            if (currentSign == '-' && i == 0) {
                preparedExpression.append("0");
            } else if (currentSign == '-' && expression.charAt(i - 1) == '(') {
                preparedExpression.append("0");
            }

            preparedExpression.append(currentSign);
        }
        return preparedExpression.toString();
    }

	public static String parseExprWithRomanNumerals(String expression) {
		StringBuilder preparedExpression = new StringBuilder();
		StringBuilder currentRomanNumeral = new StringBuilder();
		String currentArabicNumeral;

		for (int i = 0; i < expression.length(); i++) {
			char currentSign = expression.charAt(i);

			if (i == expression.length() - 1) {
				currentRomanNumeral.append(currentSign);

				currentArabicNumeral = romanNumeralToArabic(String.valueOf(currentRomanNumeral));

				preparedExpression.append(currentArabicNumeral);
			}
			if (!Character.isLetter(currentSign)) {
				currentArabicNumeral = romanNumeralToArabic(String.valueOf(currentRomanNumeral));

				preparedExpression.append(currentArabicNumeral);
				preparedExpression.append(currentSign);

				currentRomanNumeral.setLength(0);
			} else {
				currentRomanNumeral.append(currentSign);
			}
		}

		return preparedExpression.toString();
	}
}
