package qiupingfanggen;

/**
 * 在不使用sqrt(x)函数的情况下，得到x的平方根的整数部分
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(binarySearch(25));
        System.out.println(newton(25));
    }

    /**
     * x的平方根肯定在0和x之间，使用二分查找定位该数字，该数字的平方一定是最接近x的，m平方值如果大于x，
     * 则往左边找，如果小于则往右边找
     * 找到0,和x的最中间数m，
     * 如果m*m>x，则m取x/2到x的中间数字，直到m*m<x，m则为平方根的整数部分
     * 如果m*m<=x，则取0到x/2的中间值，直到两边的界限重合，找到最大的整数，则为x平方根的整数部分
     */
    //二分查找
    private static int binarySearch(int x) {
        int index = -1, l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid <= x) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }

    /**
     * 假设平方根是i 则i和x/i必然都是x的因子，而x/i必然等于i，推导出i+x/i=2*i,得出i=(i+x/i)/2
     * i可以任选一个值，只要上述公式成立，i必然就是x的平凡根，如果不成立，（i+x/i）/2得出的值进行地柜，直到正解
     */
    //牛顿迭代
    public static int newton(int x) {
        if (x == 0) {
            return 0;
        }
        return (int) sqrt(x, x);
    }

    private static double sqrt(double i, int x) {
        double res = (i + x / i) / 2;
        if (res == i) {
            return i;
        } else {
            return sqrt(res, x);
        }
    }

}
