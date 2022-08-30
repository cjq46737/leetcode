/*
 * @projectName leetcode
 * @package com.cjq.leetcode.cas
 * @className com.cjq.leetcode.cas.VolatileTest
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.cas;

/**
 * VolatileTest
 * @description volatile只保证可见行，不能保证原子性
 * @author chenjunqi
 * @date 2022年08月29日 下午9:06
 * @version 3.0.0
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static final int THREADS_COUNT = 20;

    public static void increase(){
        race++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++){
                    increase();
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1){
//            Thread.currentThread().getThreadGroup().list();
            Thread.yield();
        }
        System.out.println(race);
    }
}
