import org.junit.jupiter.api.Test;

import static controller.expression.ExpressionParser.expressionToRpn;
import static controller.expression.ExpressionParser.rpnToResult;
import static org.junit.jupiter.api.Assertions.assertEquals;

// @cs-: MagicNumber
public class ExpressionParserTest {
    @Test
    void basicOperationsWithIntegers() {
        assertEquals(0, rpnToResult(expressionToRpn("1+2-3")));
        assertEquals(-4, rpnToResult(expressionToRpn("1-2-3")));
        assertEquals(3, rpnToResult(expressionToRpn("4-2/2")));
        assertEquals(1, rpnToResult(expressionToRpn("4*2/8")));
        assertEquals(Double.POSITIVE_INFINITY, rpnToResult(expressionToRpn("4/0")));
        assertEquals(Double.NaN, rpnToResult(expressionToRpn("0/0")));
    }

    @Test
    void basicOperationsWithLongs() {
        assertEquals(4.4, rpnToResult(expressionToRpn("2.2*2")));
        assertEquals(4.5, rpnToResult(expressionToRpn("9/2")));
    }

    @Test
    void withBrackets() {
        assertEquals(-1, rpnToResult(expressionToRpn("1+(2-4)")));
        assertEquals(1, rpnToResult(expressionToRpn("(4-2)/2")));
        assertEquals(2, rpnToResult(expressionToRpn("(4+2)/(2+1)")));
    }

    @Test
    void withNestedBrackets() {
        assertEquals(7, rpnToResult(expressionToRpn("1+(10-(2+2))")));
        assertEquals(5, rpnToResult(expressionToRpn("(4-2)/2+(2*(4/2))")));
    }
}
