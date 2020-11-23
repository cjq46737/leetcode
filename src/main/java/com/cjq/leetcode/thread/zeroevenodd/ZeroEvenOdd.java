/*
 * @projectName leetcode
 * @package com.cjq.leetcode.thread.zeroevenodd
 * @className com.cjq.leetcode.thread.zeroevenodd.ZeroEvenOdd
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.thread.zeroevenodd;

import java.util.concurrent.Semaphore;

/**
 * ZeroEvenOdd
 * @description TODO
 * @author chenjunqi
 * @date 2020年11月23日 18:14
 * @version 3.0.0
 */
public class ZeroEvenOdd {
    private int n;

    private int current = 0;

    private Semaphore zeroSemaphore = new Semaphore(1);

    // 偶数
    private Semaphore evenSemaphore = new Semaphore(0);

    // 奇数
    private Semaphore oddSemaphore = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        Thread zero = new Thread(() -> {
            try {
                zeroEvenOdd.zero(new IntConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread even = new Thread(() -> {
            try {
                zeroEvenOdd.even(new IntConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread odd = new Thread(() -> {
            try {
                zeroEvenOdd.odd(new IntConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        zero.start();
        even.start();
        odd.start();

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        zeroSemaphore.acquire();
        printNumber.accept(0);
        if (current == n) {
            return;
        }
        if (++current % 2 == 0) {
            evenSemaphore.release();
        } else {
            oddSemaphore.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        evenSemaphore.acquire();
        printNumber.accept(current);
        if (current == n) {
            return;
        }
        current++;
        zeroSemaphore.release();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        oddSemaphore.acquire();
        printNumber.accept(current);
        if (current == n) {
            return;
        }
        current++;
        zeroSemaphore.release();
    }

    static class IntConsumer {
        public void accept(int x) {
            System.out.println(x);
        }
    }
}
