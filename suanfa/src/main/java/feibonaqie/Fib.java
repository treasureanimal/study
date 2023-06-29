package feibonaqie;

/**
 * 求菲波那切数列数列第N位的值
 * 每一位的值等于他前两位数字之和。前两位固定0,1
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(calculate(10));
        System.out.println(calculate2 (10));
        System.out.println(iiterate (10));
    }

    //递归方式算斐波那契
    public static int calculate(int num) {
        if (num < 2) {
            return num;
        }
        return calculate(num - 1) + calculate(num - 2);
    }

    //去重递归，将重复的数据在第一次出现的时候就保存起来

    /**
     *
     * 递归得出具体数值之后，存储到一个集合（下表与数列下表一致），后面递归之前先到该集合查询一次，如果查到则
     * 无需递归，直接取值。查不到再进行递归计算
     */
    public static int calculate2(int num) {
        int[] arr = new int[num + 1];

        return recurse(arr, num);
    }

    private static int recurse(int[] arr, int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (arr[num] != 0) {
            return arr[num];
        }
        return arr[num] = recurse(arr, num - 1) + recurse(arr, num - 2);
    }

    //使用双指针迭代
    private static int iiterate(int num){
        if (num==0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int low = 0, high = 1;
        for (int i = 2; i <= num; i++) {
            int sum = low + high;
            low = high;
            high = sum;
        }
        return high;
    }
}
