package sanfobot.parser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {

    @Test
    public void handleInput_nonExitCommands() {
        assertFalse(Parser.handleInput("Hi"));
    }

    @Test
    public void handleInput_ExitCommand() {
        assertTrue(Parser.handleInput("bye"));
    }

}
