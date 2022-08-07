/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview
 * @className com.cjq.leetcode.interview.threads.join.synchron.Cjq
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.threads.join.synchron;

import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Cjq
 * @description 测试给静态方法加锁
 * @author chenjunqi
 * @date 2022年08月06日 上午8:31
 * @version 3.0.0
 */
public class TestSync {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("start aaaaaaaaaa");
            TestSync.f();
            System.out.println("aAaaassssssssssss");

        }).start();


        new Thread(() -> {
            System.out.println("start bbbbb");
            TestSync.f();
            System.out.println("bbbbbbbbbbbbsssss");

        }).start();

        new Thread(() -> {
            System.out.println("start cccccccc");
            TestSync.f();
            System.out.println("ccccccccc");

        }).start();
    }

    public  static synchronized void f(){
        System.out.println("this is method f......");
        try {
            Thread.sleep(5000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
