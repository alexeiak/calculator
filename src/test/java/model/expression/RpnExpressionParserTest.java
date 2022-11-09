package model.expression;

import org.junit.jupiter.api.Test;

import static model.expression.RpnExpressionParser.expressionToRpn;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RpnExpressionParserTest {
	@Test
	void whenExpressionThenRPN() {
		assertEquals("1 2 2 * +", expressionToRpn("1+2*2"));
		assertEquals("1 2 + 3 -", expressionToRpn("1+2-3"));
		assertEquals("4 2 * 8 /", expressionToRpn("4*2/8"));
		assertEquals("4 2 + 2 1 + /", expressionToRpn("(4+2)/(2+1)"));
		assertEquals("2 2 4 2 / * +", expressionToRpn("2+(2*(4/2))"));
	}
}
