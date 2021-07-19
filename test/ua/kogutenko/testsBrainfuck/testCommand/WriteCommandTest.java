package ua.kogutenko.testsBrainfuck.testCommand;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.kogutenko.Brainfuck.command.AddCommand;
import ua.kogutenko.Brainfuck.command.WriteCommand;
import ua.kogutenko.Brainfuck.executor.CommandExecutor;
import ua.kogutenko.Brainfuck.memory.Memory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WriteCommandTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void execute() {
        CommandExecutor executor = new CommandExecutor();
        for(int i = 0; i < 72; i++){
            executor.register(new AddCommand());
        }
        executor.register(new WriteCommand());
        Memory mem = new Memory();
        executor.execute(mem);
        String expectedResult = "H";
        String result = outputStreamCaptor.toString().trim();
        assertEquals(expectedResult, result);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


}