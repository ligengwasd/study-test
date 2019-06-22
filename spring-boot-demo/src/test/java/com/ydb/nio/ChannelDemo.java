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

        ByteBuffer buffer = ByteBuffer.allocate(10);
        int read = channel.read(buffer);

        while (read != -1) {
//            System.out.println("read:"+read);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            read = channel.read(buffer);
        }
        aFile.close();
    }

}
