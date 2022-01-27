package ua.kogutenko.testsBrainfuck.testCommand;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;
import ua.kogutenko.Brainfuck.command.Command;
import ua.kogutenko.Brainfuck.memory.Memory;

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