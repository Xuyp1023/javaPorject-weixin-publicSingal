package com.xyp.thread.reentractlock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class CASThread implements Runnable {

    private CountDownLatch cd;

    private String name;

    private UpdateInterface updateInterface;

    private Long id;

    private int data;

    private Lock lock;

    public CASThread(CountDownLatch cd, Lock lock, String name, UpdateInterface updateInterface, Long id, int data) {
        super();
        this.cd = cd;
        this.name = name;
        this.updateInterface = updateInterface;
        this.id = id;
        this.data = data;
        this.lock = lock;
    }

    @Override
    public void run() {

        try {
            cd.await();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 业务
        int oldVersion = 1;

        int result = 0;
        lock.lock();
        try {
            while (result == 0) {
                oldVersion = updateInterface.findVersionByid(id);
                int data2 = updateInterface.findDataByid(id);
                result = updateInterface.updateData(id, oldVersion, data2 + data);
                System.out.println("Tread = " + name + oldVersion + "   data  = " + data);
            }
        }
        finally {
            lock.unlock();
        }

    }

}
