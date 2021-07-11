package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.array.ContainerForArray;

public class PreviousCommand implements Command {

    @Override
    public void execute() {
        ContainerForArray.prevBox();
    }

}
