package com.study.bio;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangxiaoxiong
 */
public class BIOServer {
    public static void main(String[] args) throws Exception {
        ThreadFactory taskThreadFactory = new ThreadFactoryBuilder().setNameFormat("TaskManager-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 10,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), taskThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        //创建一个serverSocket
        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("服务器启动了");

        while (true) {
            //监听，等待接收客户连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");

            //创建一个线程与之通讯
            threadPoolExecutor.execute(() -> handler(socket));
        }

    }

    //编写一个handler方法和客户端通讯
    public static void handler(Socket socket) {
        //byte数组接收数据
        try (socket) {
            byte[] bytes = new byte[1024];
            //通过socket获取输入流
            InputStream inputStream = socket.getInputStream();
            //循环读取客户端发送的数据
            while (true) {
                //将读到的数据存放到byte中
                int read = inputStream.read(bytes);
                if (read != -1) {
                    //打印bytes数组从0开始到read结束
                    System.out.println(new String(bytes, 0, read));//输出客户端发送的数据
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭和client的连接");
        }
    }
}
