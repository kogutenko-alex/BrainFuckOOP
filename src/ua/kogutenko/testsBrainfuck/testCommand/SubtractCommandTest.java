package ua.kogutenko.testsBrainfuck.testCommand;

import org.junit.jupiter.api.Test;
import ua.kogutenko.Brainfuck.command.AddCommand;
import ua.kogutenko.Brainfuck.command.SubtractCommand;
import ua.kogutenko.Brainfuck.memory.Memory;

import static org.junit.jupiter.api.Assertions.*;

class SubtractCommandTest {

    @Test
    void execute() {
        Memory mem = new Memory();
        int exceptedResult = mem.getArrayBox() - 1;
        SubtractCommand add = new SubtractCommand();
        add.execute(mem);
        int result = mem.getArrayBox();
        assertEquals(exceptedResult, result);
    }
}