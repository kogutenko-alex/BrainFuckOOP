package ua.kogutenko.Brainfuck.memory;

public class Memory {

    private final int SIZE_ARRAY = 100;
    private int current_index = 50;
    private int array[] = new int[SIZE_ARRAY];

    public int getSizeArray() {
        return SIZE_ARRAY;
    }
    public int getCurrentIndex() {
        return current_index;
    }
    public int getArrayBox() {
        return array[current_index];
    }

    public void changeCurrentBox(int num) {
        array[current_index] = num;
    }

    public void setCurrentIndex(int index) { current_index = index; }

}
