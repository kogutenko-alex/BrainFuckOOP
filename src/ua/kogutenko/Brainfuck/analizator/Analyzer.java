package ua.kogutenko.Brainfuck.analizator;

import ua.kogutenko.Brainfuck.command.*;
import ua.kogutenko.Brainfuck.memory.Memory;
import ua.kogutenko.Brainfuck.operationalCode.operationalCode;

import java.util.ArrayList;

public class Analyzer {
    public static ArrayList<operationalCode> analyzer(Memory mem) {
        String code = mem.getCommands();
        String codeLoop = "";
        //Создаем массив лексем (которые уже являются опкодами и готовы к исполнению)
        ArrayList<operationalCode> retValue = new ArrayList<>();
        int pos = 0;
        //Приходимся по всем символам
        while (pos < code.length()) {
            switch (code.charAt(pos++)) {
                //Как и говорилось ранее, некоторые команды эквивалентны
                case '>': retValue.add(new operationalCode(new NextCommand())); break;
                case '<': retValue.add(new operationalCode(new PreviousCommand())); break;

                case '+': retValue.add(new operationalCode(new AddCommand())); break;
                case '-': retValue.add(new operationalCode(new SubtractCommand())); break;

                case '.': retValue.add(new operationalCode(new WriteCommand())); break;
                case '[':
                    codeLoop = code.substring(pos, code.lastIndexOf(']'));
                    pos += codeLoop.length();
                    retValue.add(new operationalCode(new LoopCommand(new Memory(codeLoop))));
                    break;
                case ']': /**/ break;
            }
        }

        return retValue;
    }
}
