package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.array.ContainerForArray;
import ua.kogutenko.Brainfuck.memory.Memory;

public class ZeroCommand extends Command {
    @Override
    public void execute() {
        ContainerForArray.zeroBox();
    }
}
