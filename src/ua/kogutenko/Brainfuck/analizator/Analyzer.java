package ua.kogutenko.Brainfuck.analizator;

import ua.kogutenko.Brainfuck.command.*;
import ua.kogutenko.Brainfuck.executor.CommandExecutor;

import java.util.HashMap;
import java.util.Stack;

public class Analyzer {
    public static CommandExecutor analyzer(String innerCode) {
        int pos = 0, countInnerLoop = 0;
        String code = innerCode;
        CommandExecutor retValue = new CommandExecutor();
        Stack<InnerLoopCommand> stackILC = new Stack<>();
        HashMap commandMap = new HashMap<Character, Command>();
        commandMap.put('+', new AddCommand());
        commandMap.put('-', new SubtractCommand());
        commandMap.put('>', new NextCommand());
        commandMap.put('<', new PreviousCommand());
        commandMap.put(']', new LoopCommand());
        commandMap.put('[', new InnerLoopCommand());
        commandMap.put('.', new WriteCommand());

        while (pos < code.length()) {
            if(commandMap.containsKey(code.charAt(pos))){
                // показываем что есть цикл
                if (code.charAt(pos) == '[') {
                    stackILC.push(new InnerLoopCommand());
                    countInnerLoop++;
                }


                // убираем цикл
                if (code.charAt(pos) == ']') {
                    countInnerLoop--;
                    if (countInnerLoop == 0)
                        retValue.register(new LoopCommand(stackILC.pop()));
                    if (countInnerLoop > 0) {
                        InnerLoopCommand ILC = stackILC.pop();
                        stackILC.peek().addCommand(new LoopCommand(ILC));
                    }
                }

                // добавляем команды в основной список команд если она не в цикле
                if (countInnerLoop == 0)
                    retValue.register((Command) commandMap.get(code.charAt(pos)));
                // добавляем команду во внутринее команды цикла
                if (countInnerLoop > 0)
                    stackILC.peek().addCommand((Command) commandMap.get(code.charAt(pos)));
            }
            pos++;

        }
        return retValue;
    }
}

