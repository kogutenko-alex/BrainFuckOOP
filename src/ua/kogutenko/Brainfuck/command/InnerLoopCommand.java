package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.memory.Memory;

import java.awt.*;
import java.util.ArrayList;

public class InnerLoopCommand implements Command {

    protected ArrayList<Command> arrayCommand = new ArrayList<>();

    public void addCommand (Command command) {
        arrayCommand.add(command);
    }

    @Override
    public void execute(Memory memory) {
        Command command;
        for (int i = 0; i < arrayCommand.size(); i++) {
            command = arrayCommand.get(i);
            command.execute(memory);
        }
    }
}
