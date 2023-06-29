package thread.join;

/**
 * @author cheche
 */
public class Test {
    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            System.out.println("A 开始等待 B");
            printNumber("A");
        });
        Thread B = new Thread(() -> {
            System.out.println("B 开始等待 A");
            try {
                A.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printNumber("B");
        });
        B.start();
        A.start();
    }

    private static void printNumber(String threadName) {
        int i=0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print: " + i);
        }
    }
}
