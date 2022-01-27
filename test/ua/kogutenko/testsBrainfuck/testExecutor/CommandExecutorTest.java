package ua.kogutenko.testsBrainfuck.testExecutor;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;
import ua.kogutenko.Brainfuck.command.Command;
import ua.kogutenko.Brainfuck.memory.Memory;

import java.util.List;

class CommandExecutorTest {
    Mockery context = new Mockery();

    @Test
    void register() {
        List list = context.mock(List.class);
        context.checking(new Expectations() {{
            oneOf(list).add(new Command() {
                @Override
                public void execute(Memory memory) {

                }
            });
        }});
    }

    @Test
    void execute() {
        Command command = context.mock(Command.class);
        context.checking(new Expectations() {{
            oneOf(command).execute(new Memory());
        }});
    }
}