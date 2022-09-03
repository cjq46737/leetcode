/*
 * @projectName leetcode
 * @package com.cjq.leetcode.sync
 * @className com.cjq.leetcode.sync.TestSynchronizdeDemo2
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.sync;

/**
 * TestSynchronizdeDemo2
 * @description TODO
 * @author chenjunqi
 * @date 2022年09月01日 下午8:52
 * @version 3.0.0
 */
public class TestSynchronizedDemo2 {
    public static Object lock = new Object();

    public synchronized static void testWait() throws InterruptedException {
        lock.wait();
    }

    public synchronized static void testNotify() {
        lock.notify();
    }

    public static void main(String[] args) throws InterruptedException {
        testWait();
    }
}
