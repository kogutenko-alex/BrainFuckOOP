package ua.kogutenko.Brainfuck;

import ua.kogutenko.Brainfuck.editor.EditorArray;
import ua.kogutenko.Brainfuck.memory.Memory;

public class BrainFuckStart {
    public static void main(String[] args) {
        EditorArray editorArray = new EditorArray(new Memory("+[-[.]-]!+"));
        editorArray.init();
    }
}
