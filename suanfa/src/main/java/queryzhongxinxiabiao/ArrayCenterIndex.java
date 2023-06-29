package queryzhongxinxiabiao;

import java.util.Arrays;

/**
 * 寻找数组的中心索引
 */
public class ArrayCenterIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }

    /**
     * 先统计出整个数组的总和，然后从第一个元素开始叠加
     * 综合递减当前元素，叠加递增当前元素，直到两个值相等
     * @param nums
     * @return
     */

    private static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total == sum) {
                return  i;
            }
            sum = sum - nums[i];
        }
        return -1;
    }
}
