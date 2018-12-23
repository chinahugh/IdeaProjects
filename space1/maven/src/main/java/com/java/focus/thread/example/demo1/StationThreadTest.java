package com.java.focus.thread.example.demo1;

/**
 * @Auther HUGH
 * @Date 2018/6/6
 * @Description StationThreadTest 三个售票窗口同时出售20张票;
 */
public class StationThreadTest {
    public static void main(String[] args) {
        StationThread t1 = new StationThread(20);
        StationThread t2 = new StationThread(20);
        StationThread t3 = new StationThread(20);
        StationThread t4 = new StationThread(20);
        StationThread t5 = new StationThread(20);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class StationThread extends Thread {
    // 为了保持票数的一致，票数要静态
    private static int num;
    // 创建一个静态钥匙
    private static Object key;
    public StationThread() {
        this(20);
    }

    public StationThread(int num) {
        this("StationRunable", num);
    }

    public StationThread(String name, int num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (num > 0) {
            synchronized (key) {
                num--;
                System.out.println(Thread.currentThread().getName() + "卖出一张票，还剩 = " + num);
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
