package sushu;

public class Sushu {

    public static void main(String[] args) {
        System.out.println(bl(100));
        System.out.println(eratosthenes(100));

    }

    //暴力算法
    public static int bl(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    //素数 非合数

    /**
     * 利用合数的概念，素数*n必然是合数，因此可以从2开始遍历，将所有的合数做标记，
     * 将合数标记为true，j = i* i 从2* i优化而来，系数2会随着遍历递增（j+=i，相当于递增了系数2）
     * 每一个合数都会有两个比本身药效的因子（1,2除外），2*i必然会遍历到这两个因子
     * 当2递增到大于根号n时，其实后面的已经无需再判断（或者只需判读后面一段）,而2到根号n，实际上在i递增的过程中已经计算过了，
     * i实际上就相当于根号n。
     * eg. n = 25 会计算2*4=8; 3*4=12 但实际上8和12已经标记过在n=17时已经计算了
     * @param n
     * @return
     */
    public static int eratosthenes(int n) {
        boolean[] isPrime = new boolean[n];  //false代表素数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = i * i; j < n; j += i) {//j就是合数的标记位
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
}
