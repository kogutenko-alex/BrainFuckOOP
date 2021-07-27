package ua.kogutenko.testsBrainfuck.testCommand;

import org.junit.jupiter.api.Test;
import ua.kogutenko.Brainfuck.command.AddCommand;
import ua.kogutenko.Brainfuck.memory.Memory;

import static org.junit.jupiter.api.Assertions.*;

class AddCommandTest {

    @Test
    void execute() {
        Memory mem = new Memory();
        int exceptedResult = mem.getArrayBox() + 1;
        AddCommand add = new AddCommand();
        add.execute(mem);
        int result = mem.getArrayBox() + 1;
        assertEquals(exceptedResult, result);
    }
}