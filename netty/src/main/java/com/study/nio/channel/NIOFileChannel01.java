package com.study.nio.channel;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangxiaoxiong
 * 将数据写入到file01文件中
 */
public class NIOFileChannel01 {
    public static void main(String[] args) throws Exception {
        String str = "hello, world";
        //创建一个输出流
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/zhangxiaoxiong/IdeaProjects/otherProject/file01.txt");
        //通过fileOutputStream获取对应的FileChannel
        //这个fileChannel真实类型是FileChannelImpl
        FileChannel channel = fileOutputStream.getChannel();
        //创建一个缓存区ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //将str放入byteBuffer
        byteBuffer.put(str.getBytes());
        //对byteBuffer进行反转
        byteBuffer.flip();
        //将byteBuffer写入到channel
        channel.write(byteBuffer);
        fileOutputStream.close();


    }
}
