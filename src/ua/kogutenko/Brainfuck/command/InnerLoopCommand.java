package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.memory.Memory;

import java.util.ArrayList;

public class InnerLoopCommand implements Command {

    protected ArrayList<Command> commands = new ArrayList<>();

    public <T extends Command> boolean addCommand (T command) {
        return commands.add(command);
    }

    @Override
    public void execute(Memory memory) {
        for (Command command : commands) {
            command.execute(memory);
        }
    }
}
