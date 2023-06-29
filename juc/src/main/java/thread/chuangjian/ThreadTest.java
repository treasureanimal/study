package thread.chuangjian;

public class ThreadTest {
    public static void main(String[] args) {
        Run run = new Run();
        new Thread(run).start();
        new Thread(run).start();
        new Run1().start();
    }
}

class Run implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("i为:"+i+"name为:"+Thread.currentThread().getName());
        }
    }
}

class Run1 extends Thread{
    @Override
    public void run() {
super.run();
    }
}
