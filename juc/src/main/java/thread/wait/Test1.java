package thread.wait;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        waitTest();
    }

    private static void waitTest(){
        Object lock = new Object();
        System.out.println(Thread.currentThread().getName());
        Thread A = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "A 1");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "A 2");
                System.out.println(Thread.currentThread().getName() + "A 3");
            }
        });
        Thread B = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "B 1");
                System.out.println(Thread.currentThread().getName() + "B 2");
                System.out.println(Thread.currentThread().getName() + "B 3");
                lock.notify();
            }
        });
        A.start();
        B.start();
    }
}
