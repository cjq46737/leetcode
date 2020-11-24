/*
 * @projectName leetcode
 * @package com.cjq.leetcode.thread.zeroevenodd
 * @className com.cjq.leetcode.thread.zeroevenodd.ZeroEvenOddByLock
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.thread.zeroevenodd;

import java.util.concurrent.locks.Condition;
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

    private ReentrantLock lock = new ReentrantLock();

    private Condition zeroCondition = lock.newCondition();

    // 偶数
    private Condition oushuCondition = lock.newCondition();

    // 奇数
    private Condition jishuCondition = lock.newCondition();

    private volatile int current = 0;

    public ZeroEvenOddByLock(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        ZeroEvenOddByLock zeroEvenOdd = new ZeroEvenOddByLock(1);
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
            while (current != 0) {
                zeroCondition.await();
            }
            for (int i = 1; i <= n; i++) {
                printNumber.accept(0);
                if (i % 2 == 1) {
                    current = 1;
                    jishuCondition.signal();
                } else {
                    current = 2;
                    oushuCondition.signal();
                }
                zeroCondition.await();
            }
            jishuCondition.signal();
            oushuCondition.signal();
        } finally {
            lock.unlock();
        }

    }

    public void even(ZeroEvenOddBySemaPhore.IntConsumer printNumber) throws InterruptedException {
        lock.lock();

        try {
            if (n <= 1) {
                return;
            }
            while (current != 2) {
                oushuCondition.await();
            }
            for (int i = 2; i <= n; i += 2) {

                printNumber.accept(i);
                current = 0;
                zeroCondition.signal();
                oushuCondition.await();
            }
        } finally {
            lock.unlock();
        }

    }

    public void odd(ZeroEvenOddBySemaPhore.IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (current != 1) {
                jishuCondition.await();
            }
            for (int i = 1; i <= n; i += 2) {
                printNumber.accept(i);
                current = 0;
                zeroCondition.signal();
                jishuCondition.await();
            }
        } finally {
            lock.unlock();
        }

    }

}
