package ua.kogutenko.Brainfuck.operationalCode;

import ua.kogutenko.Brainfuck.command.AddCommand;
import ua.kogutenko.Brainfuck.command.Command;

public class operationalCode {

    private Command type; //тип операции

    public operationalCode(Command type) {
        this.type = type;
    }

    public Command getType(){
        return type;
    }

}
