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
    private static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Runnable take = new Runnable() {
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

        executor.submit(take);
        executor.submit(take);
        executor.submit(take);


        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int i = s.nextInt();
            if (i==100) {
                s.close();
                break;
            }
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("SSSS");
        executor.shutdownNow();
    }



    @Test
    public void test1() {

    }
}
