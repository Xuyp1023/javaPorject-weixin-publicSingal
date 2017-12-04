package com.xyp.thread.reentractlock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReteenThreadTest {

    // private static Lock lock = new ReentrantReadWriteLock();
    // private static Lock r =

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        Lock readLock = reentrantReadWriteLock.readLock();
        Lock writeLock = reentrantReadWriteLock.writeLock();

        CountDownLatch down = new CountDownLatch(1);

        for (int i = 0; i < 5; i++) {
            new Thread(new ReadThread(readLock, down, "readThread" + i)).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new WriteThread(writeLock, down, "writeThread" + i)).start();
        }

        down.countDown();

    }

}

class ReadThread implements Runnable {

    private Lock lock;

    CountDownLatch down;

    String name;

    public ReadThread(Lock lock, CountDownLatch down, String name) {
        super();
        this.lock = lock;
        this.down = down;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            down.await();
        }
        catch (InterruptedException e1) {

            e1.printStackTrace();
        }

        Long start = System.currentTimeMillis();
        lock.lock();
        try {
            try {

                Thread.currentThread().sleep(5000);
                System.out.println();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {

        }
        finally {
            lock.unlock();
            System.out.println("thread :" + this.name + "  SpeedTime=" + (System.currentTimeMillis() - start));
        }

    }

}

class WriteThread implements Runnable {

    private Lock lock;
    CountDownLatch down;

    String name;

    public WriteThread(Lock lock, CountDownLatch down, String name) {
        super();
        this.lock = lock;
        this.down = down;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            down.await();
        }
        catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        Long start = System.currentTimeMillis();
        lock.lock();
        try {
            try {

                Thread.currentThread().sleep(8000);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {

        }
        finally {
            lock.unlock();
            System.out.println("thread :" + this.name + "  SpeedTime=" + (System.currentTimeMillis() - start));
        }

    }

}