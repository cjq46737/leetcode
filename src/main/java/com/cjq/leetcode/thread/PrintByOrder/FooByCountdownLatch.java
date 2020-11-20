/*
 * @projectName leetcode
 * @package com.cjq.leetcode.thread.PrintByOrder
 * @className com.cjq.leetcode.thread.PrintByOrder.FooByCountdownLatch
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.thread.PrintByOrder;

import java.util.concurrent.CountDownLatch;

/**
 * FooByCountdownLatch
 * @description TODO
 * @author chenjunqi
 * @date 2020年11月09日 8:51 下午
 * @version 3.0.0
 */
public class FooByCountdownLatch {

    private static final CountDownLatch first = new CountDownLatch(1);

    private static final CountDownLatch second = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        FooByCountdownLatch fooByCountdownLatch = new FooByCountdownLatch();
        Thread first = new Thread(() -> System.out.println("first"));
        Thread second = new Thread(() -> System.out.println("second"));
        Thread third = new Thread(() -> System.out.println("third"));

        fooByCountdownLatch.first(first);
        fooByCountdownLatch.second(second);
        fooByCountdownLatch.third(third);
        System.out.println();

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        first.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        second.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
