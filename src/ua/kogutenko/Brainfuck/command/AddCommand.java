package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.memory.Memory;

public class AddCommand implements Command {

    public AddCommand () {}

    @Override
    public void execute(Memory memory) {
        memory.plus();
    }

}
