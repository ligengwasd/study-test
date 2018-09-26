package com.ydb.jdk8;

import org.junit.Test;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author ligeng
 * @Date 18/9/26
 * @Time 下午3:36
 */
public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        // 消费者
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("output："+queue.take().age);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        // 生产者
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String i = s.next();
            if ("break".equals(i)) {
                s.close();
                break;
            }
            queue.add(new User(Integer.valueOf(i)));
        }
    }
    private static PriorityBlockingQueue<User> queue = new PriorityBlockingQueue<User>(10);
    static {
        queue.add(new User(1));
        queue.add(new User(2));
        queue.add(new User(3));
        queue.add(new User(4));
        queue.add(new User(5));
    }


    //静态内部类
    private static class User implements Comparable<User>{

        public User(int age) {
            this.age = age;
        }

        int age;

        @Override
        public int compareTo(User o) {
            return this.age > o.age ? -1 : 1;
        }
    }


    @Test
    public void test1() {

    }
}
