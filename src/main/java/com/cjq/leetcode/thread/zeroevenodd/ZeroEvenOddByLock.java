/*
 * @projectName leetcode
 * @package com.cjq.leetcode.thread.zeroevenodd
 * @className com.cjq.leetcode.thread.zeroevenodd.ZeroEvenOddByLock
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.thread.zeroevenodd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ZeroEvenOddByLock
 * @description TODO
 * @author chenjunqi
 * @date 2020年11月23日 9:47 下午
 * @version 3.0.0
 */
public class ZeroEvenOddByLock {
    private int n;

    private Lock lock = new ReentrantLock();

    private Condition zeroCondition = lock.newCondition();

    // 偶数
    private Condition evenCondition = lock.newCondition();

    // 奇数
    private Condition oddCondition = lock.newCondition();

    private volatile boolean flag = true;

    private volatile int current = 0;

    public ZeroEvenOddByLock(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        ZeroEvenOddByLock zeroEvenOdd = new ZeroEvenOddByLock(10);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(new ZeroEvenOddBySemaPhore.IntConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(new ZeroEvenOddBySemaPhore.IntConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(new ZeroEvenOddBySemaPhore.IntConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(ZeroEvenOddBySemaPhore.IntConsumer printNumber) throws InterruptedException {
        lock.lock();

        try {
            while (!flag) {
                zeroCondition.await();
            }

            printNumber.accept(0);
            flag = false;
            if (++current % 2 == 1) {
                oddCondition.signal();
            } else {
                evenCondition.signal();
            }
        } finally {
            lock.unlock();
        }

    }

    public void even(ZeroEvenOddBySemaPhore.IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (++current % 2 == 0) {
                evenCondition.await();
            }

            printNumber.accept(current);
            flag = true;
            zeroCondition.signal();
        } finally {
            lock.unlock();
        }

    }

    public void odd(ZeroEvenOddBySemaPhore.IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (++current % 2 == 1) {
                oddCondition.await();
            }

            printNumber.accept(current);
            flag = true;
            zeroCondition.signal();
        } finally {
            lock.unlock();
        }

    }

}
