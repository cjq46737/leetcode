/*
 * @projectName leetcode
 * @package com.cjq.leetcode.cas
 * @className com.cjq.leetcode.cas.VolatileTestOnly2Thread
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.cas;

import java.util.concurrent.CountDownLatch;

/**
 * VolatileTestOnly2Thread
 * @description 两个线程验证线程安全问题
 * @author chenjunqi
 * @date 2022年08月30日 下午9:24
 * @version 3.0.0
 */
public class VolatileTestOnly2Thread {

    public static volatile int race = 0;

    public static final CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
           new Thread(() -> {
                for (int j = 0; j < 10000; j++){
                    race++;
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(race);
    }
}
