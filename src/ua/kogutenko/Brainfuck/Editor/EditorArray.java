package ua.kogutenko.Brainfuck.Editor;

import ua.kogutenko.Brainfuck.analizator.Analyzer;
import ua.kogutenko.Brainfuck.command.Command;
import ua.kogutenko.Brainfuck.command.LoopCommand;
import ua.kogutenko.Brainfuck.memory.Memory;
import ua.kogutenko.Brainfuck.operationalCode.operationalCode;

import java.util.ArrayList;

public class EditorArray {

    private Memory memory;

    public EditorArray (Memory memory) {
        this.memory = memory;
    }

    public boolean init() {
        ArrayList<operationalCode> commands = Analyzer.analyzer(memory);
        Command mainCommand;
        for (operationalCode command : commands){
            mainCommand = command.getType();
            mainCommand.execute();
        }
        return false;
    }
}