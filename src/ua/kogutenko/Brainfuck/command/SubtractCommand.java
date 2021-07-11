package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.array.ContainerForArray;

public class SubtractCommand implements Command {
    @Override
    public void execute() {
        ContainerForArray.decrement();
    }
}
