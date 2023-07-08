package com.study.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangxiaoxiong
 * 将1.txt文件写入到2.txt
 */
public class NIOFileChannel03 {
    public static void main(String[] args) throws Exception {
        //FileInputStream，FileOutputStream中包含channel
        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel channel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel channel1 = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (true) {
            //如果不将position设置为0，则write完之后position和limit相同，那么循环再read的时候返回0，会造成死循环
            byteBuffer.clear();//清空缓冲区

            //从chanel读取缓冲区数据
            int read = channel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            //将bytebuffer中position置为0，limit为缓冲区实际大小
            byteBuffer.flip();
            //将缓冲区的数据写入到fileChannel1中，写完之后position和limit相等
            channel1.write(byteBuffer);
        }

        //关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }
}
