package com.ydb.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author ligeng
 * @Date 19/6/22
 * @Time 下午1:16
 */
public class ChannelDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("/Users/ligeng/Documents/source/study-test/spring-boot-demo/src/test/java/com/ydb/SpringBootDemoApplicationTests.java", "rw");
        FileChannel channel = aFile.getChannel();

        int read;
        do {
            ByteBuffer buffer = ByteBuffer.allocate(10);
            read = channel.read(buffer);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
        } while (read != -1);
        aFile.close();
    }

}
