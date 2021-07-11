package ua.kogutenko.Brainfuck.command;

import ua.kogutenko.Brainfuck.analizator.Analyzer;
import ua.kogutenko.Brainfuck.memory.Memory;
import ua.kogutenko.Brainfuck.operationalCode.operationalCode;

import java.util.ArrayList;

public class LoopCommand implements Command {
    private Memory memory;

    public LoopCommand() {

    }

    public LoopCommand(Memory memory) {
        this.memory = memory;
    }

    @Override
    public void execute() {
        ArrayList<operationalCode> commands = Analyzer.analyzer(memory);
        Command mainCommand;
        for (operationalCode command : commands){
            mainCommand = command.getType();
            mainCommand.execute();
        }
    }
}
