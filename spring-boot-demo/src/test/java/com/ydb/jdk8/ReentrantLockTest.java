package com.ydb.jdk8;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author ligeng
 * @Date 18/9/11
 * @Time 上午10:12
 */
public class ReentrantLockTest {
    private static final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lockInterruptibly();
                    System.out.println(System.currentTimeMillis()/1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread thread1 = new Thread(task);thread1.start();
        Thread thread2 = new Thread(task);thread2.start();
        Thread thread3 = new Thread(task);thread3.start();
    }

    @Test
    public void test1() {

    }
}
