import org.junit.jupiter.api.Test;

import static controller.ExpressionHandler.getPreparedResult;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionHandlerTest {
    @Test
    void basicOperationsWithIntegers() {
        assertEquals("0", getPreparedResult("1+2-3"));
        assertEquals("-4", getPreparedResult("1-2-3"));
        assertEquals("3", getPreparedResult("4-2/2"));
        assertEquals("1", getPreparedResult("4*2/8"));
    }

    @Test
    void basicOperationsWithLongs() {
        assertEquals("4.4", getPreparedResult("2.2*2"));
        assertEquals("4.4", getPreparedResult("2,2*2"));
        assertEquals("4.5", getPreparedResult("9/2"));
    }

    @Test
    void withNegativeNumber() {
        assertEquals("1", getPreparedResult("-1+2"));
        assertEquals("2", getPreparedResult("(-4)/(-2)"));
        assertEquals("-2", getPreparedResult("2+(2*(-4/2))"));
    }

    @Test
    void withBrackets() {
        assertEquals("-1", getPreparedResult("1+(2-4)"));
        assertEquals("1", getPreparedResult("(4-2)/2"));
        assertEquals("2", getPreparedResult("(4+2)/(2+1)"));
    }

    @Test
    void withNestedBrackets() {
        assertEquals("7", getPreparedResult("1+(10-(2+2))"));
        assertEquals("5", getPreparedResult("(4-2)/2+(2*(4/2))"));
    }
}
