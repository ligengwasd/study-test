package com.ydb.comcurrency.philoopherchopstick;

/**
 * @Author ligeng
 * @Date 19/5/4
 * @Time 下午5:13
 */
public class Chopstick {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
