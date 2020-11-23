/*
 * @projectName leetcode
 * @package com.cjq.leetcode.thread.H2O
 * @className com.cjq.leetcode.thread.H2O.H2OByCyclicBarrierAndSemphore
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.thread.H2O;

import java.util.concurrent.*;

/**
 * H2OByCyclicBarrierAndSemphore
 * @description TODO
 * @author chenjunqi
 * @date 2020年11月23日 11:09
 * @version 3.0.0
 */
public class H2OByCyclicBarrierAndSemaphore {

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(18, 20, 10L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000), r -> {
        Thread thread = new Thread(r);
        thread.setName("H20" + r.hashCode());
        return thread;
    });

    private Semaphore hSemaphore = new Semaphore(2);

    private Semaphore oSemaphore = new Semaphore(1);

    private CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            hSemaphore.release(2);
            oSemaphore.release(1);
        }
    });

    public H2OByCyclicBarrierAndSemaphore() {

    }

    public static void main(String[] args) {
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
        //        executor.execute(hTask);
        //        executor.execute(hTask);
        //        executor.execute(oTask);
        //        executor.execute(oTask);
        //        executor.execute(hTask);
        //        executor.execute(hTask);
        //        executor.execute(oTask);
        //        executor.execute(hTask);
        //        executor.execute(hTask);
        executor.shutdown();
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();

        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
