package ua.kogutenko.testsBrainfuck.testCommand;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;
import ua.kogutenko.Brainfuck.command.Command;
import ua.kogutenko.Brainfuck.command.InnerLoopCommand;
import ua.kogutenko.Brainfuck.command.LoopCommand;
import ua.kogutenko.Brainfuck.memory.Memory;

import static org.junit.jupiter.api.Assertions.*;

class LoopCommandTest {
    Mockery context = new Mockery();

    @Test
    void execute() {
        Command ILC = context.mock(Command.class);
        context.checking(new Expectations () {{
            oneOf(ILC).execute(new Memory());
        }});
    }
}