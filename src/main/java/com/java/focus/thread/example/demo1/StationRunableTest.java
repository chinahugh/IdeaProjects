package com.java.focus.thread.example.demo1;

/**
 * @Auther HUGH
 * @Date 2018/6/6
 * @Description StationRunable 三个售票窗口同时出售20张票;
 * 实现runable做法
 */
public class StationRunableTest {
    public static void main(String[] args) {
        StationRunable stationRunable = new StationRunable(20);
        Thread t1 = new Thread(stationRunable);
        Thread t2 = new Thread(stationRunable);
        Thread t3 = new Thread(stationRunable);
        Thread t4 = new Thread(stationRunable);
        Thread t5 = new Thread(stationRunable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class StationRunable implements Runnable {
    //票数
    private volatile int num;

    public StationRunable() {
        this(20);
    }

    public StationRunable(int num) {
        this("StationRunable", num);
    }

    public StationRunable(String name, int num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (num > 0) {
            num--;
            System.out.println(Thread.currentThread().getName() + "卖出一张票，还剩 = " + num);


        }
    }
}
