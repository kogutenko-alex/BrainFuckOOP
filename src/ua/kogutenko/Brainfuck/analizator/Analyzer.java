package ua.kogutenko.Brainfuck.analizator;

import ua.kogutenko.Brainfuck.command.*;
import ua.kogutenko.Brainfuck.memory.Memory;
import ua.kogutenko.Brainfuck.operationalCode.operationalCode;

import java.util.*;

public class Analyzer {
    public static ArrayList<operationalCode> analyzer(Memory mem) {
        String code = mem.getCommands();
        String codeLoop = "";
        //Создаем массив лексем (которые уже являются операшнл код и готовы к исполнению)
        ArrayList<operationalCode> retValue = new ArrayList<>();
        int pos = 0;
        //Приходимся по всем символам
        System.out.println(code);
        if(isValidBrackets(code)) {
            ifNotBreakCode: {
                while (pos < code.length()) {
                    switch (code.charAt(pos++)) {
                        //Как и говорилось ранее, некоторые команды эквивалентны
                        case '>': retValue.add(new operationalCode(new NextCommand())); break;
                        case '<': retValue.add(new operationalCode(new PreviousCommand())); break;

                        case '+': retValue.add(new operationalCode(new AddCommand())); break;
                        case '-': retValue.add(new operationalCode(new SubtractCommand())); break;

                        case '.': retValue.add(new operationalCode(new WriteCommand())); break;
                        case '[':
                            char next = code.charAt(pos);
                            if((next == '+' || next == '-') && code.charAt(pos + 1) == ']') {
                                retValue.add(new operationalCode(new ZeroCommand()));
                                pos += 2;
                            } else {
                                int a = findClosedBracket(code, pos);
                                String s = code.substring( pos + 1,  a );
                                retValue.add(new operationalCode( new LoopCommand( new Memory( s ))));
                            }
                            break;
                        case ']': /**/ break;
                        /*
                        если будут дополнительные символы (фитчи) для
                        брейнфак то дополним новым кейсом
                        */
                        default: break ifNotBreakCode;
                    }
                }
                return retValue;
            }
            System.out.println("There is incorrect char!!!" +
                    "\nYour code: " + code +
                    "\nIncorrect char is: " + code.substring(pos - 1, pos));
        } else {
            System.err.println("bad code line (brackets)");
        }
        return new ArrayList<>();
    }

    public static boolean isValidBrackets(String input) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for (char c : input.toCharArray()) {
            if (brackets.containsValue(c)) {
                // одна из открывающих скобок
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                // одна из закрывающих скобок
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }
        // в конце стек должен быть пустым
        return stack.isEmpty();
    }

    public static int findClosedBracket(String input, int index) {
        Deque<Character> stack = new LinkedList<>();
        char[] inputToChar = input.toCharArray();
        for(int i = --index; i < inputToChar.length; i++){
            if(inputToChar[i] == '['){
                stack.push(inputToChar[i]);
            }
            if(inputToChar[i] == ']'){
                stack.pop();
            }
            if(stack.isEmpty()){
                return i;// the closing index of parenthesis
            }
        }
        return 0;
    }
}
