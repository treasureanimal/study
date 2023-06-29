package paixu;

/**
 * @author admin
 */
public class SelectSort {

    /**
     * 选择排序
     * 从0~n-1中找个最小的放到0位置
     * 从1~n-1中找个最小的放到1位置
     */
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 3, 5, 1, 8};
        selectSort(arr);
    }

    private static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < n; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
        for (int j : arr) {
            System.out.print(j);
        }
    }

    private static void swap(int[] arr, int i, int minValueIndex) {
        int temp = arr[i];
        arr[i] = arr[minValueIndex];
        arr[minValueIndex] = temp;
    }
}
