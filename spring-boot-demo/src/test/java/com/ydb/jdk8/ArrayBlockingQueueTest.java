package com.ydb.jdk8;

import org.junit.Test;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ligeng
 * @Date 18/9/9
 * @Time 下午6:58
 */
public class ArrayBlockingQueueTest {
    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task finished");
            }
        };
        Thread thread1 = new Thread(task);thread1.start();
        Thread thread2 = new Thread(task);thread2.start();
        Thread thread3 = new Thread(task);thread3.start();


        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String i = s.next();
            if ("break".equals(i)) {
                s.close();
                break;
            }
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
        System.out.println("exit");
    }



    @Test
    public void test1() {

    }
}
