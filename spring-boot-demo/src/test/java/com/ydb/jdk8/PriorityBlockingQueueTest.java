package com.ydb.jdk8;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author ligeng
 * @Date 18/9/26
 * @Time 下午3:36
 */
public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        queue.add(new User(1,"wu"));
        queue.add(new User(5,"wu5"));
        queue.add(new User(23,"wu23"));
        queue.add(new User(55,"wu55"));
        queue.add(new User(9,"wu9"));
        queue.add(new User(3,"wu3"));
        for (User user : queue) {
            try {
                System.out.println(queue.take().name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static PriorityBlockingQueue<User> queue = new PriorityBlockingQueue<User>(10);



    //静态内部类
    private static class User implements Comparable<User>{

        public User(int age,String name) {
            this.age = age;
            this.name = name;
        }

        int age;
        String name;

        @Override
        public int compareTo(User o) {
            return this.age > o.age ? -1 : 1;
        }
    }


    @Test
    public void test1() {

    }
}

//
//    public static PriorityBlockingQueue<User> queue = new PriorityBlockingQueue<User>();


