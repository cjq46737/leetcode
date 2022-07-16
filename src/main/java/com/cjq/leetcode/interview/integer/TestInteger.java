/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.integer
 * @className com.cjq.leetcode.interview.integer.TestInteger
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.integer;

/**
 * TestInteger
 * @description 测试Integer对象的-128～127的缓存
 * @author chenjunqi
 * @date 2022年07月16日 下午12:08
 * @version 3.0.0
 */
public class TestInteger {

    /**
     * TestInteger
     * @description -XX:AutoBoxCacheMax=1000，增加参数后，两个计算都是返回true
     * @param args args
     * @author chenjunqi
     * @date 2022/7/16 下午12:18
     * @version 3.0.0
     */
    public static void main(String[] args) {
        Integer a = 128, b = 128, c = 127, d = 127;
        System.out.println(a == b);
        System.out.println(c == d);
    }
}
