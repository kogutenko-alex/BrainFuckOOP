package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.array.ContainerForArray;

public class WriteCommand implements Command {

    @Override
    public void execute() {
        ContainerForArray.writeCurrent();
    }

}
