package com.java.focus.thread.example.demo3;

/**
 * @Auther HUGH
 * @Date 2018/6/18
 * @Description ProducerConsumerTest
 * <p>
 * 生产者，消费者。
 * 生产者，多消费者的问题。
 * if判断标记，只有一次，会导致不该运行的线程运行了。出现了数据错误的情况。
 * while判断标记，解决了线程获取执行权后，是否要运行！
 * notify:只能唤醒一个线程，如果本方唤醒了本方，没有意义。而且while判断标记+notify会导致死锁。
 * notifyAll解决了本方线程一定会唤醒对方线程的问题。
 */
public class ProducerConsumerTest {
}
