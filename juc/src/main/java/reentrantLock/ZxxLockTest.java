package reentrantLock;

public class ZxxLockTest {

    public static ZxxLock zxxLock = new ZxxLock();
    public static void main(String[] args) {
        new Thread(() ->{
            zxxLock.lock();
            drawMoney();
            zxxLock.unlock();
        },"线程1").start();
        new Thread(() ->{
            zxxLock.lock();
            drawMoney();
            zxxLock.unlock();
        },"线程2").start();
    }

    private static void drawMoney() {

        System.out.println(Thread.currentThread().getName() + "正在取钱");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "取完钱了。。。");
    }
}
