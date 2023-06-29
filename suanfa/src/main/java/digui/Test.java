package digui;


public class Test {

/*
求1-10之和
 */
    public static void main(String[] args){
       int sum = sum1(10);
       System.out.println("sum = " + sum);
    }

    public static int sum1(int n){
        if(n == 1){
            return 1;
        }
        return n + sum1(n - 1);
    }
}
