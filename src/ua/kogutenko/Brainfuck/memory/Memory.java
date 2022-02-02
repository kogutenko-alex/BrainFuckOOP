package ua.kogutenko.Brainfuck.memory;

public final class Memory {

    private final int SIZE_ARRAY = 1000;
    private int current_index = 50;
    private final int[] array = new int[SIZE_ARRAY];

    public void plus() {
        array[current_index]++;
    }
    public void minus() {
        array[current_index]--;
    }
    public void next() {
        current_index++;
    }
    public void previous() {
        current_index--;
    }

    public int getSizeArray() {
        return SIZE_ARRAY;
    }

    public int getCurrentIndex() {
        return current_index;
    }

    public int getArrayBox() {
        return array[current_index];
    }
}
