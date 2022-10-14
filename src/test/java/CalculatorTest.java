import org.junit.jupiter.api.Test;

import static controller.Calculator.calculate;
import static org.junit.jupiter.api.Assertions.assertEquals;

// @cs-: MagicNumber
public class CalculatorTest {
    @Test
    void whenRPNThenResult() {
        assertEquals(5, calculate("1 2 2 * +"));
//        assertEquals(0, calculate("1 2 + 3 -"));
//        assertEquals(1, calculate("4 2 * 8 /"));
//        assertEquals(2, calculate("4 2 + 2 1 + /"));
//        assertEquals(6, calculate("2 2 4 2 / * +"));
//        assertEquals(Double.POSITIVE_INFINITY, calculate("4 0 /"));
//        assertEquals(Double.NaN, calculate("0 0 /"));
    }
}
