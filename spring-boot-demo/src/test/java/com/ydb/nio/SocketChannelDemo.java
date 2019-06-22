package com.ydb.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author ligeng
 * @Date 19/6/22
 * @Time 下午3:35
 */
public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://www.baidu.com/", 80));

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead;
        do {
            bytesRead = socketChannel.read(buf);
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.println((char) buf.get());
            }
            buf.clear();
        } while (bytesRead != -1);



    }
}
