package ua.kogutenko.Brainfuck.analizator;

import ua.kogutenko.Brainfuck.command.Command;
import ua.kogutenko.Brainfuck.command.InnerLoopCommand;
import ua.kogutenko.Brainfuck.command.LoopCommand;
import ua.kogutenko.Brainfuck.executor.CommandExecutor;

import java.util.Stack;

import static ua.kogutenko.Brainfuck.analizator.CharEnumeration.*;

public class Analyzer {

    public static CommandExecutor analyzer(final String code) throws Exception {
        int pos = 0;
        String codeI = code;
        CommandExecutor retValue = new CommandExecutor();
        CharEnumeration enumChar = null;
        Stack<InnerLoopCommand> stackILC = new Stack<>();
        while (pos < code.length()){
            char character = code.charAt(pos);
            if (!isExistChar(character))
                throw new Exception("wrong character: " + character);

            enumChar = getCommandByChar(character);
            if (enumChar.getCommandObject() instanceof InnerLoopCommand) {
                stackILC.push((InnerLoopCommand) OPEN_BRACKET.getCommandObject());
                codeI = codeI.substring(++pos);
                continue;
            }
            if (enumChar.getCommandObject() instanceof LoopCommand) {
                if (!stackILC.isEmpty() && stackILC.size() > 1){
                    Command command = new LoopCommand(stackILC.pop());
                    stackILC.peek().addCommand(command);
                }
                else {
                    retValue.register(
                            CharEnumeration.CLOSE_BRACKET.getCommandClass()
                                    .getConstructor(OPEN_BRACKET.getCommandClass())
                                    .newInstance(stackILC.pop())
                    );
                }
                codeI = codeI.substring(++pos);
                continue;
            }
            if (!stackILC.isEmpty())
                stackILC.peek().addCommand(
                        enumChar.getCommandObject()
                );
            else
                retValue.register(
                        enumChar.getCommandObject()
                );
            codeI = code.substring(++pos);
        }

        if (!stackILC.isEmpty()) throw new Exception("fail with amount brackets");
        return retValue;

    }
}

