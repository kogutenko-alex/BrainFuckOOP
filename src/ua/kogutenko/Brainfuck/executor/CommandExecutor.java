package ua.kogutenko.Brainfuck.executor;

import ua.kogutenko.Brainfuck.command.Command;
import ua.kogutenko.Brainfuck.memory.Memory;

import java.util.*;
import java.util.ArrayList;

public class CommandExecutor {
    private final List commandList = new ArrayList<Command>();

    public void register(Command command) {
        commandList.add(command);
    }

    public void execute(Memory memory) {
        for (Object command : commandList) {
            Command comExecute = (Command) command;
            comExecute.execute(memory);
        }
    }
}
