package ua.kogutenko.testsBrainfuck.testCommand;

import org.junit.jupiter.api.Test;
import ua.kogutenko.Brainfuck.command.NextCommand;
import ua.kogutenko.Brainfuck.command.PreviousCommand;
import ua.kogutenko.Brainfuck.memory.Memory;

import static org.junit.jupiter.api.Assertions.*;

class PreviousCommandTest {

    @Test
    void execute() {
        Memory mem = new Memory();
        int exceptedResult = mem.getCurrentIndex() - 1;
        PreviousCommand next = new PreviousCommand();
        next.execute(mem);
        int result = mem.getCurrentIndex();
        assertEquals(exceptedResult, result);
    }
}