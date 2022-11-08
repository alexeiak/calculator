package controller.expression;

import java.util.List;

public class NumeralParser {

	public static String arabicNumeralToRoman(String arabicNumeral) {
		final int maxRomanNumber = 4000;
		int number = Integer.parseInt(arabicNumeral);

		if ((number <= 0) || (number > maxRomanNumber)) {
			throw new IllegalArgumentException(number + " is not in range from 0 to 4000]");
		}

		StringBuilder romanNumeral = new StringBuilder();
		List<Numeral> letters = Numeral.getReverseSortedValues();

		int i = 0;
		while ((number > 0) && (i < letters.size())) {
			Numeral currentSign = letters.get(i);

			if (currentSign.getValue() <= number) {
				romanNumeral.append(currentSign.name());
				number -= currentSign.getValue();
			} else {
				i++;
			}
		}

		return romanNumeral.toString();
	}

	public static String romanNumeralToArabic(String romanNumeral) {
		int arabicNumeral = 0;
		List<Numeral> letters = Numeral.getReverseSortedValues();

		int i = 0;
		while ((romanNumeral.length() > 0) && (i < letters.size())) {
			Numeral currentSign = letters.get(i);

			if (romanNumeral.startsWith(currentSign.name())) {
				arabicNumeral += currentSign.getValue();
				romanNumeral = romanNumeral.substring(currentSign.name().length());
			} else {
				i++;
			}
		}

		if (romanNumeral.length() > 0) {
			throw new IllegalArgumentException(romanNumeral + " cannot be converted to a Roman Numeral");
		}

		return String.valueOf(arabicNumeral);
	}
}
