/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.equals
 * @className com.cjq.leetcode.interview.equals.TestEquals
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.equals;

/**
 * TestEquals
 * @description 测试==和equals
 * @author chenjunqi
 * @date 2022年07月16日 下午9:20
 * @version 3.0.0
 */
public class TestEquals {

    public static void main(String[] args) {
        short s1 = 1;
        int i1 = 1;
        System.out.println(s1 == i1);

        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(2);
        System.out.println(integer1 == integer2);

    }
}
