/*
 * @projectName leetcode
 * @package com.cjq.leetcode.sync
 * @className com.cjq.leetcode.sync.TestSynchronizdeDemo1
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.sync;

/**
 * TestSynchronizdeDemo1
 * @description 没有synchronized关键字，抛出IllegalMonitorStateException异常
 * @author chenjunqi
 * @date 2022年09月01日 下午8:39
 * @version 3.0.0
 */
public class TestSynchronizedDemo1 {

    public static Object lock = new Object();

    public static void testWait() throws InterruptedException {
        lock.wait();
    }

    public static void testNotify() {
        lock.notify();
    }

    public static void main(String[] args) throws InterruptedException {
        testWait();
    }
}
