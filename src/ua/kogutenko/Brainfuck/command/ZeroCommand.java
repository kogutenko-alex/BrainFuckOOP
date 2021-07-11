package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.array.ContainerForArray;

public class ZeroCommand implements Command {
    @Override
    public void execute() {
        ContainerForArray.zeroBox();
    }
}
