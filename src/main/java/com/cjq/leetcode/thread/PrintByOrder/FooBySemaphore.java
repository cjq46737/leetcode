/*
 * @projectName leetcode
 * @package com.cjq.leetcode.thread
 * @className com.cjq.leetcode.thread.Foo
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.thread.PrintByOrder;

import java.util.concurrent.Semaphore;

/**
 * Foo
 * @description 按顺序打印
 * @author chenjunqi
 * @date 2020年11月09日 8:45 下午
 * @version 3.0.0
 */
public class FooBySemaphore {

    private static final Semaphore first = new Semaphore(0);

    private static final Semaphore second = new Semaphore(0);

    public void first(Runnable printFirst) {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        first.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        second.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
