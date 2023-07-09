package com.study.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhangxiaoxiong
 */
public class NIOServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //得到一个selector对象
        Selector selector = Selector.open();
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //把serverSocketChannel注册到selector上。注册事件为
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //循环等待客户端连接
        while (true){
            //selector等待1秒，如果等于0表示没有该事件发生，则返回
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }
            //如果不等于0表示有该事件发生，获取到关注事件的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //通过selectionKeys获取到channel
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                //获取selectKey
                SelectionKey selectionKey = keyIterator.next();
                //根据key，对应通道发生的事件做相应的处理
                if(selectionKey.isAcceptable()){//如果是OP_ACCEPT表示有新客户端连接
                    //给该客户端生成一个SocketChannel，每个客户端连接都会生成不同的channel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功，生产了一个socketChannel " + socketChannel.hashCode());
                    socketChannel.configureBlocking(false);
                    //将socketChannel注册到seletor中,同时给socketChannel关联一个buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                //处理由上面if给seleor注册进去的读。
                if (selectionKey.isReadable()) {
                    //通过key获取对应的channel
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    //获取到该channel关联到buffer
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                    socketChannel.read(byteBuffer);
                    System.out.println("form 客户端 " + new String(byteBuffer.array()));
                }
                //手动从集合中移动当前的selectionKey, 防止重复操作
                keyIterator.remove();
            }

        }
    }
}
