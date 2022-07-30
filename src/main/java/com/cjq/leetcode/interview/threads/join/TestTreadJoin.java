/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.threads.join
 * @className com.cjq.leetcode.interview.threads.join.TestTreadJoin
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.threads.join;

/**
 * TestTreadJoin
 * @description 测试Thread.join()
 * @author chenjunqi
 * @date 2022年07月30日 上午9:09
 * @version 3.0.0
 */
public class TestTreadJoin {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start.....");
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        });
        thread.start();
        thread.join();
        System.out.println("end......");
    }
}
