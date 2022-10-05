import org.junit.jupiter.api.Test;

import static controller.InputHandler.HINT_MSG;
import static controller.InputHandler.RESULT_MSG;
import static controller.InputHandler.handle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputHandlerTest {
    @Test
    void correctInput() {
        assertEquals(RESULT_MSG + "1", handle("-1+2"));
        assertEquals(RESULT_MSG + "7", handle("1+(10-(2+2))"));
        assertEquals(RESULT_MSG + "4.4", handle("2.2*2"));
        assertEquals(RESULT_MSG + "1", handle("(4-2)/2"));
        assertEquals(RESULT_MSG + "-2", handle("2+(2*(-4/2))"));
    }

    @Test
    void wrongInput() {
        assertEquals(HINT_MSG, handle("  "));
        assertEquals(HINT_MSG, handle("5+text"));
        assertEquals(HINT_MSG, handle("meaningless text"));
        assertEquals(HINT_MSG, handle("t"));
        assertEquals(HINT_MSG, handle("5"));
        assertEquals(HINT_MSG, handle("5+"));
        assertEquals(HINT_MSG, handle("+5"));
        assertEquals(HINT_MSG, handle("+55"));
        assertEquals(HINT_MSG, handle("++"));
        assertEquals(HINT_MSG, handle("5+5;"));
    }
}
