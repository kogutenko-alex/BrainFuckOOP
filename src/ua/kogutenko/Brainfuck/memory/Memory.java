package ua.kogutenko.Brainfuck.memory;

public class Memory {
    private String mainCommand = "";

    public Memory (String initCommand) {
        mainCommand = initCommand;
    }

    public String getCommands() {
        return mainCommand;
    }
}
