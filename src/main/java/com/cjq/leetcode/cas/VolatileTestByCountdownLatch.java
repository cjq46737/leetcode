/*
 * @projectName leetcode
 * @package com.cjq.leetcode.cas
 * @className com.cjq.leetcode.cas.VolatileTestByCountdownLatch
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.cas;

import java.util.concurrent.CountDownLatch;

/**
 * VolatileTestByCountdownLatch
 * @description 通过CountDownLatch控制多线程切换
 * @author chenjunqi
 * @date 2022年08月30日 下午8:41
 * @version 3.0.0
 */
public class VolatileTestByCountdownLatch {

    public static volatile int race = 0;

    public static final int THREADS_COUNT = 20;

    public static final CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT);

    public static void increase(){
        race++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++){
                    increase();
                }
                countDownLatch.countDown();
            });
            threads[i].start();
        }
        countDownLatch.await();
        System.out.println(race);
    }
}
