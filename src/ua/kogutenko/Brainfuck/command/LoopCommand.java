package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.memory.Memory;

public class LoopCommand implements Command {

    protected InnerLoopCommand innerLoopCommand;

    public LoopCommand ( InnerLoopCommand innerLoopCommand ) {
        this.innerLoopCommand = innerLoopCommand;
    }

    public LoopCommand() {  }

    @Override
    public void execute ( Memory memory ) {
        innerLoopCommand.execute(memory);
    }
}
