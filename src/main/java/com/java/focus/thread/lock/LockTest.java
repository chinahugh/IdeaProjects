package com.java.focus.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
private static Lock lock=new  ReentrantLock();

    public static void main(String[] args) {
        t1();
    }

    private static void t1() {
        lock.lock();
       
        try {

        }finally {
            lock.unlock();
        }
    }
}
