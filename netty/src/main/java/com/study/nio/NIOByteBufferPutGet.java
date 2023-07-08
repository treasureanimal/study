package com.study.nio;

import java.nio.ByteBuffer;

/**
 * @author zhangxiaoxiong
 */
public class NIOByteBufferPutGet {
    public static void main(String[] args) {
        //创建一个ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocateDirect(64);
        //类型化方式放入数据
        buffer.putInt(100);
        buffer.putLong(9);
        buffer.putChar('尚');
        buffer.putShort((short) 4);

        //取出
        buffer.flip();

        System.out.println();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
    }
}
