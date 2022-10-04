import org.junit.jupiter.api.Test;

import static controller.ExpressionHandler.calculate;
import static org.junit.jupiter.api.Assertions.assertEquals;

// @cs-: MagicNumber
public class ExpressionHandlerTest {
    @Test
    void basicOperations() {
        assertEquals(-4, calculate("1-2-3"));
        assertEquals(4.4, calculate("2.2*2"));
        assertEquals(2, calculate("(4+2)/(2+1)"));
        assertEquals(5, calculate("(4-2)/2+(2*(4/2))"));
    }

    @Test
    void withNegativeNumber() {
        assertEquals(1, calculate("-1+2"));
        assertEquals(2, calculate("(-4)/(-2)"));
        assertEquals(-2, calculate("2+(2*(-4/2))"));
    }
}
