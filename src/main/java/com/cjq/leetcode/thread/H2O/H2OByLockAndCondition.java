/*
 * @projectName leetcode
 * @package com.cjq.leetcode.thread.H2O
 * @className com.cjq.leetcode.thread.H2O.H2O
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.thread.H2O;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * H2O
 * @description TODO
 * @author chenjunqi
 * @date 2020年11月20日 16:04
 * @version 3.0.0
 */
public class H2OByLockAndCondition {

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(18, 20, 10L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000), r -> {
        Thread thread = new Thread(r);
        thread.setName("H20" + r.hashCode());
        return thread;
    });

    private Lock lock = new ReentrantLock();

    private Condition hCondition = lock.newCondition();

    private Condition oCondition = lock.newCondition();

    private volatile int hSize = 0;

    private volatile int oSize = 0;

    public H2OByLockAndCondition() {

    }

    public static void main(String[] args) throws Exception {
        Thread h = new Thread(() -> System.out.print("H "));
        Thread o = new Thread(() -> System.out.print("O "));

        H2OByLockAndCondition h2o = new H2OByLockAndCondition();
        Thread oTask = new Thread(() -> {
            try {
                h2o.oxygen(o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread hTask = new Thread(() -> {
            try {
                h2o.hydrogen(h);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //        //OHOOHOHHHHOHHOHHHH
        executor.execute(oTask);
        executor.execute(hTask);

        executor.execute(oTask);
        executor.execute(oTask);
        executor.execute(hTask);

        executor.execute(oTask);
        executor.execute(hTask);
        executor.execute(hTask);
        executor.execute(hTask);
        executor.execute(hTask);

        executor.execute(oTask);
        executor.execute(hTask);
        executor.execute(hTask);

        executor.execute(oTask);
        executor.execute(hTask);
        executor.execute(hTask);
        executor.execute(hTask);
        executor.execute(hTask);
        executor.shutdown();

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try {
            while (hSize == 2) {
                hCondition.await();
            }

            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            hSize++;
            if (hSize == 2 && oSize == 1) {
                oSize = 0;
                hSize = 0;
                hCondition.signal();
                oCondition.signal();
                return;
            }
            if (hSize == 2 && oSize == 0) {
                oCondition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            while (oSize == 1) {
                oCondition.await();
            }

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            oSize++;
            if (hSize == 2 && oSize == 1) {
                hSize = 0;
                oSize = 0;
                hCondition.signal();
                oCondition.signal();
                return;
            }
            hCondition.signal();
        } finally {
            lock.unlock();
        }

    }

}
