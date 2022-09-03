/*
 * @projectName leetcode
 * @package com.cjq.leetcode.sync
 * @className com.cjq.leetcode.sync.TestSynchronizde
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.sync;

/**
 * TestSynchronizde
 * @description TODO
 * @author chenjunqi
 * @date 2022年09月01日 下午9:24
 * @version 3.0.0
 */
public class TestSynchronized {

    public static final Object lock = new Object();

    public static void testWait() throws InterruptedException {
        synchronized (lock) {
            lock.wait();
        }
    }

    public static void testNotify() {
        synchronized (lock) {
            lock.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        testWait();
    }
}
