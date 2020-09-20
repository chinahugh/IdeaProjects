package com.java.focus.thread;


import javax.annotation.concurrent.GuardedBy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    private static final Object o = new Object();
    @GuardedBy("o")
    private int i=0;
    public static void main(String[] args) {
        Test test = new Test();
//        new Thread(() -> {
//            for (int i = 0; i < 20; i++) {
////        synchronized (o){
//                System.out.println(i);
////        }
//                test.i=i;
//            }
//        }).start();
//        new Thread(() -> {
//            for (int i = 20; i < 40; i++) {
////                synchronized (o) {
//                    System.out.println(i);
////                }
//                test.i=i;
//            }
//        }).start();

//        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ThreadFactory namedThreadFactory = Executors.defaultThreadFactory();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory );

        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        pool.shutdown();//gracefully shutdown

    }


    public void test() {
//        new AtomicBoolean().getAndSet()

    }

}
