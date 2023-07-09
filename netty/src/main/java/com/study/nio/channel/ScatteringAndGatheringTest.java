package com.study.nio.channel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author zhangxiaoxiong
 * Scattering：将数据写入到 buffer 时，可以采用 buffer 数组，依次写入 [分散]
 * Gathering：从 buffer 读取数据时，可以采用 buffer 数组，依次读
 */
public class ScatteringAndGatheringTest {
    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        //绑定端口到socket，并启动
        serverSocketChannel.socket().bind(inetSocketAddress);
        //创建byffer数组
        ByteBuffer[] buffers = new ByteBuffer[2];
        buffers[0] = ByteBuffer.allocate(5);
        buffers[1] = ByteBuffer.allocate(3);

        //等待客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();
        int messageLength = 8;
        //一直等待监听消息
        while (true) {
            int bytesRead = 0;
            while (bytesRead < messageLength) {
                long read = socketChannel.read(buffers);
                bytesRead += read;//累计读取的字节数
                System.out.println("bytesRead = " + bytesRead);
                //打印buffers中的position和limit
                Arrays.stream(buffers).map(buffer -> "position = " + buffer.position() + "limit = " + buffer.limit()).forEach(System.out::println);
            }
            //将所有的buffer进行flip
            Arrays.asList(buffers).forEach(ByteBuffer::flip);
            long byteWirte = 0;
            while (byteWirte < messageLength) {
                long write = socketChannel.write(buffers);
                byteWirte += write;
            }
            Arrays.asList(buffers).forEach(ByteBuffer::clear);
            System.out.println("bytesRead = " + bytesRead + " ,byteWrite = " + byteWirte + " ,messageLength =" +messageLength);
        }
    }
}
