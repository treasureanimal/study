package dengcha;

public class Test {
    public static void main(String[] args) {
       int s = test(10);
        System.out.println("s = " + s);
    }

    private static int test(int i) {
        // 基本情况：如果n为1，则返回1
        if (i == 1) {
            return 1;
        }
        // 递归情况：将问题分解为求n-1的总和，再加上n
        return i + test(i - 1);
    }
}
