package sheji.guanchazhe.eg2;

import java.util.concurrent.*;

public class SendNewPersonCouponObserver implements Observer1 {

    ExecutorService pool = Executors.newFixedThreadPool(2);

    @Override
    public void update(String message) {
        Future<String> future = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                //处理相应业务
                return "调用发券服务返回结果";
            }
        });
        // 假设等待200毫秒 没有获取到返回值结果则认为失败
        try {
            System.out.println(future.get(4000,TimeUnit.MILLISECONDS));
        } catch (Exception e) {
            // 执行异步获取失败
            // 记录日志，定时任务重试等
            e.printStackTrace();
        }
        // 第一种不关心返回值结果
        new Thread(() ->{
            // 模拟服务调用 线程睡3秒钟
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("发送新人优惠券");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("执行异步返回");
    }
}
