package ua.kogutenko.Brainfuck.analizator;

import ua.kogutenko.Brainfuck.command.*;
import ua.kogutenko.Brainfuck.executor.CommandExecutor;
import ua.kogutenko.Brainfuck.memory.Memory;

import java.util.*;

public class Analyzer {
    public static CommandExecutor analyzer(String innerCode, Memory memory) {
        String code = innerCode;
        //Создаем массив лексем (которые уже являются операшнл код и готовы к исполнению)
        CommandExecutor retValue = new CommandExecutor();
        Stack<InnerLoopCommand> stackILC = new Stack<>();
        int pos = 0, countInnerLoop = 0;
        //Приходимся по всем символам
        System.out.println(code);
//        if(isValidBrackets(code)) {
            ifNotBreakCode: {
                while (pos < code.length()) {
                    switch (code.charAt(pos++)) {
                        //Как и говорилось ранее, некоторые команды эквивалентны
                        case '>':
                            if (countInnerLoop == 0)
                                retValue.register(new NextCommand());
                            if (countInnerLoop > 0)
                                stackILC.peek().addCommand(new NextCommand());
                            break;
                        case '<':
                            if (countInnerLoop == 0)
                                retValue.register(new PreviousCommand());
                            if (countInnerLoop > 0)
                                stackILC.peek().addCommand(new PreviousCommand());
                            break;

                        case '+':
                            if (countInnerLoop == 0)
                                retValue.register(new AddCommand());
                            if (countInnerLoop > 0)
                                stackILC.peek().addCommand(new AddCommand());
                            break;
                        case '-':
                            if (countInnerLoop == 0)
                                retValue.register(new SubtractCommand());
                            if (countInnerLoop > 0)
                                stackILC.peek().addCommand(new SubtractCommand());
                            break;

                        case '.':
                            if (countInnerLoop == 0)
                                retValue.register(new WriteCommand());
                            if (countInnerLoop > 0)
                                stackILC.peek().addCommand(new WriteCommand());
                            break;
                        case '[':
                            stackILC.push(new InnerLoopCommand(memory));
                            countInnerLoop++;
                            break;
                        case ']':
                            countInnerLoop--;
                            if (countInnerLoop == 0)
                                retValue.register(new LoopCommand(stackILC.pop()));
                            if (countInnerLoop > 0) {
                                InnerLoopCommand ILC = stackILC.pop();
                                stackILC.peek().addCommand(new LoopCommand(ILC));
                            }
                            break;
                        case '\n': break;
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
//        } else {
//            System.err.println("bad code line (brackets)");
//        }
        return new CommandExecutor();
    }
//    public static boolean isValidBrackets(String input) {
//        Map<Character, Character> brackets = new HashMap<>();
//        brackets.put(']', '[');
//        Deque<Character> stack = new LinkedList<>();
//        for (char c : input.toCharArray()) {
//            if (brackets.containsValue(c)) {
//                // одна из открывающих скобок
//                stack.push(c);
//            } else if (brackets.containsKey(c)) {
//                // одна из закрывающих скобок
//                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
//                    return false;
//                }
//            }
//        }
//        // в конце стек должен быть пустым
//        return stack.isEmpty();
//    }

//    public static int findClosedBracket(String input, int index) {
//        Deque<Character> stack = new LinkedList<>();
//        char[] inputToChar = input.toCharArray();
//        for(int i = --index; i < inputToChar.length; i++){
//            if(inputToChar[i] == '['){
//                stack.push(inputToChar[i]);
//            }
//            if(inputToChar[i] == ']'){
//                stack.pop();
//            }
//            if(stack.isEmpty()){
//                return i;// the closing index of parenthesis
//            }
//        }
//        return 0;
//    }
}
