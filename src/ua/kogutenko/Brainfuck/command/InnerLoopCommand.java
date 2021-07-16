package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.memory.Memory;

import java.awt.*;
import java.util.ArrayList;

public class InnerLoopCommand extends LoopCommand {

    protected ArrayList<Command> arrayCommand = new ArrayList<>();
    Memory memory;

    public InnerLoopCommand(Memory memory) {
        super();
        this.memory = memory;
    }

    public void addCommand (Command command) {
        arrayCommand.add(command);
    }

    public void doingInnerCommands() {
        Command command;
        for (int i = 0; i < arrayCommand.size(); i++) {
            command = arrayCommand.get(i);
            command.execute(memory);
        }
    }
}
