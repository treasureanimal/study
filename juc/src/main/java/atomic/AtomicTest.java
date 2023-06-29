package atomic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicTest {

    private static int count = 0;

    private static final Lock LOCK = new ReentrantLock();

    public static void incr() {
        LOCK.lock();
        try {
            Thread.sleep(1);
            count++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(AtomicTest::incr).start();
        }

        System.out.println("count = " + count);
    }
}
