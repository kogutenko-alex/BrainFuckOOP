package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.analizator.Analyzer;
import ua.kogutenko.Brainfuck.memory.Memory;

public class LoopCommand implements Command {

    InnerLoopCommand innerLoopCommand;

    public LoopCommand(InnerLoopCommand innerLoopCommand) {
        this.innerLoopCommand = innerLoopCommand;
    }

    public LoopCommand() {  }

    @Override
    public void execute(Memory memory) {
        innerLoopCommand.doingInnerCommands();
    }
}
