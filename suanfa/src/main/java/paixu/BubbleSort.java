package paixu;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1,3,5,3,2,7,33,23};
        sort1(array);
    }

    private static void sort1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
