package ua.kogutenko.Brainfuck;

import ua.kogutenko.Brainfuck.analizator.Analyzer;
import ua.kogutenko.Brainfuck.executor.CommandExecutor;
import ua.kogutenko.Brainfuck.memory.Memory;

public class BrainFuckStart {
    public static void main(String[] args) {
        try {
            //String str = args[0];
            String str = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
            //String str = "++[+>]-";
            System.out.println("Length input: " + str.length());
            Memory memory = new Memory();
            CommandExecutor commandExecutor = Analyzer.analyzer(str);
            commandExecutor.execute(memory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
