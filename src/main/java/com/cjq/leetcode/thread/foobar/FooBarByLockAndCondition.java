/*
 * @projectName leetcode
 * @package com.cjq.leetcode.thread.foobar
 * @className com.cjq.leetcode.thread.foobar.FooBarByLockAndCondition
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.thread.foobar;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * FooBarByLockAndCondition
 * @description TODO
 * @author chenjunqi
 * @date 2020年11月23日 17:33
 * @version 3.0.0
 */
public class FooBarByLockAndCondition {
    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000),
            r -> {
                Thread thread = new Thread(r);
                thread.setName("FooBar-" + r.hashCode());
                return thread;
            });

    private int n;

    private ReentrantLock lock = new ReentrantLock();

    private int state = 0;

    private Condition fooCondition = lock.newCondition();

    private Condition barCondition = lock.newCondition();

    public FooBarByLockAndCondition(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        Thread foo = new Thread(() -> {
            System.out.print("foo");
        });
        Thread bar = new Thread(() -> {
            System.out.print("bar");
        });

        FooBarByLockAndCondition fooBar = new FooBarByLockAndCondition(5);

        executor.submit(() -> {
            try {
                fooBar.foo(foo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            try {
                fooBar.bar(bar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                if (state == 1) {
                    fooCondition.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                state = 1;
                barCondition.signal();
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                if (state == 0) {
                    barCondition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                state = 0;
                fooCondition.signal();
            } finally {
                lock.unlock();
            }

        }
    }
}
