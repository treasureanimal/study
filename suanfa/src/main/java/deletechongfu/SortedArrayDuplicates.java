package deletechongfu;

/**
 * 一个有序数组nums，原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
 * 不要使用额外的数组空间，必须在原地修改输入数组饼在桑踹O(1)额外空间的条件下完成
 */
public class SortedArrayDuplicates {

    public static void main(String[] args) {
        System.out.println(removedDuplicates(new int[]{0, 1, 2, 2, 3, 3, 4}));
    }

    /**
     * 我们可以防止两个指针i和j，其中i是满指针，而j是快指针。只要nums【i】 = nums[j]，我们就怎敢j以跳过重复项
     * 当遇到nums[j] != nums[i]时，跳过重复项的运行已经结束，必须把nums[j]的值复制到nums[i+1]。然后递增i，
     * 借着将再次重复相同的过程，知道j到达数组的末尾为止
    **/
    private static int removedDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
