/*
 * @projectName leetcode
 * @package com.cjq.leetcode.thread.foobar
 * @className com.cjq.leetcode.thread.foobar.FooBar
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.thread.foobar;

import lombok.SneakyThrows;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * FooBar
 * @description TODO
 * @author chenjunqi
 * @date 2020年11月23日 17:19
 * @version 3.0.0
 */
public class FooBarBySemaphore {

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000),
            r -> {
                Thread thread = new Thread(r);
                thread.setName("FooBar-" + r.hashCode());
                return thread;
            });

    private int n;

    private Semaphore fooSemaphore = new Semaphore(1);

    private Semaphore barSemaphore = new Semaphore(0);

    public FooBarBySemaphore(int n) {
        this.n = n;
    }

    public static void main(String[] args) throws Exception {
        Thread foo = new Thread(() -> {
            System.out.print("foo");
        });
        Thread bar = new Thread(() -> {
            System.out.print("bar");
        });

        FooBarBySemaphore fooBar = new FooBarBySemaphore(5);

        executor.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                fooBar.foo(foo);
            }
        });

        executor.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                fooBar.bar(bar);
            }
        });
        executor.shutdown();
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSemaphore.release();
        }
    }

}
