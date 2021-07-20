package ua.kogutenko.Brainfuck;

import ua.kogutenko.Brainfuck.analizator.Analyzer;
import ua.kogutenko.Brainfuck.executor.CommandExecutor;
import ua.kogutenko.Brainfuck.memory.Memory;

public class BrainFuckStart {
    public static void main(String[] args) {
        String str = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++"
        + ".>+.+++++++..+++.>++.<<+++++++++++++++.>.+++."
        + "------.--------.>+.>.";
        //String str = "+[-[.]-]+";
        Memory memory = new Memory();
        CommandExecutor commandExecutor = Analyzer.analyzer(str, memory);
        commandExecutor.execute(memory);
    }
}
