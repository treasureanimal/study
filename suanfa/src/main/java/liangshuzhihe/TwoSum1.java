package liangshuzhihe;

import java.util.Arrays;

/**
 * 给定一个升序排列的整数数组numbers，从数组中找出两个数满足相加直喝等于目标书target
 * 二分查找必须通过有序才能查找
 * 双指针因为需要移动指针所以进行计算，所以也需要有序
 */
public class TwoSum1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 10)));
        System.out.println(Arrays.toString(twoPoint(new int[]{1, 2, 3, 4, 5, 6, 7}, 10)));
    }

    // 使用二分查找时间复杂度为O(N)*O(logN)空间复杂度O(1)
    private static int[] twoSearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i, high = numbers.length - 1;
            //当左右指针重合的时候，说明中间没有值
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i, mid};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{0};
    }

    //使用双指针空间复杂度O(1),时间复杂度O(N)
    public static int[] twoPoint(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low, high};
            } else if (sum < target) {
                low++;
            } else {
                high--;

            }
        }
        return new int[]{0};
    }

}

