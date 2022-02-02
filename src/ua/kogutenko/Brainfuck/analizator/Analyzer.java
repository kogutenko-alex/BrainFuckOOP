package ua.kogutenko.Brainfuck.analizator;

import ua.kogutenko.Brainfuck.command.*;
import ua.kogutenko.Brainfuck.executor.CommandExecutor;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class Analyzer {

    private final CommandExecutor executor = new CommandExecutor();
    private final Stack<InnerLoopCommand> stackILC = new Stack<>();
    public CommandExecutor analyzer(String code) throws Exception {
        for (byte currentByte : code.getBytes()) {
            char currentChar = (char) currentByte;

            if (!CharEnumeration.isExistChar(currentChar)) {
                throw new Exception("is not exist char: " + currentChar);
            }

            putCommandToExecutor(CharEnumeration.getCommandByChar(currentChar).getCommandObject());
        }
        return executor;
    }

    private void putCommandToExecutor(Command currentCommand) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        // добавляем цикл
        if (currentCommand instanceof InnerLoopCommand) {
            stackILC.push((InnerLoopCommand) currentCommand);
            return;
        }

        // убираем цикл
        if (currentCommand instanceof LoopCommand) {
            putCommandToBacked(currentCommand);
            return;
        }


        // добавляем команды в основной список команд если она не в цикле
        if (stackILC.isEmpty()) executor.register(currentCommand);
            // добавляем команду во внутринее команды цикла
        else stackILC.peek().addCommand(currentCommand);
    }

    private void putCommandToBacked(Command currentCommand) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        InnerLoopCommand command = stackILC.pop();
        if (stackILC.isEmpty()) {
            executor.register(
                    currentCommand.getClass()
                            .getConstructor(InnerLoopCommand.class)
                            .newInstance(command));
        } else {
            stackILC.peek().addCommand(
                    currentCommand.getClass()
                            .getConstructor(InnerLoopCommand.class)
                            .newInstance(command));
        }
    }
}

