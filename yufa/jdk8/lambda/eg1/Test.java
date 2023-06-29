package jdk8.lambda.eg1;

import java.util.TreeSet;

public class Test{

    public static void main(String[] args) {

        new Thread(()->
                System.out.println("这是线程1："+Thread.currentThread().getName()))
                .start();

        Runnable1 thead1 = new Runnable1();
        Runnable1 thead2 = new Runnable1();
        Runnable1 thead3 = new Runnable1();

        new Thread(thead1).start();
        new Thread(thead2).start();
        new Thread(thead3).start();


        TreeSet<String> objects = new TreeSet<>(
                (o1,o2) ->Integer.compare(o1.length(),o2.length())
        );
    }

}
