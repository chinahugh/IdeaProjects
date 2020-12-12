package com.java.focus.thread.synchronize;

/**
 * @Auther HUGH
 * @Date 2018/6/7
 * @Description SynchronizesReTest
 * 关键字synchronized拥有锁重入的功能，也就是在使用synchronized时，当一个线程得到一个对象锁后，
 * 再次请求此对象锁时是可以在得到该对象的锁的。这也证明在一个synchronized方法/块的内部调用本类
 * 的其他synchronized方法/块时，是可以永远得到锁的。
 */
public class SynchronizesReTest {
    public static void main(String[] args) {
        SynchronizesRe synchronizesRe = new SynchronizesRe();
        synchronizesRe.start();
        try {
            synchronizesRe.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("synchronizesRe = " + synchronizesRe.count);
    }
}


class SynchronizesRe extends Thread {
    public int count = 10;

    public synchronized int add() {
        System.out.println("进入add方法:" + count);
        return count++;
    }

    public synchronized int subtract() {
        System.out.println("进入subtract方法:" + count);
        return count - 2;
    }

    @Override
    public void run() {
        synchronized (this) {
            add();
            subtract();
        }
    }
}