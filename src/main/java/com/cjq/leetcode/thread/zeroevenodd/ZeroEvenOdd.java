/*
 * @projectName leetcode
 * @package com.cjq.leetcode.thread.zeroevenodd
 * @className com.cjq.leetcode.thread.zeroevenodd.ZeroEvenOdd
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.thread.zeroevenodd;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ZeroEvenOdd
 * @description TODO
 * @author chenjunqi
 * @date 2020年11月23日 18:14
 * @version 3.0.0
 */
public class ZeroEvenOdd {

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 20, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000),
            r -> {
                Thread thread = new Thread(r);
                thread.setName("FooBar-" + r.hashCode());
                return thread;
            });

    private int n;

    private Semaphore zeroSemaphore = new Semaphore(1);

    // 偶数
    private Semaphore evenSemaphore = new Semaphore(0);

    // 奇数
    private Semaphore oddSemaphore = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(6);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(new IntConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(new IntConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(new IntConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                oddSemaphore.release();
            } else {
                evenSemaphore.release();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }

    }

    static class IntConsumer {
        public void accept(int x) {
            System.out.println(x);
        }
    }
}
