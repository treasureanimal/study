package futureTask.eg1;

import java.util.concurrent.FutureTask;

public class Test5 {
    public static void main(String[] args) {
        doTaskWithResultInWorker();
    }

    private static void doTaskWithResultInWorker() {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
                System.out.println("Task starts");
                Thread.sleep(1000);
                int result = 0;
                for (int i=0; i<=100; i++) {
                    result += i;
                }
                System.out.println("Task finished and return result");
                return result;

        });

        new Thread(futureTask).start();
        try {
            System.out.println("Before futureTask.get()");
            System.out.println("Result: " + futureTask.get());
            System.out.println("After futureTask.get()");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
