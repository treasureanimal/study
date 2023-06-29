package paixu;

public class Test {

    public static void main(String[] args) {

        int[] test = {4, 3, 6, 7, 3, 8};
        //测试选择排序
        selectSort(test);
    }

    private static void selectSort(int[] test) {

        if (test == null || test.length < 2) {
            return;
        }

        int n = test.length;

        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                index = test[index] < test[j] ? index : j;
            }
            swap2(test, i, index);
        }

        for (int i : test) {
            System.out.print(i);
        }
    }

    private static void swap1(int[] test, int i, int index) {
        int temp = test[i];
        test[i] = test[index];
        test[index] = temp;
    }

    private static void swap2(int[] test, int i, int index) {
        test[i] ^= test[index];
        test[index] ^= test[i];
        test[i] ^= test[index];
    }

}
