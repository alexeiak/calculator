package controller.expression;

import org.junit.jupiter.api.Test;
import static controller.expression.ExpressionParser.parseExprWithNegativeNumbers;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionParserTest {
    @Test
    void whenContainsNegativeNumberThenAddZero() {
        assertEquals("0-1+2", parseExprWithNegativeNumbers("-1+2"));
        assertEquals("3*(0-1)", parseExprWithNegativeNumbers("3*(-1)"));
        assertEquals("3*(0-1)-1+(0-2)", parseExprWithNegativeNumbers("3*(-1)-1+(-2)"));
    }
}
