/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.sync
 * @className com.cjq.leetcode.interview.sync.TestSynchronizedWithJavap
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.sync;

/**
 * TestSynchronizedWithJavap
 * @description 通过javap -verose查看synchronized字节码
 * @author chenjunqi
 * @date 2022年09月04日 上午9:49
 * @version 3.0.0
 */
public class TestSynchronizedWithJavap {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        synchronized (lock) {
            System.out.println("this is synchronized area....");
        }
    }

    public synchronized void f() {
        System.out.println("this is synchorinzed method f....");
    }
}
