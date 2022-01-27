package ua.kogutenko.Brainfuck.analizator;

import ua.kogutenko.Brainfuck.command.*;

import java.lang.reflect.InvocationTargetException;

public enum CharEnumeration {
    PLUS('+', AddCommand.class),
    MINUS('-', SubtractCommand.class),
    NEXT('>', NextCommand.class),
    PREVIOUS('<', PreviousCommand.class),
    WRITE('.', WriteCommand.class),
    CLOSE_BRACKET(']', LoopCommand.class),
    OPEN_BRACKET('[', InnerLoopCommand.class);

    private final char character;
    private final Class<? extends Command> command;

    CharEnumeration(char character, Class<? extends Command> command) {
        this.character = character;
        this.command = command;
    }

    public char getCharacter() {
        return character;
    }

    public Class<? extends Command> getCommandClass() {
        return command;
    }

    public Command getCommandObject() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return command.getConstructor().newInstance();
    }

    public static CharEnumeration getCommandByChar(char ch) throws Exception {
        for (CharEnumeration type : CharEnumeration.values())
            if (type.getCharacter() == ch) return type;
        throw new Exception("Wrong input char");
    }

    public static boolean isExistChar(char ch) {
        for (CharEnumeration type : CharEnumeration.values())
            if (type.getCharacter() == ch) return true;
        return false;
    }

}
