package com.java.focus.thread.synchronize;

/**
 * @Auther HUGH
 * @Date 2018/5/31
 * @Description SynchronizedTest 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        Synchronized.main();
        Synchronized.main2();

    }
}

class Synchronized implements Runnable {
    private static int count;

    public Synchronized() {
        count = 0;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 9; i++) {
                System.out.println("Thread.currentThread().getName()" + Thread.currentThread().getName() + " ::" + count++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main() {
        //当两个并发线程(thread1和thread2)访问同一个对象(syncThread)中的synchronized代码块时，
        //在同一时刻只能有一个线程得到执行，另一个线程受阻塞，必须等待当前线程执行完这个代码块以后
        //才能执行该代码块。Thread1和thread2是互斥的，因为在执行synchronized代码块时会锁定当前
        //的对象，只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象。
        Synchronized aSynchronized = new Synchronized();
        Thread syn1 = new Thread(aSynchronized, "syn1");
        Thread syn2 = new Thread(aSynchronized, "syn2");
        syn1.start();
        syn2.start();
    }
    public static void main2() {
        //这时创建了两个SyncThread的对象，线程thread1执行的是syncThread1对象中的synchronized
        //代码(run)，而线程thread2执行的是syncThread2对象中的synchronized代码(run)；我们知道
        //synchronized锁定的是对象，这时会有两把锁分别锁定syncThread1对象和syncThread2对象，
        //而这两把锁是互不干扰的，不形成互斥，所以两个线程可以同时执行。
        Thread syn1 = new Thread(new Synchronized(), "syn1");
        Thread syn2 = new Thread(new Synchronized(), "syn2");
        syn1.start();
        syn2.start();
    }


}
