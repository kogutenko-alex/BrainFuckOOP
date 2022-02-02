package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.memory.Memory;

public class PreviousCommand implements Command {

    @Override
    public void execute(Memory memory) {
        memory.previous();
    }

}
