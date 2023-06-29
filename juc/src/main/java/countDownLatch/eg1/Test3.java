package countDownLatch.eg1;

import java.util.concurrent.CountDownLatch;

public class Test3 {

    public static void main(String[] args) {
        test();

    }

    private static void test(){
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "D is waiting for other three threads");
            try {
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName() + "All done, D starts working");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        for (char threadName = 'A'; threadName <= 'C'; threadName++) {

            final String tN = String.valueOf(threadName);
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + tN + " is working");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + tN + " finished");
                countDownLatch.countDown();
            }).start();
        }
    }
}
