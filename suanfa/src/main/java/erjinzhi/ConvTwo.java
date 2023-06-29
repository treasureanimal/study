package erjinzhi;

public class ConvTwo {
    //将十进制转换为二进制
    public static void main(String[] args) {
        int i = 4;
        println(i);
    }

    private static void println(int i) {

        for (int j = 31; j >= 0; j--) {
            System.out.print((i & (1 << j) )== 0  ? "0": "1");
        }
    }
}
