package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.array.ContainerForArray;

public class AddCommand implements Command {

    public AddCommand () {}

    @Override
    public void execute() {
        ContainerForArray.increment();
    }
}
