package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.memory.Memory;

public class SubtractCommand implements Command {
    @Override
    public void execute(Memory memory) {
        memory.changeCurrentBox(memory.getArrayBox() - 1);
    }
}
