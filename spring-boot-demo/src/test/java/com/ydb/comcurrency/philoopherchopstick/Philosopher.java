package com.ydb.comcurrency.philoopherchopstick;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author ligeng
 * @Date 19/5/4
 * @Time 下午5:19
 */
public class Philosopher implements Runnable{
    private Chopstick left;
    private Chopstick right;

    private final int id;
    private final int ponderFactor;
    private Random random = new Random(47);

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor*250));
    }

    public Philosopher(Chopstick left,Chopstick right,int id,int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("thinking...");
                pause();
                right.take();
                left.take();
                System.out.println("eating...");
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "Philosopher："+id;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        int size=5, ponder=5;
        Chopstick[] sticks = new Chopstick[5];
        for (int i=0; i<size; i++) {
            sticks[i] = new Chopstick();
        }
        for (int i=0; i<size; i++) {
            exec.execute(new Philosopher(sticks[i], sticks[(i+1)%size], i, ponder));
        }

        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }


}
