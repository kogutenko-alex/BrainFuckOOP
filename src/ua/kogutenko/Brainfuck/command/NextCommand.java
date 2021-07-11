package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.array.ContainerForArray;

public class NextCommand implements Command {

    @Override
    public void execute() {
        ContainerForArray.nextBox();
    }

}
