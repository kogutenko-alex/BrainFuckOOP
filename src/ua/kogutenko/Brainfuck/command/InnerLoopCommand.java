package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.memory.Memory;

import java.util.ArrayList;

public class InnerLoopCommand implements Command {

    protected ArrayList<Command> arrayCommand = new ArrayList<>();

    public <T extends Command> boolean addCommand (T command) {
        return arrayCommand.add(command);
    }

    @Override
    public void execute(Memory memory) {
        Command command;
        for (Command value : arrayCommand) {
            command = value;
            command.execute(memory);
        }
    }
}
