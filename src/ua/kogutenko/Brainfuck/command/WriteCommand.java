package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.memory.Memory;

public class WriteCommand implements Command {

    @Override
    public void execute(Memory memory) {
        System.out.println((char)memory.getArrayBox());
    }

}
