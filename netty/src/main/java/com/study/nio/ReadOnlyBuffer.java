package com.study.nio;

import java.nio.ByteBuffer;

/**
 * @author zhangxiaoxiong
 * 可以将一个普通 Buffer 转成只读 Buffer
 */
public class ReadOnlyBuffer {

    public static void main(String[] args) {
        //创建一个 buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);

        for (int i = 0; i < 64; i++) {
            buffer.put((byte) i);
        }

        buffer.flip();
        //将buffer设置为只读
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());

        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }
        //此时如果在往buffer中put数据时则会报错
        buffer.put((byte)111);
    }
}
