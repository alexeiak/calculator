package model.expression;

import org.junit.jupiter.api.Test;

import static model.expression.RomanNumeralParser.arabicNumeralToRoman;
import static model.expression.RomanNumeralParser.romanNumeralToArabic;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralParserTest {
	@Test
	void romanNumeralToArabicTest() {
		assertEquals("1", romanNumeralToArabic("I"));
		assertEquals("2", romanNumeralToArabic("II"));
		assertEquals("3", romanNumeralToArabic("III"));
		assertEquals("4", romanNumeralToArabic("IV"));
		assertEquals("5", romanNumeralToArabic("V"));
		assertEquals("6", romanNumeralToArabic("VI"));
		assertEquals("7", romanNumeralToArabic("VII"));
		assertEquals("8", romanNumeralToArabic("VIII"));
		assertEquals("9", romanNumeralToArabic("IX"));
		assertEquals("10", romanNumeralToArabic("X"));
	}

	@Test
	void arabicNumeralToRomanTest() {
		assertEquals("I", arabicNumeralToRoman("1"));
		assertEquals("II", arabicNumeralToRoman("2"));
		assertEquals("III", arabicNumeralToRoman("3"));
		assertEquals("IV", arabicNumeralToRoman("4"));
		assertEquals("V", arabicNumeralToRoman("5"));
		assertEquals("VI", arabicNumeralToRoman("6"));
		assertEquals("VII", arabicNumeralToRoman("7"));
		assertEquals("VIII", arabicNumeralToRoman("8"));
		assertEquals("IX", arabicNumeralToRoman("9"));
		assertEquals("X", arabicNumeralToRoman("10"));
	}
}
