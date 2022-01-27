package ua.kogutenko.Brainfuck.executor;

import ua.kogutenko.Brainfuck.analizator.CharEnumeration;
import ua.kogutenko.Brainfuck.command.Command;
import ua.kogutenko.Brainfuck.memory.Memory;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.ArrayList;

public class CommandExecutor {
    private final List<Command> commandList = new ArrayList<>();

    public void register(Command command) {
        commandList.add(command);
    }

    public void execute(Memory memory) {
        for (Command command : commandList) {

            command.execute(memory);
        }
    }
}
