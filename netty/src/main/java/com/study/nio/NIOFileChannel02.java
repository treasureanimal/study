package com.study.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangxiaoxiong
 * 将file01文件中数据读取出来并打印
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws Exception {
        //创建文件的输入流
        File file = new File("/Users/zhangxiaoxiong/IdeaProjects/otherProject/file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        //通过fileInputStream获取对应的fileChannel
        FileChannel channel = fileInputStream.getChannel();
        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        //将channel中数据读到缓冲区
        channel.read(byteBuffer);
        //将缓冲区的字节数据专程String
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();

    }
}
