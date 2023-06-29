package pailieyingbi;

/**
 * 总共有n枚硬币，将他们摆成一个阶梯形状，第k行就必须正好有K枚硬币
 * 给定一个数字n，找出可形成完整阶梯行的总行数
 * n是一个非负整数，并且在32位有符号整形的范围内
 */
public class ArrangeCoin {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(10));
        System.out.println(arrangeCoins2(10));
        System.out.println(arrangeCoins3(10));
    }

    private static int arrangeCoins(int n) {
        for (int i = 1; i <= n; i++) {
            n = n - i;
            if (n <= i) {
                return i;
            }
        }
        return 0;
    }

    //使用二分查找
    private static int arrangeCoins2(int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int cost = ((mid + 1) * mid) / 2; //数学中1-x的总和 等于（x*x+x）/2
            if (cost == n) {
                return mid;
            } else if (cost > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    //牛顿迭代
    private static int arrangeCoins3(int n) {
        if (n == 0) {
            return 0;
        }
        return (int) sqrt(n, n);
    }

    private static double sqrt(double x, int n) {
        double res = (x + (2 * n - x) / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrt(res, n);
        }
    }
}
