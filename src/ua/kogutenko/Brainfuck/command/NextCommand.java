package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.memory.Memory;

public class NextCommand implements Command {

    @Override
    public void execute(Memory memory) {
        memory.next();
    }

}
