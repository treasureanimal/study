package jdk8.lambda.eg1;

public class Runnable1  implements Runnable{
    @Override
    public void run() {
        System.out.println(" 这是线程: " + Thread.currentThread().getName() );
    }
}
