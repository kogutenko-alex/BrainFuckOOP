package ua.kogutenko.testsBrainfuck.testMemory;

import org.junit.jupiter.api.Test;
import ua.kogutenko.Brainfuck.command.AddCommand;
import ua.kogutenko.Brainfuck.command.NextCommand;
import ua.kogutenko.Brainfuck.memory.Memory;

import static org.junit.jupiter.api.Assertions.*;

class MemoryTest {
    Memory memory = new Memory();

    @Test
    void getSizeArray() {
        assertEquals(100, memory.getSizeArray());
    }

    @Test
    void getCurrentIndex() {
        new NextCommand().execute(memory);
        assertEquals(51, memory.getCurrentIndex());
    }

    @Test
    void getArrayBox() {
        new AddCommand().execute(memory);
        assertEquals(1, memory.getArrayBox());
    }

    @Test
    void changeCurrentBox() {
        memory.changeCurrentBox(2);
        assertEquals(2, memory.getArrayBox());
    }

    @Test
    void setCurrentIndex() {
        int exceptedResult = 10;
        memory.setCurrentIndex(exceptedResult);
        assertEquals(exceptedResult, memory.getCurrentIndex());
    }
}