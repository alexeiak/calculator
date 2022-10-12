import org.junit.jupiter.api.Test;

import static controller.expression.ExpressionParser.expressionToRpn;
import static controller.expression.ExpressionParser.parseExprWithNegativeNumbers;
import static org.junit.jupiter.api.Assertions.assertEquals;

// @cs-: MagicNumber
public class ExpressionParserTest {
    @Test
    void whenContainsNegativeNumberThenAddZero() {
        assertEquals("0-1+2", parseExprWithNegativeNumbers("-1+2"));
        assertEquals("3*(0-1)", parseExprWithNegativeNumbers("3*(-1)"));
        assertEquals("3*(0-1)-1+(0-2)", parseExprWithNegativeNumbers("3*(-1)-1+(-2)"));
    }

    @Test
    void whenExpressionThenRPN() {
        assertEquals("1 2 2 * +", expressionToRpn("1+2*2"));
        assertEquals("1 2 + 3 -", expressionToRpn("1+2-3"));
        assertEquals("4 2 * 8 /", expressionToRpn("4*2/8"));
        assertEquals("4 2 + 2 1 + /", expressionToRpn("(4+2)/(2+1)"));
        assertEquals("2 2 4 2 / * +", expressionToRpn("2+(2*(4/2))"));
    }
}
