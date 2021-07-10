package ua.kogutenko.Brainfuck;

import ua.kogutenko.Brainfuck.Editor.EditorArray;
import ua.kogutenko.Brainfuck.memory.Memory;

public class BrainFuckStart {
    public static void main(String[] args) {
        EditorArray editorArray = new EditorArray(new Memory("+[-[.]-]+"));
        editorArray.init();
    }
}
