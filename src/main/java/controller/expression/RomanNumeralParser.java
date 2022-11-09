package controller.expression;

import java.util.List;

public class RomanNumeralParser {

	public static String arabicNumeralToRoman(String arabicNumeralAsString) {
		int arabicNumeral = Integer.parseInt(arabicNumeralAsString);

		final int maxRomanNumeral = 4000;
		final int minRomanNumeral = 0;
		if ((arabicNumeral <= minRomanNumeral) || (arabicNumeral > maxRomanNumeral)) {
			throw new IllegalArgumentException(arabicNumeral + " is not in range from 0 to 4000");
		}

		StringBuilder finalRomanNumeral = new StringBuilder();
		List<RomanNumeral> allValuesOfRomanNumeral = RomanNumeral.getReverseSortedValues();

		int numberOfCurrentNumeral = 0;
		while (numberOfCurrentNumeral < allValuesOfRomanNumeral.size()) {
			RomanNumeral currentSign = allValuesOfRomanNumeral.get(numberOfCurrentNumeral);

			if (currentSign.getValue() <= arabicNumeral) {
				finalRomanNumeral.append(currentSign.name());
				arabicNumeral -= currentSign.getValue();
			} else {
				numberOfCurrentNumeral++;
			}
		}

		return finalRomanNumeral.toString();
	}

	public static String romanNumeralToArabic(String romanNumeral) {
		int finalArabicNumeral = 0;
		List<RomanNumeral> allValuesOfRomanNumeral = RomanNumeral.getReverseSortedValues();

		int numberOfCurrentNumeral = 0;
		while ((romanNumeral.length() > 0) && (numberOfCurrentNumeral < allValuesOfRomanNumeral.size())) {
			RomanNumeral currentNumeral = allValuesOfRomanNumeral.get(numberOfCurrentNumeral);

			if (romanNumeral.startsWith(currentNumeral.name())) {
				finalArabicNumeral += currentNumeral.getValue();
				romanNumeral = romanNumeral.substring(currentNumeral.name().length());
			} else {
				numberOfCurrentNumeral++;
			}
		}

		if (romanNumeral.length() > 0) {
			throw new IllegalArgumentException(romanNumeral + " cannot be converted to a Roman RomanNumeral");
		}

		return String.valueOf(finalArabicNumeral);
	}
}
