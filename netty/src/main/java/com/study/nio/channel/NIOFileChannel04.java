package com.study.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @author zhangxiaoxiong
 * 拷贝文件
 */
public class NIOFileChannel04 {
    public static void main(String[] args) throws Exception {
        //FileInputStream，FileOutputStream中包含channel
        FileInputStream fileInputStream = new FileInputStream("1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("2.jpg");

        FileChannel channel = fileInputStream.getChannel();
        FileChannel channel1 = fileOutputStream.getChannel();
        channel1.transferFrom(channel1,0, channel.size());

        //关闭相关的流
        channel.close();
        channel1.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
