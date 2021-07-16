package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.memory.Memory;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class AddCommand implements Command {

    public AddCommand () {}

    @Override
    public void execute(Memory memory) {
        memory.changeCurrentBox(memory.getArrayBox() + 1);
    }

}
