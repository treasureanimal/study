package thread.sleep;

public class ThreadA extends Thread {
    private ThreadB b;

    public ThreadA(ThreadB b) {
        super();
        this.b = b;
    }

    @Override
    public void run() {
        try {
            synchronized (b) {
                b.start();
                //Thread.sleep(6000);
                b.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}