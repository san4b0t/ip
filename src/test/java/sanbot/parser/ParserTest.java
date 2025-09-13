package sanbot.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void handleInput_nonExitCommands() {
        assertEquals(Parser.handleInput("Hi"), "Oops, I am not sure what is the task type!");
    }

    @Test
    public void handleInput_ExitCommand() {
        assertEquals(Parser.handleInput("bye"), "Your tasks have been saved. See you soon!");
    }

}
