import org.junit.jupiter.api.Test;

import static controller.InputHandler.HINT_MESSAGE;
import static controller.InputHandler.handle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputHandlerTest {
    @Test
    void correctInput() {
        assertEquals("1", handle("-1+2"));
        assertEquals("-2", handle("2+(2*(-4/2))"));
        assertEquals("4.4", handle("2.2*2"));
    }

    @Test
    void wrongInput() {
        assertEquals(HINT_MESSAGE, handle("  "));
        assertEquals(HINT_MESSAGE, handle("meaningless text"));
        assertEquals(HINT_MESSAGE, handle("5+text"));
//        assertEquals(HINT_MESSAGE, handle("5")); // TODO
//        assertEquals(HINT_MESSAGE, handle("5+5;")); // TODO
    }
}
