package ua.kogutenko.Brainfuck.array;

public class ContainerForArray {
    private static final int SIZE_ARRAY = 100;
    private static int current_index = 50;
    private static int array[] = new int[SIZE_ARRAY];

    public  static void increment() {
        array[current_index]++;
    }

    public  static void decrement() {
        array[current_index]--;
    }

    public static void nextBox() {
        current_index++;
    }

    public static void prevBox() {
        current_index--;
    }

    public static void writeCurrent() {
        System.out.println(
               array[current_index]
        );
    }

    public static void zeroBox() {
        array[current_index] = 0;
    }

}
