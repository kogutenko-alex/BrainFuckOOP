package ua.kogutenko.testsBrainfuck.testCommand;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;
import ua.kogutenko.Brainfuck.command.Command;
import ua.kogutenko.Brainfuck.memory.Memory;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class InnerLoopCommandTest {
    Mockery context = new Mockery();

    @Test
    void addCommand() {
        List list = context.mock(List.class);
        context.checking(new Expectations() {{
            oneOf(list).add(new Object());
        }});
    }

    @Test
    void execute() {
        int someIndex = 1;
        List list = context.mock(List.class);
        Command command = context.mock(Command.class);
        context.checking(new Expectations() {{
            oneOf(list).get(someIndex);will(returnValue(new Command() {
                @Override
                public void execute(Memory memory) {
                    //doing something
                }
            }));
            oneOf(command).execute(new Memory());
        }});
    }
}